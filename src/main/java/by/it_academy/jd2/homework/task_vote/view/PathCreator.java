package by.it_academy.jd2.homework.task_vote.view;

import java.io.File;

public class PathCreator {
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    private PathCreator() {
    }

    static String getFileName(Class<?> aClass, String filename) {
        String root = System.getProperty(USER_DIR);
        String path = aClass
                .getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + SRC + File.separator + path + filename;
    }
}
