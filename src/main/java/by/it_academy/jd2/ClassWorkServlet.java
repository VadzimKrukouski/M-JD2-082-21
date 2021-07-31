package by.it_academy.jd2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
@WebServlet (name = "ClassWorkServlet", urlPatterns = "/name")
public class ClassWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        Map<String, String[]> parameterMap = req.getParameterMap();
        String[] names = parameterMap.get("paramName");

        for (String name : names) {
            writer.write("<p>" + name + "</p>");
        }
    }
}
