package com.example;

import static spark.Spark.*;

public class Main {

    /**
     * URL-путь. Уточняющая информация о месте нахождения ресурса; зависит от протокола.
     *
     * @see <a href="https://ru.wikipedia.org/wiki/URL#Структура_URL">https://ru.wikipedia.org/wiki/URL#Структура_URL</a>
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * [:name] - пользовательский динамический путь в URL-пути.
         */
        get("/hello/:name", (request, response) -> "Hello: " + request.params(":name"));

        /**
         * Некий массив URL-путей.
         * Через символ "*", вы, получаете два элемента в массиве.
         * Через массив можно будет получить значение конкретного URL-пути.
         *
         * Пример:
         * /say/one/to/two
         * request.splat()[0] => ответ нулевого элемента будет "one"
         * request.splat()[1] => ответ первого элемента будет "two"
         */
        get("/say/*/to/*", (request, response) -> "Number of splat parameters: " + request.splat().length);
    }
}
