package com.example.restservice.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Action {

    public void process(HttpServletRequest request, HttpServletResponse response);

}
