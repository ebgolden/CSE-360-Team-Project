package sl.savevaccinedataservice.dal;

import dal.dao.VaccineRecordObject;
import dal.VaccineRecordTable;

public class SaveVaccineDataDataAccess {
    private VaccineRecordTable vaccineRecordTable;

    public SaveVaccineDataDataAccess() {
        vaccineRecordTable = new VaccineRecordTable();
    }

    public VaccineRecordObject[] getVaccineRecordObjects() {
        return vaccineRecordTable.getRecords();
    }
}