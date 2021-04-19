package sl.visualizevaccinedataservice.dal;

import dal.dao.VaccineRecordObject;
import dal.dao.VaccineRecordTable;

public class VisualizeVaccineDataDataAccess {
    private VaccineRecordTable vaccineRecordTable;

    public VisualizeVaccineDataDataAccess() {
        vaccineRecordTable = new VaccineRecordTable();
    }

    public VaccineRecordObject[] getVaccineRecordObjects() {
        return vaccineRecordTable.getRecords();
    }
}