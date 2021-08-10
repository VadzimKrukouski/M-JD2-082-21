package by.it_academy.jd2.homework.homework_servlet_lesson3.service;

import by.it_academy.jd2.homework.homework_servlet_lesson3.storage.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class SessionService {

    private final Person person = new Person();

    public void savePerson(HttpServletRequest req, String firstName, String lastName, String age) {
        String firstNameValue = getValueSession(req, firstName);
        String lastNameValue = getValueSession(req, lastName);
        String ageValue = getValueSession(req, age);

        person.setFirstName(firstNameValue);
        person.setLastName(lastNameValue);
        person.setAge(ageValue);

        saveSession(req, firstName, firstNameValue);
        saveSession(req, lastName, lastNameValue);
        saveSession(req, age, ageValue);

    }

    public void getPerson(PrintWriter writer) {
        writer.write(person.getFirstName() + " " + person.getLastName() + " " + person.getAge());
    }

    public String getValueSession(HttpServletRequest req, String name) {
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

    public void saveSession(HttpServletRequest req, String key, String value) {
        HttpSession session = req.getSession();
        session.setAttribute(key, value);
    }

}
