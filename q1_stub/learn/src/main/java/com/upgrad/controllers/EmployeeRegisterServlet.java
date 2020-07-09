package com.upgrad.controllers;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*
         * TODO 3: Get the information filled in the index.jsp form using getParameter() method of
         *  the req and print the output in the required form using the resp.getWriter().println()
         *  method
         * */
        String N = req.getParameter("Name");
        String D = req.getParameter("Department");
        String C = req.getParameter("Company");
        String S = req.getParameter("submit");
//        req.setAttribute("name", N);
//        req.setAttribute("dept", D);
//        req.setAttribute("comp", C);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Name : " + N+"<br/>");
        out.println("Department : " + D+"<br/>");
        out.println("Company : " + C);


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
    }
}
