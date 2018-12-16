package com.example;

import static spark.Spark.*;

public class Main {

    /**
     * Фильтры - это не методы которые срабатывают при их вызове.
     * Фильтры позволяют читать/изменять настройки не зависимо
     * от вызванного метода.
     * Фильтры помогут с проверкой авторизации и не только.
     *
     * Следите за логами в "Run".
     * Жизненый цикл [before => get => after => afterAfter]
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * GET метод. Просто для примера.
         */
        get("/login/:name", (request, response) -> {
            System.out.println("GET method");

            return request.params(":name");
        });

        /**
         * Подключение метода {@link Main#beforeMethods()}
         */
        beforeMethods();

        /**
         * Подключение метода {@link Main#afterMethods()}
         */
        afterMethods();
    }

    /**
     * Метод "before" может вызываться без настройки path или с ней.
     * Настройка path позволяет "before" вызваться там, где он необходим.
     * Внутри "before" можно сделать логику для проверки авторизации.
     *
     * Если "before" завершится не кодом 2xx, то не будет воспроизведен
     * GET метод.
     */
    private static void beforeMethods() {

        /**
         * Проверка правильности введенного [:name].
         */
        before("/login/:name", (request, response) -> {
            String name = request.params(":name");
            String login = "sparkjava";

            if (name.equals(login)) {
                System.out.println("[Before with /:name] " + request.pathInfo() + " => Hello " + name);
            } else {
                System.out.println("[Before with /:name] " + request.pathInfo() + " => Who are you?");
                System.out.println("Close answer in GET method");
                halt(401, "CODE 401");
            }
        });

        /**
         * Вызывается не зависимо от path.
         */
        before((request, response) -> System.out.println("[Before without /:name] " + request.pathInfo()));
    }

    /**
     * Метод "afterAfter" вызывается после метода "after".
     * А метод вызывается перед методом GET.
     *
     * Методы "after" и "afterAfter" анологичны методу "before".
     * Только метод "after" не воспроизведется, если ответ не 2xx.
     *
     * Методы "after" и "afterAfter" так же могут иметь настройку path.
     */
    private static void afterMethods() {

        /**
         * Делается записать в HEADER.
         */
        after((request, response) -> {
            response.header("after", "set by after filter");

            System.out.println("after");
        });

        /**
         * Делается записать в HEADER.
         */
        afterAfter((request, response) -> {
            response.header("afterAfter", "set by afterAfter filter");

            System.out.println("afterAfter");
        });
    }
}
