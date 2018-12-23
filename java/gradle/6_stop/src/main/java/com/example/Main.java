package com.example;

import static spark.Spark.*;

public class Main {

    /**
     * Остановка WebSocket'а помогает очистить все запросы и вообще все.
     *
     * @param args
     */
    public static void main(String[] args) {

        /*
         * Остановит все. По ссылке http://sparkjava.com/documentation#stopping-the-server
         * сервер остановится и после запроса на метод HTTP или изменение порта, будет автоматически
         * запускаться наш WebSocket. Под капотом все отчищается и даже создается для очистки
         * новый поток для всех манипуляций, но он чет на локальном IDEA уровне не хочет запускаться атоматически.
         * Тут уже сами думайте.
         */
        get("/stop/one", (request, response) -> {

            stop();
            return "Stop";
        });

        /*
         * Обычный выход из программы Java.
         */
        get("/stop/two", (request, response) -> {

            System.exit(100);
            return "Stop";
        });
    }
}
