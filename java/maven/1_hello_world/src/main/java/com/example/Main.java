package com.example;

import static spark.Spark.*;

public class Main {

    /**
     * Метод для запуска WebSocket
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Запрос GET /hello
         * Доступен по ссылке http://localhost:4567/hello
         * или по IP http://127.0.0.1:4567/hello
         */
        get("/hello", (req, res) -> "Hello World");
    }
}