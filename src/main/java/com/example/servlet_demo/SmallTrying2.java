package com.example.servlet_demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "smart trying2", value = "/small_trying2")
public class SmallTrying2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        try (PrintWriter pw = resp.getWriter()) {

            String name = req.getParameter("userName");
            String age = req.getParameter("userAge");
            String gender = req.getParameter("gender");
            String country = req.getParameter("country");
            String[] courses = req.getParameterValues("courses");

            pw.println("<p>Name: " + name + "</p>");
            pw.println("<p>Age: " + age + "</p>");
            pw.println("<p>Gender: " + gender + "</p>");
            pw.println("<p>Country: " + country + "</p>");
            pw.println("<h4>Courses</h4>");
            for(String course: courses)
                pw.println("<li>" + course + "</li>");
        }
    }
}