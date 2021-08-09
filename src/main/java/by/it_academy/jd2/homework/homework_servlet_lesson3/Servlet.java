package by.it_academy.jd2.homework.homework_servlet_lesson3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/name")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String valueFirstName = req.getParameter("firstName");
        String valueLastName = req.getParameter("lastName");
        String valueAge = req.getParameter("age");

        Person person = new Person();
        person.setFirstName(valueFirstName);
        person.setLastName(valueLastName);
        person.setAge(valueAge);

        saveCookies(resp, valueFirstName, person.getFirstName());
        saveCookies(resp,valueLastName,person.getLastName());
        saveCookies(resp,valueAge,person.getAge());

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(valueFirstName+valueLastName+valueAge);
    }

    private void saveCookies(HttpServletResponse resp, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(1);
        resp.addCookie(cookie);
    }
}
