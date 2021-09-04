package by.it_academy.jd2.classwork.classwork_servlet_lesson3.controller;

import by.it_academy.jd2.classwork.classwork_servlet_lesson3.model.Model;
import by.it_academy.jd2.classwork.classwork_servlet_lesson3.service.ModelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDB", urlPatterns = "/db")
public class ServletDB extends HttpServlet {
    private final ModelService modelService;

    public ServletDB() {
        this.modelService = ModelService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = new Model();
        modelService.addDataBase(model.getName(),model.getSalary());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double salary = Double.valueOf(req.getParameter("salary"));

        Model model = new Model();
        model.setName(name);
        model.setSalary(salary);
    }
}
