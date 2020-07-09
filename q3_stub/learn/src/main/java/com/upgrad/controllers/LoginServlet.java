package com.upgrad.controllers;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    /*
     * TODO 3: Override doPost method of HttpServlet class. Extract the username
     *  and password from the request parameter. Get writer object from response
     *  parameter. Print the login status message to the writer object.
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("emailId");
        String password = req.getParameter("password");
        if (email.equals("admin") && password.equals("root")) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("Welcome!");
        } else {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("Login failed");
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
    }
}

