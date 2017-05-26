package net.came20.tba4j.requests

/**
 * Created by cameronearle on 5/20/17.
 */
open class RequestsBase(apiKey: String) {
    protected val requester = Requester(apiKey)
}