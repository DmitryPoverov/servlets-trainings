package com.example.servlet_demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SmallTrying3", value = "/small_trying3")
public class SmallTrying3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/index2.html";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);

        String id = req.getParameter("id");
        if (id == null) {
            path = req.getContextPath() + "/notfound";
            resp.sendRedirect(path);
        } else {
            resp.setContentType("text/html");
            try (PrintWriter pw = resp.getWriter()) {
                pw.println("<h2>Hello Id " + id + "</h2>");
            }
        }
    }
}