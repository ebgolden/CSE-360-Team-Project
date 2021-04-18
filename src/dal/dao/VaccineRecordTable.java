package dal.dao;

import java.util.ArrayList;
import java.util.List;

public class VaccineRecordTable extends RecordTable<VaccineRecordObject> {
    private List<VaccineRecordObject> vaccineRecordTable;

    public VaccineRecordTable() {
        vaccineRecordTable = new ArrayList<>();
    }

    @Override
    public boolean addRecord(VaccineRecordObject record) {
        boolean recordWithIDExists = recordWithIDExists(record);
        if (recordWithIDExists)
            return false;
        vaccineRecordTable.add(record);
        return true;
    }

    @Override
    public boolean addRecords(List<VaccineRecordObject> records) {
        for (VaccineRecordObject record : records)
            if (recordWithIDExists(record))
                return false;
        for (VaccineRecordObject record : records)
            addRecord(record);
        return true;
    }

    @Override
    protected boolean recordWithIDExists(VaccineRecordObject record) {
        return vaccineRecordTable.stream().anyMatch(recordInTable -> recordInTable.getID() == record.getID());
    }
}