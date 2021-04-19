package sl.aboutteamservice;

import dal.dao.TeamMemberRecordObject;
import sl.aboutteamservice.bll.AboutTeamBusinessLogic;
import sl.aboutteamservice.bll.AboutTeamBusinessLogicManager;
import sl.aboutteamservice.bll.blo.AboutTeamObject;

public class GetTeamInfo {
    private AboutTeamBusinessLogicManager aboutTeamBusinessLogicManager;
    private AboutTeamBusinessLogic aboutTeamBusinessLogic;

    public GetTeamInfo() {
        aboutTeamBusinessLogicManager = new AboutTeamBusinessLogicManager();
        aboutTeamBusinessLogic = new AboutTeamBusinessLogic();
    }

    public GetTeamInfoResponse getGetTeamInfoResponse() {
        TeamMemberRecordObject[] teamMemberRecordObjects = aboutTeamBusinessLogic.getTeamMemberRecordObjects();
        GetTeamInfoResponse getTeamInfoResponse = aboutTeamBusinessLogicManager.getGetTeamInfoResponse(teamMemberRecordObjects);
        return getTeamInfoResponse;
    }
}