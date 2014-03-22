package com.dataart.springtraining.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.dataart.springtraining.dao.ExampleDao;
import com.dataart.springtraining.dto.Application;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExampleService {

    private final static Logger LOG = Logger.getLogger(ExampleService.class);

    @Value("#{appProperties.appVersion}")
    private String appVersion;

    @Autowired
    private ExampleDao dao;

    public Application getApplicationById(long appId) {
        return dao.getAppById(appId);
    }

    public List<Application> getApplicationByCategory(String type) {
        return dao.getAppsByCategory(type);
    }

    public List<String> getAllCategories() {
        return dao.getAllCategories();
    }

    public List<Application> getAllApplications() {
        return dao.getAllApplications();
    }

    public List<Application> getPopularApplications() {
        return dao.getPopularApplications();
    }

    public void addNewApplication(Application app) {
        dao.addNewApplication(app);
    }

    public boolean packageUnique(String name) {
        return dao.thisPackageUnique(name);
    }

    public String getSystemTime() {
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
	return dateFormat.format(new Date());
    }

    public String getAppVersion() {
	return appVersion;
    }

}
