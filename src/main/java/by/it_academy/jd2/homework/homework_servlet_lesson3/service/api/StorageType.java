package by.it_academy.jd2.homework.homework_servlet_lesson3.service.api;

import by.it_academy.jd2.homework.homework_servlet_lesson3.service.CookieHandle;
import by.it_academy.jd2.homework.homework_servlet_lesson3.service.SessionHandle;

public enum StorageType {
    COOKIE(CookieHandle.getInstance()),
    SESSION(SessionHandle.getInstance())
    ;

    private final HandleRequest handler;

    StorageType(HandleRequest handler) {
        this.handler = handler;
    }

    //метод исключающий неправильность ввода заголовка с точки зрения регистра
    public static StorageType valueOfIgnoreCase(String name){
        for (StorageType value : values()) {
            if (value.name().equalsIgnoreCase(name)){
                return value;
            }
        }
        throw new IllegalArgumentException("Не передан тип сохранения");
    }

    public HandleRequest getHandler() {
        return handler;
    }
}
