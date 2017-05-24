package net.came20.tba4j.requests

/**
 * Created by cameronearle on 5/20/17.
 */
internal open class RequestsBase(val apiKey: String) {
    val requester = Requester(apiKey)
}