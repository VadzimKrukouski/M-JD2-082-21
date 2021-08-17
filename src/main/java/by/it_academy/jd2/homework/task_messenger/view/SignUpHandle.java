package by.it_academy.jd2.homework.task_messenger.view;

import by.it_academy.jd2.homework.task_messenger.model.User;
import by.it_academy.jd2.homework.task_messenger.model.UsersStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignUpHandle {
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String FIO_PARAM = "fio";
    private static final String BIRTHDAY_PARAM = "birthday";

    private static final SignUpHandle instance = new SignUpHandle();

    private SignUpHandle() {
    }

    public static SignUpHandle getInstance() {
        return instance;
    }

    public void registrationUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        UsersStorage usersStorage = new UsersStorage();
        HttpSession session = req.getSession();

        setAttributeUser(req, user);

        if (usersStorage.addUser(user)) {
            session.setAttribute("user", user);
            session.setAttribute("login", user.getLogin());
            req.setAttribute("user", user);
            req.getRequestDispatcher("views/profile.jsp").forward(req, resp);
        } else {
            req.setAttribute("info", "Такой пользователь уже существует");
            req.getRequestDispatcher("views/signUp.jsp").forward(req, resp);


        }
    }

    private void setAttributeUser(HttpServletRequest req, User user) {
        user.setLogin(req.getParameter(LOGIN_PARAM));
        user.setPassword(req.getParameter(PASSWORD_PARAM));
        user.setFio(req.getParameter(FIO_PARAM));
        user.setBirthday(req.getParameter(BIRTHDAY_PARAM));

    }
}

