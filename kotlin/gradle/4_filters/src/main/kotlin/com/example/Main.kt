package com.example

import spark.kotlin.*

/**
 * Фильтры - это не методы которые срабатывают при их вызове.
 * Фильтры позволяют читать/изменять настройки не зависимо
 * от вызванного метода.
 * Фильтры помогут с проверкой авторизации и не только.
 *
 * Следите за логами в "Run".
 * Жизненый цикл [before => get => after]
 *
 * @param args
 */
fun main() {

    /**
     * GET метод. Просто для примера.
     */
    get("/login/:name") {
        println("GET method")

        params(":name")
    }

    /**
     * Подключение метода [Main.beforeMethods]
     */
    beforeMethods()

    /**
     * Подключение метода [Main.afterMethods]
     */
    afterMethods()
}

/**
 * Метод "before" может вызываться без настройки path или с ней.
 * Настройка path позволяет "before" вызваться там, где он необходим.
 * Внутри "before" можно сделать логику для проверки авторизации.
 *
 * Если "before" завершится не кодом 2xx, то не будет воспроизведен
 * GET метод.
 */
private fun beforeMethods() {

    /**
     * Проверка правильности введенного [:name].
     */
    before("/login/:name") {
        val name = params(":name")
        val login = "sparkjava"

        if (name == login) {
            println("[Before with /:name] ${pathInfo()} => Hello $name")
        } else {
            println("[Before with /:name] ${pathInfo()} => Who are you?")
            println("Close answer in GET method")
            halt(401, "CODE 401")
        }
    }

    /**
     * Вызывается не зависимо от path.
     */
    before { println("[Before without /:name] ${pathInfo()}") }
}

/**
 * Метод "after" анологичен методу "before".
 * Только метод "after" не воспроизведется, если ответ не 2xx.
 *
 * Метод "after" так же может иметь настройку path.
 */
private fun afterMethods() {

    /**
     * Делается записать в HEADER.
     */
    after {
        response.header("after", "set by after filter")

        println("after")
    }
}