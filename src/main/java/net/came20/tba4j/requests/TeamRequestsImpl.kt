package net.came20.tba4j.requests

import com.google.gson.reflect.TypeToken
import net.came20.tba4j.data.*
import java.time.Year

/**
 * Created by cameronearle on 5/20/17.
 */

internal class TeamRequestsImpl(apiKey: String) : RequestsBase(apiKey) {
    fun getTeams(page: Int) = requester.makeRequest("/teams/$page", object : TypeToken<List<Team>>(){})
    fun getTeam(teamNumber: Int) = requester.makeRequest("/team/frc$teamNumber", object : TypeToken<Team>(){})
    @JvmOverloads fun getTeamEvents(teamNumber: Int, year: Int = Year.now().value) = requester.makeRequest("/team/frc$teamNumber/events/$year", object : TypeToken<List<Event>>(){})
    @JvmOverloads fun getTeamAwards(teamNumber: Int, event: String, year: Int = Year.now().value) = requester.makeRequest("/team/frc$teamNumber/event/$year$event/awards", object : TypeToken<List<Award>>(){})
    @JvmOverloads fun getTeamMatches(teamNumber: Int, event: String, year: Int = Year.now().value) = requester.makeRequest("/team/frc$teamNumber/event/$year$event/matches", object : TypeToken<List<Match>>(){})
    @JvmOverloads fun getTeamAtEventStatus(teamNumber: Int, event: String, year: Int = Year.now().value) = requester.makeRequest("/team/frc$teamNumber", object : TypeToken<TeamAtEventStatus>(){})
    fun getYearsParticipated(teamNumber: Int) = requester.makeRequest("/team/frc$teamNumber/years_participated", object : TypeToken<List<Int>>(){})
    @JvmOverloads fun getTeamMedia(teamNumber: Int, year: Int = Year.now().value) = requester.makeRequest("/team/frc$teamNumber/media/$year", object : TypeToken<List<Media>>(){})
    @JvmOverloads fun getTeamSocialMedia(teamNumber: Int, year: Int = Year.now().value) = requester.makeRequest("/team/frc$teamNumber/social_media", object : TypeToken<List<Media>>(){})
    fun getTeamRobots(teamNumber: Int) = requester.makeRequest("/team/frc$teamNumber/robots", object : TypeToken<List<Robot>>(){})
    fun getTeamDistricts(teamNumber: Int) = requester.makeRequest("/team/frc$teamNumber/districts", object : TypeToken<List<String>>(){})
}