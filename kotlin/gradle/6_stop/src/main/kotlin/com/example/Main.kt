package com.example

import spark.kotlin.*
import kotlin.system.exitProcess

/**
 * Остановка WebSocket'а помогает очистить все запросы и вообще все.
 */
fun main() {

    /*
     * Остановит все. По ссылке http://sparkjava.com/documentation#stopping-the-server
     * сервер остановится и после запроса на метод HTTP или изменение порта, будет автоматически
     * запускаться наш WebSocket. Под капотом все отчищается и даже создается для очистки
     * новый поток для всех манипуляций, но он чет на локальном IDEA уровне не хочет запускаться атоматически.
     * Тут уже сами думайте.
     */
    get("/stop/one") {

        stop()
        "Stop"
    }

    /*
     * Обычный выход из программы Kotlin.
     */
    get("/stop/two") {

        exitProcess(100)
    }
}