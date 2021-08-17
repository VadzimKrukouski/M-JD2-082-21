package by.it_academy.jd2.homework.task_messenger.controller.web.servlets;

import by.it_academy.jd2.homework.task_messenger.model.User;
import by.it_academy.jd2.homework.task_messenger.model.UsersStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ServletMessage", urlPatterns = "/message")
public class ServletMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String from = (String) req.getSession().getAttribute("login");
        String recipient = req.getParameter("recipient");
        String text = req.getParameter("text");

        UsersStorage usersStorage = new UsersStorage();
        Date date = new Date();
        User addresses = usersStorage.getUser(recipient);
        if (addresses != null) {
            String message = from + " " + text + " " + date.toString();
            addresses.addMessage(message);
            req.setAttribute("info", "Сообщение отправлено");
            req.getRequestDispatcher("views/message.jsp").forward(req, resp);
        }
        if (addresses==null){
            req.setAttribute("info", "Получатель не найден");
            req.getRequestDispatcher("views/message.jsp").forward(req, resp);
        }



    }
}
