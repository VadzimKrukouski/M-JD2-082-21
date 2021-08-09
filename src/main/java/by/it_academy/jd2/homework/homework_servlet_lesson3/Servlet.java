package by.it_academy.jd2.homework.homework_servlet_lesson3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "Servlet", urlPatterns = "/fullName")
public class Servlet extends HttpServlet {
    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastName";
    private static final String AGE_PARAM = "age";
    Person person = new Person();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String valueFirstName = getValueCookie(req,FIRST_NAME_PARAM_NAME);
        String valueFirstNameS = getValueSession(req,FIRST_NAME_PARAM_NAME);
        person.setFirstName(valueFirstName);
        saveCookies(resp, FIRST_NAME_PARAM_NAME, person.getFirstName());
        saveSession(req,FIRST_NAME_PARAM_NAME,valueFirstNameS);

        String valueLastName = getValueCookie(req,LAST_NAME_PARAM_NAME);
        String valueLastNameS = getValueSession(req,LAST_NAME_PARAM_NAME);
        person.setLastName(valueLastName);
        saveCookies(resp,LAST_NAME_PARAM_NAME,person.getLastName());
        saveSession(req,LAST_NAME_PARAM_NAME,valueLastNameS);


        String valueAge = getValueCookie(req,AGE_PARAM);
        String valueAgeS = getValueSession(req,AGE_PARAM);
        person.setAge(valueAge);
        saveCookies(resp,AGE_PARAM,person.getAge());
        saveSession(req,AGE_PARAM,valueAgeS);


        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(valueFirstName+valueLastName+valueAge);
        writer.write(valueFirstNameS+valueLastNameS+valueAgeS);
    }
    private void saveSession(HttpServletRequest req, String key, String value) {
        HttpSession session = req.getSession();
        session.setAttribute(key, value);
    }

    private String getValueSession(HttpServletRequest req, String name) {
        String value = req.getParameter(name);

        if (value == null) {
            HttpSession session = req.getSession();

            if (!session.isNew()) {
                value = (String) session.getAttribute(name);
            }
        }
        if (value == null) {
            throw new IllegalArgumentException("параметры не введены");
        }

        return value;
    }


    private String getValueCookie(HttpServletRequest req, String paramName) {
        String value = req.getParameter(paramName);

        if (value!=null){
            return value;
        }
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            value= Arrays.stream(cookies)
                    .filter(c->paramName.equalsIgnoreCase(c.getName()))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);
        }

        if (value!=null){
            return value;
        }

        throw new IllegalArgumentException("не введены параметры");
    }

    private void saveCookies(HttpServletResponse resp, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(1000);
        resp.addCookie(cookie);
    }
}
