package net.came20.tba4j.exception

/**
 * Created by cameronearle on 5/17/17.
 */
open class TBAException : RuntimeException {
    constructor(message: String) : super(message) {
    }

    constructor(message: String, cause: Throwable) : super(message, cause) {
    }
}

