package com.upgrad.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PatientServlet extends HttpServlet {
    /*
    * TODO 3: This class should not process any data but redirect to the 'patientInfo.jsp' page
    * */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/patientInfo.jsp").forward(req, resp);
    }
}
