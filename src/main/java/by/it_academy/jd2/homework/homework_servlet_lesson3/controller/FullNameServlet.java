package by.it_academy.jd2.homework.homework_servlet_lesson3.controller;

import by.it_academy.jd2.homework.homework_servlet_lesson3.service.CookieService;
import by.it_academy.jd2.homework.homework_servlet_lesson3.service.SessionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FullNameServlet", urlPatterns = "/fullName")
public class FullNameServlet extends HttpServlet {
    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastName";
    private static final String AGE_PARAM = "age";
    private static final String HEADER_PARAM = "array_name_param";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();

        String header = req.getHeader(HEADER_PARAM);
        if (header.equals("cookie")) {
            CookieService cookieService = new CookieService();
            cookieService.savePerson(req, resp, FIRST_NAME_PARAM_NAME, LAST_NAME_PARAM_NAME, AGE_PARAM);
            cookieService.printFullName(writer);
        }
        if (header.equals("session")) {
            SessionService sessionService = new SessionService();
            sessionService.savePerson(req, FIRST_NAME_PARAM_NAME, LAST_NAME_PARAM_NAME, AGE_PARAM);
            sessionService.printFullName(writer);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
