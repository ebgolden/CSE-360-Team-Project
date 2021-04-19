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
    public boolean addRecords(List<TeamMemberRecordObject> records) {
        for (TeamMemberRecordObject record : records)
            if (recordWithIDExists(record))
                return false;
        for (TeamMemberRecordObject record : records)
            addRecord(record);
        return true;
    }

    @Override
    protected boolean recordWithIDExists(TeamMemberRecordObject record) {
        return teamMemberTable.stream().anyMatch(recordInTable -> recordInTable.getID() == record.getID());
    }
}