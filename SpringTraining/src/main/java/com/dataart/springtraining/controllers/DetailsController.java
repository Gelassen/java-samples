package com.dataart.springtraining.controllers;

import com.dataart.springtraining.service.FileService;
import com.dataart.springtraining.dto.Application;
import com.dataart.springtraining.dto.UploadItem;
import com.dataart.springtraining.service.ExampleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Controller
public class DetailsController {

    private final static Logger LOG = Logger.getLogger(DetailsController.class);

    @Autowired
    private ExampleService service;

    @Autowired
    private FileService file;

    @RequestMapping(value = "/details/{appId}", method = RequestMethod.GET)
    public String details(Model model, @PathVariable long appId) {
        Application app = service.getApplicationById(appId);
        model.addAttribute("application", app);
        model.addAttribute("uploadItem", new UploadItem());
        return "details";
    }

    @RequestMapping(value = "/details/{appId}",method = RequestMethod.POST)
    public String downloadPackage(@PathVariable long appId, HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {
        Application app = service.getApplicationById(appId);
        file.saveAsZip(response.getOutputStream(), app);

        final String name = app.getName().concat(".zip");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + name + "\"");
        return null;
    }

    /*Yes, it is bad practice to swallow all specific exceptions, but in this app I just show general error page */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "ErrorPage";
    }

}
