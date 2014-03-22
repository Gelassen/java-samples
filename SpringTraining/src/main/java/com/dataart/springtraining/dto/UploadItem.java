package com.dataart.springtraining.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadItem
{
    private String name;

    private String description;

    private CommonsMultipartFile fileData;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommonsMultipartFile getFileData()
    {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData)
    {
        this.fileData = fileData;
    }
}
