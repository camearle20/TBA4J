package net.came20.tba4j.data

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by cameronearle on 5/20/17.
 */

data class Team(
        val key: String,
        val name: String,
        val nickname: String,
        val website: String,
        val address: String,
        @SerializedName("gmaps_url") val gmapsUrl: String,
        @SerializedName("location_name") val locationName: String,
        @SerializedName("team_number") val teamNumber: Int,
        @SerializedName("rookie_year") val rookieYear: Int,
        val motto: String
)

data class District(
        val abbreviation: String,
        @SerializedName("display_name") val displayName: String,
        val key: String,
        val year: Int
)

data class Event(
        val key: String,
        val name: String,
        @SerializedName("short_name") val shortName: String,
        @SerializedName("event_code") val eventCode: String,
        @SerializedName("event_type_string") val eventTypeString: String,
        @SerializedName("event_type") val eventType: Int,
        val district: District,
        val year: Int,
        val address: String,
        @SerializedName("gmaps_url") val gmapsUrl: String,
        @SerializedName("location_name") val locationName: String,
        val timezone: String,
        val website: String,
        val webcasts: HashMap<String, Any>,
        val week: Int,
        @SerializedName("start_date") val startDate: String,
        @SerializedName("end_date") val endDate: String
)

data class MatchAlliance(
        val score: Int,
        @SerializedName("team_keys") val teamKeys: List<String>,
        @SerializedName("surrogate_team_keys") val surrogateTeamKeys: List<String>
)

data class MatchAlliancesContainer(
        val red: MatchAlliance,
        val blue: MatchAlliance)

data class MatchVideo(
        val type: String,
        val key: String)

data class Match(
        val key: String,
        @SerializedName("comp_level") val compLevel: String,
        @SerializedName("set_number") val setNumber: Int,
        @SerializedName("match_number") val matchNumber: Int,
        val alliances: MatchAlliancesContainer,
        @SerializedName("score_breakdown") val scoreBreakdown: Map<String, Any>,
        @SerializedName("event_key") val eventKey: String,
        val videos: List<MatchVideo>,
        val time: Long,
        @SerializedName("actual_time") val actualTime: Long,
        @SerializedName("winning_alliance") val winningAlliance: String,
        @SerializedName("predicted_time") val predictedTime: Long,
        @SerializedName("post_result_time") val postResultTime: Long
)

data class AwardRecipient(
        val awardee: String,
        @SerializedName("team_key") val teamKey: String)

data class Award(
        val name: String,
        @SerializedName("award_type") val awardType: Int,
        @SerializedName("event_key") val eventKey: String,
        @SerializedName("recipient_list") val recipientList: List<AwardRecipient>,
        val year: Int
                 )

data class Media(
        val type: String,
        @SerializedName("foreign_key") val foreignKey: String,
        val details: HashMap<String, Any>,
        val preferred: Boolean
)

data class Robot(
        val key: String,
        @SerializedName("team_key") val teamKey: String,
        val year: Int,
        val name: String
)

data class DistrictEventPoints(
        @SerializedName("alliance_points") val alliancePoints: Int,
        @SerializedName("award_points") val awardPoints: Int,
        @SerializedName("district_cmp") val districtCmp: Boolean,
        @SerializedName("elim_points") val elimPoints: Int,
        @SerializedName("event_key") val eventKey: String,
        @SerializedName("qual_points") val qualPoints: Int,
        val total: Int
)

data class DistrictRanking(
        @SerializedName("event_points") val eventPoints: List<DistrictEventPoints>,
        @SerializedName("point_total") val pointTotal: Int,
        val rank: Int,
        @SerializedName("rookie_bonus") val rookieBonus: Int,
        @SerializedName("team_key") val teamKey: String
)

data class AllianceBackup(
        @SerializedName("in") val incoming: String,
        @SerializedName("out") val outgoing: String
)

data class TeamRecord(
        val wins: Int,
        val losses: Int,
        val ties: Int
)

data class TeamAtEventPlayoff(
        @SerializedName("current_level_record") val currentLevelRecord: TeamRecord,
        val level: String,
        @SerializedName("playoff_average") val playoffAverage: Double,
        val record: TeamRecord,
        val status: String
)

data class EventAlliance(
        val name: String,
        val picks: List<String>,
        val declines: List<String>,
        val backup: AllianceBackup,
        val status: TeamAtEventPlayoff
)

data class RankingItem(
        val dq: Int,
        @SerializedName("matches_played") val matchesPlayed: Int,
        @SerializedName("qual_average") val qualAverage: Double,
        val rank: Int,
        val record: TeamRecord,
        @SerializedName("sort_orders") val sortOrders: List<Double>,
        @SerializedName("extra_stats") val extraStats: List<Double>,
        @SerializedName("team_key") val teamKey: String
)

data class RankingSortOrder(
        val name: String,
        val precision: Int
)

data class RankingResponseObject(
        val rankings: List<RankingItem>,
        @SerializedName("sort_order_info") val sortOrderInfo: List<RankingSortOrder>,
        @SerializedName("extra_stats_info") val extraStatsInfo: List<RankingSortOrder>
)

data class TeamAtEventAlliance(
        val backup: AllianceBackup,
        val name: String,
        val number: Int,
        val pick: Int
)

data class TeamAtEventQual(
        val ranking: RankingItem,
        @SerializedName("sort_order_info") val sortOrderInfo: List<RankingSortOrder>,
        @SerializedName("num_teams") val numTeams: Int,
        val status: String
)

data class TeamAtEventStatus(
        val alliance: TeamAtEventAlliance,
        @SerializedName("alliance_status_str") val allianceStatusString: String,
        @SerializedName("overall_status_str") val overallStatusString: String,
        val playoff: TeamAtEventPlayoff,
        val qual: TeamAtEventQual
)

data class EventOPRS(
        val oprs: Map<String, Double>,
        val dprs: Map<String, Double>,
        val ccwms: Map<String, Double>
)

data class Tiebreaker(
        @SerializedName("highest_qual_scores") val highestQualScores: List<Int>,
        @SerializedName("qual_wins") val qualWins: Int
)

data class DistrictPoints(
        val points: Map<String, DistrictEventPoints>,
        val tiebreakers: Map<String, Tiebreaker>
)