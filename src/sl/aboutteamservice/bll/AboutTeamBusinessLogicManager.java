package sl.aboutteamservice.bll;

import dal.dao.TeamMemberRecordObject;
import sl.aboutteamservice.GetTeamInfoResponse;
import sl.aboutteamservice.bll.blo.AboutTeamObject;

public class AboutTeamBusinessLogicManager {
    public GetTeamInfoResponse getGetTeamInfoResponse(TeamMemberRecordObject[] teamMemberRecordObjects) {
        GetTeamInfoResponse getTeamInfoResponse = new GetTeamInfoResponse();
        getTeamInfoResponse.teamMemberRecordObjects = teamMemberRecordObjects;
        return getTeamInfoResponse;
    }
}