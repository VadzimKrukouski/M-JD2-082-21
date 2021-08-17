package by.it_academy.jd2.homework.task_messenger.controller.web.servlets;

import by.it_academy.jd2.homework.task_messenger.model.User;
import by.it_academy.jd2.homework.task_messenger.model.UsersStorage;
import by.it_academy.jd2.homework.task_messenger.view.SignUpHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletSignUp", urlPatterns = "/signUp")
public class ServletSignUp extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpHandle signUpHandle = SignUpHandle.getInstance();
        signUpHandle.registrationUser(req, resp);
    }
}

