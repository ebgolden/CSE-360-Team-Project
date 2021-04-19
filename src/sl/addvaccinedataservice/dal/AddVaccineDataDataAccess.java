package sl.addvaccinedataservice.dal;

import dal.dao.VaccineRecordObject;
import dal.dao.VaccineRecordTable;

public class AddVaccineDataDataAccess {
    private static VaccineRecordTable vaccineRecordTable = new VaccineRecordTable();

    public boolean getAddVaccineDataDataAccessResultObject(VaccineRecordObject vaccineRecordObject) {
        boolean successfullyAddedRecord = vaccineRecordTable.addRecord(vaccineRecordObject);
        return successfullyAddedRecord;
    }

    public boolean getLoadVaccineDataDataAccessResultObject(VaccineRecordObject[] vaccineRecordObjects) {
        boolean successfullyAddedRecords = vaccineRecordTable.addRecords(vaccineRecordObjects);
        return successfullyAddedRecords;
    }
}