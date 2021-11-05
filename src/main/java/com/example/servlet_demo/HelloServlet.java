package com.example.servlet_demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hello-servlet")
@WebServlet(name = "helloServlet", value = "/hello-servlet")

public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World! Text from HelloServlet.java";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()){
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");
        }
    }

    public void destroy() {
    }
}