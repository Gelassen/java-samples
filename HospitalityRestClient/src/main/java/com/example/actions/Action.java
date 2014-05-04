package com.example.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
