package by.it_academy.jd2.classwork_servlet_lesson2.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Printer {
    private final VoteService service;

    public Printer (){
        this.service = VoteService.getInstance();
    }

    public void printerVoteArtist(PrintWriter writer){
        Map<String, Integer> artistResult = this.service.getArtistResult();
        List<Map.Entry<String, Integer>> sortedArtist = artistResult.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toList());

        writer.write("<h2> Результаты голосования артистов: </h2>");
        for (Map.Entry<String, Integer> stringIntegerEntry : sortedArtist) {
            switch (stringIntegerEntry.getKey()) {
                case "1":
                    writer.write("Ирина Олегрова ");
                    break;
                case "2":
                    writer.write("Каста ");
                    break;
                case "3":
                    writer.write("Луна ");
                    break;
                case "4":
                    writer.write("Иванушки ");
                    break;
            }
            writer.write(String.valueOf(stringIntegerEntry.getValue()));
            writer.write("<br/>");
        }
    }

    public void printerVoteGenre(PrintWriter writer){
        Map<String, Integer> genreResult = this.service.getGenreResult();
        List<Map.Entry<String, Integer>> sortedGenre = genreResult.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toList());
        writer.write("<h2> Результаты голосования жанров: </h2>");
        for (Map.Entry<String, Integer> entryGenre : sortedGenre) {
            switch (entryGenre.getKey()) {
                case "1":
                    writer.write("Рок ");
                    break;
                case "2":
                    writer.write("Поп ");
                    break;
                case "3":
                    writer.write("Фолк ");
                    break;
                case "4":
                    writer.write("Альт ");
                    break;
                case "5":
                    writer.write("Классика ");
                    break;
                case "6":
                    writer.write("Джаз ");
                    break;
                case "7":
                    writer.write("Тиктоник ");
                    break;
            }
            writer.write(String.valueOf(entryGenre.getValue()));
            writer.write("<br/>");
        }
    }

    public void printerText(PrintWriter writer){
        List<String> aboutResult = this.service.getAboutResult();
        writer.write("<h2> Текст о себе: </h2>");
        for (String text : aboutResult) {
            writer.write(text);
            writer.write("<br/>");
        }
    }
}
