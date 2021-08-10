package by.it_academy.jd2.homework.homework_servlet_lesson3.service;

import by.it_academy.jd2.homework.homework_servlet_lesson3.storage.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;

public class CookieService {

    private final Person person = new Person();


    public void savePerson(HttpServletRequest req, HttpServletResponse resp, String firstName, String lastName, String age) {
        String firstNameValue = getValueCookie(req, firstName);
        String lastNameValue = getValueCookie(req, lastName);
        String ageValue = getValueCookie(req, age);

        person.setFirstName(firstNameValue);
        person.setLastName(lastNameValue);
        person.setAge(ageValue);

        saveCookies(resp, firstName, firstNameValue);
        saveCookies(resp, lastName, lastNameValue);
        saveCookies(resp, age, ageValue);
    }

    public String getValueCookie(HttpServletRequest req, String paramName) {
        String value = req.getParameter(paramName);

        if (value != null) {
            return value;
        }
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            value = Arrays.stream(cookies)
                    .filter(c -> paramName.equalsIgnoreCase(c.getName()))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);
        }

        if (value != null) {
            return value;
        }

        throw new IllegalArgumentException("не введены параметры");
    }

    public void saveCookies(HttpServletResponse resp, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(1000);
        resp.addCookie(cookie);
    }


    public void printFullName(PrintWriter writer) {
        writer.write(person.getFirstName() + person.getLastName() + person.getAge());
    }
}
