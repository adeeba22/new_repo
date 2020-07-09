package com.upgrad.controllers;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    /*
     * TODO 3: Fetch the username provided in the index.jsp page and print that on the browser
     * */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String N = req.getParameter("Name");
        String S = req.getParameter("submit");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(N+"<br/>");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
    }
}

