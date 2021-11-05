package com.example.servlet_demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SmallTrying4", value = "/small_trying4")
public class SmallTrying4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (id == null) {
            String path = req.getContextPath() + "/page404.jsp";
            resp.sendRedirect(path);
        } else {
            resp.setContentType("text/html");
            try (PrintWriter pw = resp.getWriter()) {
                pw.println("<h2>Hello Id " + id + "</h2>");
            }
        }
    }
}