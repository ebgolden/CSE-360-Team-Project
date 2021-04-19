package sl.aboutteamservice.dal;

import dal.dao.TeamMemberRecordObject;
import dal.dao.TeamMemberTable;

import java.util.List;

public class AboutTeamDataAccess {
    private TeamMemberTable teamMemberTable;

    public AboutTeamDataAccess() {
        teamMemberTable = new TeamMemberTable();
    }

    public TeamMemberRecordObject[] getAboutTeamDataAccessObject() {
        List<TeamMemberRecordObject> teamMemberTableRecords = teamMemberTable.getRecords();
        TeamMemberRecordObject[] teamMemberDataAccessObjects = new TeamMemberRecordObject[teamMemberTableRecords.size()];
        for (int teamMemberIndex = 0; teamMemberIndex < teamMemberTableRecords.size(); ++teamMemberIndex)
            teamMemberDataAccessObjects[teamMemberIndex] = teamMemberTableRecords.get(teamMemberIndex);
        return teamMemberDataAccessObjects;
    }
}