package by.it_academy.jd2.home_work_servlet;

import java.util.HashMap;

public class HashMapGenre {
    public static HashMap<String, Integer> genresMap = new HashMap<>();

    static {
        genresMap.put("Rap", 0);
        genresMap.put("Hip-hop", 0);
        genresMap.put("Trap", 0);
        genresMap.put("D&B", 0);
        genresMap.put("Classic", 0);
        genresMap.put("Country", 0);
        genresMap.put("Electronic", 0);
        genresMap.put("Jazz", 0);
        genresMap.put("Pop", 0);
        genresMap.put("Rock", 0);
    }

    public HashMap<String, Integer> getGenresMap() {
        return genresMap;
    }
}
