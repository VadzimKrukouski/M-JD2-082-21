package by.it_academy.jd2.home_work_servlet;

import java.util.HashMap;

public class HashMapPerformer {
    public static HashMap<String, Integer> performerMap = new HashMap<>();

    static {
        performerMap.put("Linkin Park", 0);
        performerMap.put("Eminem", 0);
        performerMap.put("50 cent", 0);
        performerMap.put("Limp Bizkit", 0);
    }



    public HashMap<String, Integer> getPerformerMap() {
        return performerMap;
    }

}
