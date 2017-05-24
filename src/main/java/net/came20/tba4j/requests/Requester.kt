package net.came20.tba4j.requests

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.came20.tba4j.exception.TBAAuthException
import net.came20.tba4j.exception.TBAException

/*
 * tba4j - Created on 5/23/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/23/17
 */
internal class Requester(val apiKey: String) {
    private val gson = Gson()

    init {
        FuelManager.instance.basePath = "http://www.thebluealliance.com/api/v3"
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "TBA4J",
                                                 "X-TBA-Auth-Key" to apiKey,
                                                 "Accept" to "application/json",
                                                 "charset" to "utf-8")
    }

    fun <T> makeRequest(requestString: String, token: TypeToken<T>): T {
        val (_, response, result) = requestString.httpGet().responseString()
        result.fold({ //Success
            try {
                return gson.fromJson(it, token.type)
            } catch (e: Exception) {
                throw TBAException("Error parsing response!  This is not normal!  Either TBA is malfunctioning or this is a bug!", e)
            }
        }, { //Failure
            if (response.httpStatusCode == 401) { //Auth error
                throw TBAAuthException("Invalid API key [$apiKey]")
            } else { //General error
                throw TBAException("Error getting data for request [$requestString]", it.exception)
            }
        })
    }
}