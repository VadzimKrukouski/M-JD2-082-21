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
    private static final String LAST_NAME_PARAM_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String firstNameValue = getValue(req,FIRST_NAME_PARAM_NAME, session);
        String lastNameValue = getValue(req,LAST_NAME_PARAM_NAME, session);


        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: red;'>Hello, " + lastNameValue+ " " + firstNameValue + "!</span></p>");


    }

    private String getValue(HttpServletRequest req, String name, HttpSession session) {
        String value = req.getParameter(name);

        if (value != null) {
            session.setAttribute(name, value);
            return value;
        }
        if (value==null) {
            value = (String) session.getAttribute(name);
            return value;
        }
        throw new IllegalArgumentException("параметры не введены");
    }


}
