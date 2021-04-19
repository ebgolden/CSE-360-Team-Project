package sl.aboutteamservice.bll;

import dal.dao.TeamMemberRecordObject;
import sl.aboutteamservice.dal.AboutTeamDataAccess;

public class AboutTeamBusinessLogic {
    private AboutTeamDataAccess aboutTeamDataAccess;

    public AboutTeamBusinessLogic() {
        aboutTeamDataAccess = new AboutTeamDataAccess();
    }

    public TeamMemberRecordObject[] getTeamMemberRecordObjects() {
        return aboutTeamDataAccess.getAboutTeamDataAccessObject();
    }
}