package net.came20.tba4j.requests

import com.google.gson.reflect.TypeToken
import net.came20.tba4j.data.Match
import java.time.Year

/**
 * Created by cameronearle on 5/22/17.
 */

internal class MatchRequestsImpl(apiKey: String) : RequestsBase(apiKey) {
    @JvmOverloads fun getMatch(match: String, event: String, year: Int = Year.now().value) = requester.makeRequest("/match/$year${event}_$match", object : TypeToken<Match>(){})
}