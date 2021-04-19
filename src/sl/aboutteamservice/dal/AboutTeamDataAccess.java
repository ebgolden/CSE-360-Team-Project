package sl.aboutteamservice.dal;

import dal.dao.TeamMemberRecordObject;
import dal.TeamMemberTable;

public class AboutTeamDataAccess {
    private TeamMemberTable teamMemberTable;

    public AboutTeamDataAccess() {
        teamMemberTable = new TeamMemberTable();
    }

    public TeamMemberRecordObject[] getAboutTeamDataAccessObject() {
        return teamMemberTable.getRecords();
    }
}