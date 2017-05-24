package net.came20.tba4j.requests

import com.google.gson.reflect.TypeToken
import net.came20.tba4j.data.District
import net.came20.tba4j.data.DistrictRanking
import net.came20.tba4j.data.Event
import net.came20.tba4j.data.Team
import java.time.Year

/**
 * Created by cameronearle on 5/22/17.
 */
internal class DistrictRequestsImpl(apiKey: String) : RequestsBase(apiKey) {
    @JvmOverloads fun getDistricts(year: Int = Year.now().value) = requester.makeRequest("/districts/$year", object : TypeToken<List<District>>(){})
    @JvmOverloads fun getDistrictEvents(district: String, year: Int = Year.now().value) = requester.makeRequest("/district/$year$district/events", object : TypeToken<List<Event>>(){})
    @JvmOverloads fun getDistrictRankings(district: String, year: Int = Year.now().value) = requester.makeRequest("/district/$year$district/rankings", object : TypeToken<List<DistrictRanking>>(){})
    @JvmOverloads fun getDistrictTeams(district: String, year: Int = Year.now().value) = requester.makeRequest("/district/$year$district/teams", object : TypeToken<List<Team>>(){})
}