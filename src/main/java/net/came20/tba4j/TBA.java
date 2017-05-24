package net.came20.tba4j;

import net.came20.tba4j.requests.*;

public class TBA {
    public final DistrictRequestsImpl DistrictRequests;
    public final EventRequestsImpl EventRequests;
    public final MatchRequestsImpl MatchRequests;
    public final TeamRequestsImpl TeamRequests;

    public TBA(String apiKey) {
        DistrictRequests = new DistrictRequestsImpl(apiKey);
        EventRequests = new EventRequestsImpl(apiKey);
        MatchRequests = new MatchRequestsImpl(apiKey);
        TeamRequests = new TeamRequestsImpl(apiKey);
    }
}