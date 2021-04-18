package sl.aboutteamservice;

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
        AboutTeamObject aboutTeamObject = aboutTeamBusinessLogic.getAboutTeamObject();
        GetTeamInfoResponse getTeamInfoResponse = aboutTeamBusinessLogicManager.getGetTeamInfoResponse(aboutTeamObject);
        return getTeamInfoResponse;
    }
}
