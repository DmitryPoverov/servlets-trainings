package com.example.servlet_demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "smart trying", value = "/small_trying")
public class SmallTrying extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        try (PrintWriter pw = resp.getWriter()) {
            pw.println("<h1>" + "Parameters:" + "</h1>");
            String id = req.getParameter("id");     // чтобы получить id URL должен быть
            pw.println("<h2>Id: " + id + "</h2>");     // localhost:8081/small_trying?id=5

            String name = req.getParameter("name");
            pw.println("<h2>Name: " + name + "</h2>"); // localhost:8081/small_trying?id=5&name=Tom
            pw.println("<h2>Id: " + id + "; Name: " + name + "</h2>");

            String[] nums = req.getParameterValues("nums");
            pw.print("<h2>Numbers: ");  // localhost:8081/small_trying?id=5&name=Tom&nums=3&nums=7&nums=5&nums=4
            for (String n: nums) {
                pw.print(n + "  ");
            }
            pw.println("</h2>");
        }
    }
}