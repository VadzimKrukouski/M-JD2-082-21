package by.it_academy.jd2.homework.task_vote.view;

import by.it_academy.jd2.homework.task_vote.model.VoteStorage;

import java.util.List;
import java.util.Map;

public class VoteService {

    private final VoteStorage storage;
    private final static VoteService instance = new VoteService();

    private VoteService() {
        this.storage = VoteStorage.getInstance();
    }

    public void addVote(String artist, String[] genres, String about) {
        Integer artistValue = this.storage.getArtist().getOrDefault(artist, 0);
        this.storage.getArtist().put(artist, ++artistValue);

        if (genres != null) {
            for (String genre : genres) {
                Integer genreValue = this.storage.getGenre().getOrDefault(genre, 0);
                this.storage.getGenre().put(genre, ++genreValue);
            }
        }

        this.storage.getAbout().add(about);
    }

    public Map<String, Integer> getArtistResult() {
        return this.storage.getArtist();
    }

    public Map<String, Integer> getGenreResult() {
        return this.storage.getGenre();
    }

    public List<String> getAboutResult() {
        return this.storage.getAbout();
    }

    public static VoteService getInstance() {
        return instance;
    }
}
