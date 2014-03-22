package com.dataart.springtraining.service;

import com.dataart.springtraining.dto.Application;
import com.dataart.springtraining.dto.UploadItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Component
public class FileService {

    private final static String PREVIEW_IMAGE_NAME = "image.jpg";

    private final static String CONTRACT_TXT_NAME = "readme.txt";

    private final static String NAME_PREFIX = "Name:";

    private final static String PACKAGE_PREFIX = "Package:";

    private final static String DEFAULT_TYPE = "Unknown";

    private final static Logger LOG = Logger.getLogger(FileService.class);

    @Autowired
    private ImageService imageService;

    public void saveAsZip(OutputStream responseOutputStream, Application app) {
        try {
            ZipOutputStream out = new ZipOutputStream(responseOutputStream);
            //write an image
            ZipEntry entry = new ZipEntry(PREVIEW_IMAGE_NAME);
            out.putNextEntry(entry);
            out.write(app.getImage());
            out.closeEntry();

            //form and write txt file with name and package
            Charset charset = Charset.forName("UTF-8");
            String name = NAME_PREFIX.concat(app.getName()).concat("\n");
            String packageName = PACKAGE_PREFIX.concat(app.getPackageName()).concat("\n");

            entry = new ZipEntry(CONTRACT_TXT_NAME);
            out.putNextEntry(entry);
            out.write(name.getBytes(charset));
            out.write(packageName.getBytes(charset));
            out.closeEntry();

            out.close();
        } catch (IOException e) {
            LOG.error("Exception during zipping a file", e);
        }
    }

    public Application getFileForUpload(UploadItem uploadItem) {
        Application app = null;
        try {
            byte[] zip = uploadItem.getFileData().getBytes();
            app = prepareFile(zip, uploadItem.getName(), uploadItem.getDescription());

        } catch (IOException e) {
            LOG.error("Exception during saving file", e);
        }
        return app;
    }

    public Application prepareFile(byte[] zip, String name, String description) throws IOException {
        //parse zip on pics and .txt
        InputStream is = new ByteArrayInputStream(zip);
        ZipInputStream zis = new ZipInputStream(is);

        boolean hasImage = false;
        Application app = new Application();
        ZipEntry entry = null;
        while ((entry = zis.getNextEntry()) != null) {
            String entryName = entry.getName();
            if (entryName.equals(CONTRACT_TXT_NAME)) {
                //parse .txt on name and package
                String[] metaData = extractNameAndPackage(zis);
                app.setName(metaData[0]);
                app.setPackageName(metaData[1]);
                app.setArchive(zip);
                app.setDownloads(0);
                app.setDescription(description);
                app.setType(DEFAULT_TYPE);
            } else if (entryName.equals(PREVIEW_IMAGE_NAME)) {
                //resize pics to 512 if image doesn't exist save default image
                hasImage = true;
                Image image = ImageIO.read(zis);
                byte[] scaledImage = imageService.createResizedCopy(image, 512, 512);
                app.setImage(scaledImage);
            }
            zis.closeEntry();
        }
        if (!hasImage) {
            app = new Application();
        }
        return app;
    }

    private String[] extractNameAndPackage(ZipInputStream entry) throws IOException {
        final String nameTemplate = NAME_PREFIX.substring(0, NAME_PREFIX.length() - 1);
        final String valueTemplate = PACKAGE_PREFIX.substring(0, PACKAGE_PREFIX.length() - 1);
        String[] result = new String[2];
        Scanner scanner = new Scanner(entry);
        while (scanner.hasNext()) {
            Scanner line = new Scanner(scanner.nextLine());
            line.useDelimiter(":");
            if (line.hasNext()) {
                String name = line.next();
                String value = line.next();
                if (nameTemplate.equals(name)) {
                    result[0] = value;
                } else if (valueTemplate.equals(name)) {
                    result[1] = value;
                }
            }
        }
        return result;
    }

}
