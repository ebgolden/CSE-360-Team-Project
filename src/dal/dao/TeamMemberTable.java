package dal.dao;

import java.util.ArrayList;
import java.util.List;

public class TeamMemberTable extends RecordTable<TeamMemberRecordObject> {
    private static List<TeamMemberRecordObject> teamMemberTable = new ArrayList<>();

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
    public List<TeamMemberRecordObject> getRecords() {
        return teamMemberTable;
    }
}