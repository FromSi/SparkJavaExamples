package com.example

import spark.kotlin.*

/**
 * Метод для запуска WebSocket
 */
fun main() {

    /**
     * Запрос GET /hello
     * Доступен по ссылке http://localhost:4567/hello
     * или по IP http://127.0.0.1:4567/hello
     */
    get("/hello") {
        "Hello World"
    }
}