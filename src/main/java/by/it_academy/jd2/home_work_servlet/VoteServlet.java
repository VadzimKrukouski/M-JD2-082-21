package by.it_academy.jd2.home_work_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String performer = req.getParameter("performer");
        String[] genre = req.getParameterValues("genre");
        String text = req.getParameter("text");

        HashMapPerformer hashMapPerformer = new HashMapPerformer();
        Set<String> stringSet = hashMapPerformer.getPerformerMap().keySet();

        if (genre.length < 3) {
            writer.write("<h2>" + "ERROR:Вы выбрали мало жанров. Пожалуйста переголосуйте!" + "</h2>");
        } else {
            for (String s : stringSet) {
                if(s.equals(performer)){
                    Integer integer = hashMapPerformer.getPerformerMap().get(s);
                    integer=integer+1;
                    hashMapPerformer.getPerformerMap().put(s,integer);
                }

            }
            Set<Map.Entry<String, Integer>> entries = hashMapPerformer.getPerformerMap().entrySet();

            writer.write("<p>Performer: " + performer + "</p>");
            writer.write("<p><b>" + "Genre" + "</b></p>");
            for (String singleGenre : genre) {
                writer.write("<li>" + singleGenre + "</li>");
            }
            writer.write("<p>" + text + "</p>");
        }
    }
}
