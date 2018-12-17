package com.example;

import static spark.Spark.*;

public class Main {

    /**
     * Если Вам понадобится разделить по группам URL-пути,
     * то лучше и оптимальнее будет использовать метод path.
     * Вам не обязательно писать для POST и GET один и тот же
     * путь /api/*. Вам достаточно написать в path /api, а внутри
     * path разместить медоды HTTP {GET и POST}
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * [1] /api            localhost:4567/api/
         * ******************************************************
         *    [2] /*           localhost:4567/api/*
         * ******************************************************
         *    [2] /email       localhost:4567/api/email/
         *       [3] /get      localhost:4567/api/email/get/
         *       [3] /add      localhost:4567/api/email/add/
         *       [3] /change   localhost:4567/api/email/change/
         *       [3] /remove   localhost:4567/api/email/remove/
         * ******************************************************
         *    [2] /username    localhost:4567/api/username/
         *       [3] /get      localhost:4567/api/username/get/
         *       [3] /add      localhost:4567/api/username/add/
         *       [3] /change   localhost:4567/api/username/change/
         *       [3] /remove   localhost:4567/api/username/remove/
         */
        path("/api", () -> {
            before("/*", (q, a) -> System.out.println("Received api call"));

            path("/email", () -> {
                get("/get",        ((request, response) -> "GET-email"));
                post("/add",       ((request, response) -> "POST-email"));
                put("/change",     ((request, response) -> "PUT-email"));
                delete("/remove",  ((request, response) -> "DELETE-email"));
            });

            path("/username", () -> {
                get("/get",        ((request, response) -> "GET-username"));
                post("/add",       ((request, response) -> "POST-username"));
                put("/change",     ((request, response) -> "PUT-username"));
                delete("/remove",  ((request, response) -> "DELETE-username"));
            });
        });
    }
}
