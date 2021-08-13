package by.it_academy.jd2.homework.task_person.controller.web.servlets;

import by.it_academy.jd2.homework.task_person.model.Person;
import by.it_academy.jd2.homework.task_person.view.api.HandleRequest;
import by.it_academy.jd2.homework.task_person.view.api.StorageType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DataPersonServlet", urlPatterns = "/person")
public class DataPersonServlet extends HttpServlet {
    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastName";
    private static final String AGE_PARAM = "age";
    private static final String HEADER_PARAM_NAME = "header";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html; charset=UTF-8");
//        req.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();

        StorageType header = StorageType.valueOfIgnoreCase(req.getHeader(HEADER_PARAM_NAME));

        HandleRequest handler = header.getHandler();

        Person person = handler.get(req);

        writer.write("FirstName: " + person.getFirstName());
        writer.write("LastName: " + person.getLastName());
        writer.write("Age: " + person.getAge());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html; charset=UTF-8");
//        req.setCharacterEncoding("utf-8");


        //создаём объект персона и туда из реквеста записываем значения, получаемые из параметров
        Person person = new Person();
        person.setFirstName(req.getParameter(FIRST_NAME_PARAM_NAME));
        person.setLastName(req.getParameter(LAST_NAME_PARAM_NAME));
        person.setAge(req.getParameter(AGE_PARAM));

        //проверяем переданы ли все обязательные параметры
        if (person.getFirstName() == null || person.getLastName() == null || person.getAge() == null) {
            throw new IllegalArgumentException("Переданы не все параметры");
        }

        //получаем из реквеста наш заголовок и проверяем его без учёта регистра
        StorageType header = StorageType.valueOfIgnoreCase(req.getHeader(HEADER_PARAM_NAME));

        HandleRequest handler = header.getHandler();

        if (handler == null) {
            throw new IllegalArgumentException("Не передан тип сохранения");
        }

        handler.save(req, resp, person);

    }
}
