package by.it_academy.jd2.classwork_servlet_lesson3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "ServletCookie", urlPatterns = "/testCookie")
public class ServletCookie extends HttpServlet {

    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastname";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstNameVal = getValueFromAnywhere(req, FIRST_NAME_PARAM_NAME);
        saveCookies(resp, FIRST_NAME_PARAM_NAME, firstNameVal);

        String lastNameVal = getValueFromAnywhere(req, LAST_NAME_PARAM_NAME);
        saveCookies(resp, LAST_NAME_PARAM_NAME, firstNameVal);


        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: red;'>Hello, " + lastNameVal + " " + firstNameVal + "!</span></p>");


    }

    private String getValueFromAnywhere(HttpServletRequest req, String firstNameParamName) {
        String value = req.getParameter(firstNameParamName);

        if (value!=null){
            return value;
        }

        Cookie[] cookies = req.getCookies();

        if (cookies!=null){
            value= Arrays.stream(cookies)
                    .filter(c->firstNameParamName.equalsIgnoreCase(c.getName()))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);
        }

        if (value!=null){
            return value;
        }

        throw new IllegalArgumentException("Один из параметров не введён");

    }

    private void saveCookies(HttpServletResponse resp, String firstNameParamName, String firstNameVal) {
        Cookie cookie = new Cookie(firstNameParamName, firstNameVal);
        cookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        resp.addCookie(cookie);
    }


}


