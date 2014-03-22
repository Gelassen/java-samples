package com.dataart.springtraining.controllers;

import com.dataart.springtraining.dao.ExampleDao;
import com.dataart.springtraining.dto.Application;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.springtraining.service.ExampleService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ExampleService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<String> categories = service.getAllCategories();
        List<Application> applications = service.getAllApplications();
        List<Application> popular = service.getPopularApplications();

        model.addAttribute("popular", popular);
        model.addAttribute("categories", categories);
        model.addAttribute("applications", applications);
        return "home";
    }

    @RequestMapping(value = "/category/{type}")
    public String sortedByCategory(Model model, @PathVariable String type) {
        List<Application> applications = service.getApplicationByCategory(type);
        List<String> categories = service.getAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("applications", applications);
        return "home";
    }

    /*Yes, it is bad practice to swallow all specific exceptions, but in this app I just show general error page */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "ErrorPage";
    }

}
