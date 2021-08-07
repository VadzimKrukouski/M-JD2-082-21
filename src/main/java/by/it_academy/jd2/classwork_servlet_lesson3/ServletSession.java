package by.it_academy.jd2.classwork_servlet_lesson3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletSession", urlPatterns = "/session")
public class ServletSession extends HttpServlet {

    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastname";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstNameValue = getValue(req,FIRST_NAME_PARAM_NAME);
        String lastNameValue = getValue(req,LAST_NAME_PARAM_NAME);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: red;'>Hello, " + lastNameValue+ " " + firstNameValue + "!</span></p>");


    }

    private String getValue(HttpServletRequest req, String name) {
        String value = req.getParameter(name);
        HttpSession session = req.getSession(false);

        if (value != null) {
            session.setAttribute(FIRST_NAME_PARAM_NAME, value);
            return value;
        }
        if (session!=null) {
            value = (String) session.getAttribute(FIRST_NAME_PARAM_NAME);
            return value;
        }
        throw new IllegalArgumentException("параметры не введены");
    }


}
