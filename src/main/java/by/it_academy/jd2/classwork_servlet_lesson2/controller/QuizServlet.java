package by.it_academy.jd2.classwork_servlet_lesson2.controller;

import by.it_academy.jd2.classwork_servlet_lesson2.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QuizServlet", urlPatterns = "/")
public class QuizServlet extends HttpServlet {

    private final VoteService service;

    public QuizServlet() {
        this.service = VoteService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html; charset=UTF-8");

        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t<title>Quiz</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<form action=\"/M-JD2-082-21-1.0-SNAPSHOT/\" method=\"POST\">\n" +
                "\t\t<label for=\"artist\">Группа</label>\n" +
                "\t\t<select name=\"artist\">\n" +
                "\t\t\t<option value=\"1\">Ирина Олегрова</option>\n" +
                "\t\t\t<option value=\"2\">Каста</option>\n" +
                "\t\t\t<option value=\"3\">Луна</option>\n" +
                "\t\t\t<option value=\"4\">Иванушки</option>\n" +
                "\t\t</select><br/>\n" +
                "\t\t<label for=\"genre\">Жанр</label><br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"1\"/> Рок <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"2\"/> Поп <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"3\"/> Фолк <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"4\"/> Альт <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"5\"/> Клкассика <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"6\"/> Джаз <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"7\"/> Тиктоник <br/>\n" +
                "\t\t<label for=\"about\">О себе</label><br/>\n" +
                "\t\t<textarea name=\"about\"></textarea>\n" +
                "\t\t<input type=\"submit\" name=\"Отправить\">\n" +
                "\t</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html; charset=UTF-8");

        String artist = req.getParameter("artist");
        String[] genres = req.getParameterValues("genre");
        String about = req.getParameter("about");


        this.service.addVote(artist, genres, about);

        Map<String, Integer> artistResult = this.service.getArtistResult();
        Map<String, Integer> genreResult = this.service.getGenreResult();
        List<String> aboutResult = this.service.getAboutResult();

        for (Map.Entry<String, Integer> entry : artistResult.entrySet()) {
            switch (entry.getKey()) {
                case "1":
                    writer.write("Ирина Олегрова");
                    break;
                case "2":
                    writer.write("Каста");
                    break;
                case "3":
                    writer.write("Луна");
                    break;
                case "4":
                    writer.write("Иванушки");
                    break;
            }
            writer.write(String.valueOf(entry.getValue()));
        }
    }
}
