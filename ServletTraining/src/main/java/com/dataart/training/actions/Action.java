package com.dataart.training.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    public String perform(HttpServletRequest request, HttpServletResponse response);
}
