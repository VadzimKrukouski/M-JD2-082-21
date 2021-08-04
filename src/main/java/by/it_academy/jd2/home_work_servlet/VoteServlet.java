package by.it_academy.jd2.home_work_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    private static final HashMapPerformer hashMapPerformer = new HashMapPerformer();
    private static final HashMapGenre hashMapGenre = new HashMapGenre();
    private static final Map<String, Integer> performersMap = hashMapPerformer.getPerformerMap();
    private static final Map<String, Integer> genresMap = hashMapGenre.getGenresMap();
    private static final Map<String, Date> textMap = new HashMap<>();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String performer = req.getParameter("performer");
        String[] genre = req.getParameterValues("genre");
        String text = req.getParameter("text");
        HttpSession session = req.getSession(true);
        Date date = new Date();

        if (genre.length < 3) {
            writer.write("<h2>" + "ERROR:Вы выбрали мало жанров. Пожалуйста переголосуйте!" + "</h2>");
        } else {
            votePerformer(performer);
            voteGenre(genre);

            session.setAttribute("date", date);
            textMap.put(text, date);


            writer.write("<h2>" + "Performers:" + "</h2>");
            performersMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(k -> writer.write("<p>" + "<b>" + k.getKey() + "</b>" + " " + "result vote: " + k.getValue() + "</p>"));

            writer.write("<h2>" + "Genres:" + "</h2>");
            genresMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(k -> writer.write("<p>" + "<b>" + k.getKey() + "</b>" + " " + "result vote: " + k.getValue() + "</p>"));


            writer.write("<h2>" + "Text about you:" + "</h2>");
            for (String yourText : textMap.keySet()) {
                writer.write("<p>" + yourText + " " + date + "</p>");
            }
        }
    }

    private void voteGenre(String[] genre) {
        for (String nameGenre : genre) {
            for (String genreInMap : genresMap.keySet()) {
                if (genreInMap.equals(nameGenre)) {
                    genresMap.put(genreInMap, genresMap.get(genreInMap) + 1);
                }
            }
        }
    }

    private void votePerformer(String performer) {
        for (String artist : performersMap.keySet()) {
            if (artist.equals(performer)) {
                performersMap.put(artist, performersMap.get(artist) + 1);
            }
        }
    }
}
