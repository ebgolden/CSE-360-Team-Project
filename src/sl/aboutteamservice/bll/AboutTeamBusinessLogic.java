package sl.aboutteamservice.bll;

import dal.dao.TeamMemberRecordObject;
import sl.aboutteamservice.dal.AboutTeamDataAccess;

public class AboutTeamBusinessLogic {
    private AboutTeamDataAccess aboutTeamDataAccess;

    public AboutTeamBusinessLogic() {
        aboutTeamDataAccess = new AboutTeamDataAccess();
    }

    public TeamMemberRecordObject[] getTeamMemberRecordObjects() {
        TeamMemberRecordObject[] teamMemberRecordObjects = aboutTeamDataAccess.getAboutTeamDataAccessObject();
        teamMemberRecordObjects = filterAboutTeamObject(teamMemberRecordObjects);
        return teamMemberRecordObjects;
    }

    private TeamMemberRecordObject[] filterAboutTeamObject(TeamMemberRecordObject[] teamMemberRecordObjects) {
        TeamMemberRecordObject[] filteredTeamMemberRecordObjects = teamMemberRecordObjects;
        return filteredTeamMemberRecordObjects;
    }
}