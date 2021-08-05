package by.it_academy.jd2.classwork_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "PrintServlet", urlPatterns = "/print")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()){
            String paramName=params.nextElement();
            writer.write("<p>" + paramName + ": " + req.getParameter(paramName) + "</p>");
        }
    }
}
