package sl.addvaccinedataservice.dal;

import dal.dao.VaccineRecordObject;
import dal.dao.VaccineRecordTable;

public class AddVaccineDataDataAccess {
    private static VaccineRecordTable vaccineRecordTable = new VaccineRecordTable();

    public boolean getAddVaccineDataDataAccessResultObject(VaccineRecordObject vaccineRecordObject) {
        return vaccineRecordTable.addRecord(vaccineRecordObject);
    }

    public boolean getLoadVaccineDataDataAccessResultObject(VaccineRecordObject[] vaccineRecordObjects) {
        return vaccineRecordTable.addRecords(vaccineRecordObjects);
    }
}