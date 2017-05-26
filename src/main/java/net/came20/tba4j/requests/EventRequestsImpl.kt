package net.came20.tba4j.requests

import com.google.gson.reflect.TypeToken
import net.came20.tba4j.data.*
import java.io.InputStream
import java.time.Year

/**
 * Created by cameronearle on 5/21/17.
 */
class EventRequestsImpl(apiKey: String) : RequestsBase(apiKey) {
    @JvmOverloads fun getEvents(year: Int = Year.now().value) = requester.makeRequest("/events/$year", object : TypeToken<List<Event>>(){})
    @JvmOverloads fun getEvent(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event", object : TypeToken<Event>(){})
    @JvmOverloads fun getEventTeams(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event/teams", object : TypeToken<List<Team>>(){})
    @JvmOverloads fun getEventMatches(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event/matches", object : TypeToken<List<Match>>(){})
    @JvmOverloads fun getEventOprs(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event/oprs", object : TypeToken<EventOPRS>(){})
    @JvmOverloads fun getEventInsights(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event/insights", object : TypeToken<Map<String, Any>>(){})
    @JvmOverloads fun getEventRankings(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event/rankings", object : TypeToken<RankingResponseObject>(){})
    @JvmOverloads fun getEventAwards(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event/awards", object : TypeToken<List<Award>>(){})
    @JvmOverloads fun getEventAlliances(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event/alliances", object : TypeToken<List<EventAlliance>>(){})
    @JvmOverloads fun getDistrictPoints(event: String, year: Int = Year.now().value) = requester.makeRequest("/event/$year$event/district_points", object : TypeToken<DistrictPoints>(){})

}