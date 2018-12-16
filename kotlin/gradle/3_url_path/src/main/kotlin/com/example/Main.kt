package com.example

import spark.kotlin.*

/**
 * URL-путь. Уточняющая информация о месте нахождения ресурса; зависит от протокола.
 *
 * @see [https://ru.wikipedia.org/wiki/URL.Структура_URL](https://ru.wikipedia.org/wiki/URL.Структура_URL)
 *
 *
 * @param args
 */
fun main() {

    /**
     * [:name] - пользовательский динамический путь в URL-пути.
     */
    get("/hello/:name") { "Hello: ${params(":name")}" }

    /**
     * Некий массив URL-путей.
     * Через символ "*", вы, получаете два элемента в массиве.
     * Через массив можно будет получить значение конкретного URL-пути.
     *
     * Пример:
     * /say/one/to/two
     * splat()!![0] => ответ нулевого элемента будет "one"
     * splat()!![1] => ответ первого элемента будет "two"
     */
    get("/say/*/to/*") { "Number of splat parameters: ${splat()?.size}" }
}
