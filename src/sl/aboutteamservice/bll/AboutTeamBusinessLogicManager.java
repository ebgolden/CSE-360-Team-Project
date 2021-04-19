package sl.aboutteamservice.bll;

import dal.dao.TeamMemberRecordObject;
import sl.aboutteamservice.GetTeamInfoResponse;

public class AboutTeamBusinessLogicManager {
    public GetTeamInfoResponse getGetTeamInfoResponse(TeamMemberRecordObject[] teamMemberRecordObjects) {
        GetTeamInfoResponse getTeamInfoResponse = new GetTeamInfoResponse();
        getTeamInfoResponse.teamMemberRecordObjects = teamMemberRecordObjects;
        return getTeamInfoResponse;
    }
}