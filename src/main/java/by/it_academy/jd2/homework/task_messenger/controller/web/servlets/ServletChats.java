package by.it_academy.jd2.homework.task_messenger.controller.web.servlets;

import by.it_academy.jd2.homework.task_messenger.model.User;
import by.it_academy.jd2.homework.task_messenger.model.UsersStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "ServletChats", urlPatterns = "/chats")
public class ServletChats extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        UsersStorage usersStorage = new UsersStorage();
        User user = usersStorage.getUser(login);

        List<String> messages = user.getMessages();
        req.setAttribute("message", messages);
        req.getRequestDispatcher("views/chats.jsp").forward(req,resp);
    }
}
