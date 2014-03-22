package com.dataart.springtraining.controllers;

import com.dataart.springtraining.service.FileService;
import com.dataart.springtraining.dto.Application;
import com.dataart.springtraining.dto.UploadItem;
import com.dataart.springtraining.service.ExampleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    private final static Logger LOG = Logger.getLogger(UploadController.class);

    @Autowired
    private ExampleService service;

    @Autowired
    private FileService file;

    @RequestMapping(method = RequestMethod.GET)
    public String getUploadForm(Model model) {
        model.addAttribute(new UploadItem());
        return "upload";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(UploadItem uploadItem, BindingResult bindingResult){
        String page = "redirect:/";
        String name = uploadItem.getName();
        if ("".equals(name) || !service.packageUnique(name)) {
            page = "unsupported";
        } else {
            Application app = file.getFileForUpload(uploadItem);
            if (app == null) {
                page = "unsupported";
            } else {
                service.addNewApplication(app);
            }
        }
        return page;
    }

    //Yes, it is bad practice to swallow all specific exceptions, but in this app I just show general error page
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "ErrorPage";
    }

}
