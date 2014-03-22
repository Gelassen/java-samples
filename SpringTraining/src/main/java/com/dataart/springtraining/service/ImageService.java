package com.dataart.springtraining.service;

import com.dataart.springtraining.dto.Application;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class ImageService {

    private final static Logger LOG = Logger.getLogger(ImageService.class);

    public byte[] createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight) {
        BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = scaledImage.createGraphics();
        graphics.setComposite(AlphaComposite.Src);
        graphics.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        graphics.dispose();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(scaledImage, "jpeg", out);
        } catch (IOException e) {
            LOG.error("Exception during resizing image", e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                LOG.error("Exception during attempt to close stream", e);
            }
        }

        return out.toByteArray();
    }

    public byte[] getImagePreview(Application app) throws IOException {
        ImageIO.read(new ByteArrayInputStream(app.getImage())) ;
        return createResizedCopy(ImageIO.read(new ByteArrayInputStream(app.getImage())), 128, 128);
    }

}
