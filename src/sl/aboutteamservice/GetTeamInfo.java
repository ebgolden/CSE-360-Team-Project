package sl.aboutteamservice;

import dal.dao.TeamMemberRecordObject;
import sl.aboutteamservice.bll.AboutTeamBusinessLogic;
import sl.aboutteamservice.bll.AboutTeamBusinessLogicManager;

public class GetTeamInfo {
    private AboutTeamBusinessLogicManager aboutTeamBusinessLogicManager;
    private AboutTeamBusinessLogic aboutTeamBusinessLogic;

    public GetTeamInfo() {
        aboutTeamBusinessLogicManager = new AboutTeamBusinessLogicManager();
        aboutTeamBusinessLogic = new AboutTeamBusinessLogic();
    }

    public GetTeamInfoResponse getGetTeamInfoResponse() {
        TeamMemberRecordObject[] teamMemberRecordObjects = aboutTeamBusinessLogic.getTeamMemberRecordObjects();
        return aboutTeamBusinessLogicManager.getGetTeamInfoResponse(teamMemberRecordObjects);
    }
}