package com.example;

import static spark.Spark.*;

public class Main {

    /**
     * HTTP определяет множество методов запроса, которые
     * указывают, какое желаемое действие выполнится для
     * данного ресурса. Несмотря на то, что их названия
     * могут быть существительными, эти методы запроса
     * иногда называются HTTP глаголами. Каждый реализует
     * свою семантику, но каждая группа команд разделяет
     * общие свойства: так, методы могут быть безопасными,
     * идемпотентными или кэшируемыми.
     *
     * @see <a href="https://developer.mozilla.org/ru/docs/Web/HTTP/Methods">https://developer.mozilla.org/ru/docs/Web/HTTP/Methods</a>
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Метод GET запрашивает представление ресурса.
         * Запросы с использованием этого метода могут
         * только извлекать данные.
         *
         * @see <a href="https://developer.mozilla.org/ru/docs/Web/HTTP/Methods">https://developer.mozilla.org/ru/docs/Web/HTTP/Methods</a>
         */
        get("/", (request, response) -> "GET");

        /**
         * Метод HEAD идентичен GET, за исключением того,
         * что сервер НЕ ДОЛЖЕН возвращать в ответе тело
         * сообщения (message-body). Этот метод может
         * использоваться для получения метаинформации
         * об объекте запроса без непосредственной пересылки
         * тела объекта (entity-body). Этот метод часто
         * используется для тестирования гипертекстовых
         * связей в целях проверки правильности, достижимости,
         * и времени модификации.
         *
         * @see <a href="http://www.lib.ru/WEBMASTER/rfc2068/section-9.html">http://www.lib.ru/WEBMASTER/rfc2068/section-9.html</a>
         */
        head("/", (request, response) -> "HEAD");

        /**
         * POST используется для отправки сущностей к
         * определённому ресурсу. Часто вызывает изменение
         * состояния или какие-то побочные эффекты на
         * сервере.
         *
         * @see <a href="https://developer.mozilla.org/ru/docs/Web/HTTP/Methods">https://developer.mozilla.org/ru/docs/Web/HTTP/Methods</a>
         */
        post("/", (request, response) -> "POST");

        /**
         * PUT заменяет все текущие представления
         * ресурса данными запроса.
         *
         * @see <a href="https://developer.mozilla.org/ru/docs/Web/HTTP/Methods">https://developer.mozilla.org/ru/docs/Web/HTTP/Methods</a>
         */
        put("/", (request, response) -> "PUT");

        /**
         * DELETE удаляет указанный ресурс.
         *
         * @see <a href="https://developer.mozilla.org/ru/docs/Web/HTTP/Methods">https://developer.mozilla.org/ru/docs/Web/HTTP/Methods</a>
         */
        delete("/", (request, response) -> "DELETE");

        /**
         * CONNECT устанавливает "туннель" к серверу,
         * определённому по ресурсу.
         *
         * @see <a href="https://developer.mozilla.org/ru/docs/Web/HTTP/Methods">https://developer.mozilla.org/ru/docs/Web/HTTP/Methods</a>
         */
        connect("/", (request, response) -> "CONNECT");

        /**
         * OPTIONS используется для описания параметров
         * соединения с ресурсом.
         *
         * @see <a href="https://developer.mozilla.org/ru/docs/Web/HTTP/Methods">https://developer.mozilla.org/ru/docs/Web/HTTP/Methods</a>
         */
        options("/", (request, response) -> "OPTIONS");

        /**
         * HTTP метод TRACE применяется для диагностики,
         * он позволяет видеть клиенту, что происходит в
         * каждом звене цепочки между компьютером клиента
         * и конечным получателем, для этого существует
         * специальное поле Via. Ответы сервера на метод
         * TRACE не кэшируются.
         *
         * @see <a href="https://zametkinapolyah.ru/servera-i-protokoly/tema-7-opredelenie-metodov-http-http-method-definitions-metody-http-zaprosov.html#_HTTP_TRACE__HTTP_TRACE">https://zametkinapolyah.ru/servera-i-protokoly/tema-7-opredelenie-metodov-http-http-method-definitions-metody-http-zaprosov.html#_HTTP_TRACE__HTTP_TRACE</a>
         */
        trace("/", (request, response) -> "TRACE");

        /**
         * PATCH — это метод, который не объявляется ни
         * безопасным, ни идемпотентным, и позволяет производить
         * полное или частичное обновление, возможно с
         * побочным эффектом на смежные ресурсы.
         *
         * @see <a href="https://habr.com/sandbox/41580">https://habr.com/sandbox/41580</a>
         */
        patch("/", (request, response) -> "PATCH");
    }
}
