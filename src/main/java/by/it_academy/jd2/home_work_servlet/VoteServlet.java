package by.it_academy.jd2.home_work_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet (name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String performer = req.getParameter("performer");
        String[] genre=req.getParameterValues("genre");
        String text = req.getParameter("text");

        writer.write("<p>Performer: " + performer + "</p>");
        writer.write("<p><b>" + "Genre" + "</b></p>");
        for (String singleGenre : genre) {
            writer.write("<li>" + singleGenre + "</li>");
        }
        writer.write("<p>" + text + "</p>");
    }
}
