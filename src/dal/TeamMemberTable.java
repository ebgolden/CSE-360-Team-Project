package dal;

import dal.dao.TeamMemberRecordObject;

import java.util.ArrayList;
import java.util.List;

public class TeamMemberTable extends RecordTable<TeamMemberRecordObject> {
    private static List<TeamMemberRecordObject> teamMemberTable = new ArrayList<TeamMemberRecordObject>() {{
        add(new TeamMemberRecordObject(1, "Dinh", "Tam"));
        add(new TeamMemberRecordObject(2, "Glew", "Tyler"));
        add(new TeamMemberRecordObject(3, "Goldenberg", "Edward"));
        add(new TeamMemberRecordObject(4, "Mattison", "Connor"));
        add(new TeamMemberRecordObject(5, "Werner", "Isabella"));
    }};

    @Override
    public boolean addRecord(TeamMemberRecordObject record) {
        boolean recordWithIDExists = recordWithIDExists(record);
        if (recordWithIDExists)
            return false;
        teamMemberTable.add(record);
        return true;
    }

    @Override
    protected boolean recordWithIDExists(TeamMemberRecordObject record) {
        return teamMemberTable.stream().anyMatch(recordInTable -> recordInTable.getID() == record.getID());
    }

    @Override
    public TeamMemberRecordObject[] getRecords() {
        TeamMemberRecordObject[] teamMemberRecordTableArray = new TeamMemberRecordObject[teamMemberTable.size()];
        teamMemberRecordTableArray = teamMemberTable.toArray(teamMemberRecordTableArray);
        return teamMemberRecordTableArray;
    }
}