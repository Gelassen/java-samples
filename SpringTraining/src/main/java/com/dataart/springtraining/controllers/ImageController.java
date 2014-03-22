package com.dataart.springtraining.controllers;

import com.dataart.springtraining.service.ImageService;
import com.dataart.springtraining.dto.Application;
import com.dataart.springtraining.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ImageController {

    @Autowired
    private ExampleService service;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value="/images/{imageId}")
    @ResponseBody
    public byte[] getHomePicture(@PathVariable long imageId) {
        Application app = service.getApplicationById(imageId);
        return app.getImage();
    }

    @RequestMapping(value="/images/preview/{imageId}")
    @ResponseBody
    public byte[] getPreviewPicture(@PathVariable long imageId) throws IOException {
        Application app = service.getApplicationById(imageId);
        return imageService.getImagePreview(app);
    }

    /*Yes, it is bad practice to swallow all specific exceptions, but in this app I just show general error page */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "ErrorPage";
    }

}
