package com.example.servlet_demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/my_servlet")
@WebServlet(name = "myServlet", value = "/my_servlet")

public class MyServlet extends HttpServlet {
    private String msg;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        msg = "My response from MyServlet.java";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + msg + "</h1>");
        out.println("</body></html>");
    }
}