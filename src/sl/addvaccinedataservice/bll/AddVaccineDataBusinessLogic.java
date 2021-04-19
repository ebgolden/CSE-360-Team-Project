package sl.addvaccinedataservice.bll;

import dal.dao.VaccineRecordObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataResultObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataResultObject;
import sl.addvaccinedataservice.dal.AddVaccineDataDataAccess;
import sl.addvaccinedataservice.dal.AddVaccineDataDataAccessManager;

public class AddVaccineDataBusinessLogic {
    private AddVaccineDataDataAccessManager addVaccineDataDataAccessManager;
    private AddVaccineDataDataAccess addVaccineDataDataAccess;

    public AddVaccineDataBusinessLogic() {
        addVaccineDataDataAccessManager = new AddVaccineDataDataAccessManager();
        addVaccineDataDataAccess = new AddVaccineDataDataAccess();
    }

    public AddVaccineDataResultObject getAddVaccineDataResultObject(AddVaccineDataObject addVaccineDataObject) {
        VaccineRecordObject vaccineRecordObject = addVaccineDataDataAccessManager.getVaccineRecordObject(addVaccineDataObject);
        boolean successfullyAddedRecord = addVaccineDataDataAccess.getAddVaccineDataDataAccessResultObject(vaccineRecordObject);
        AddVaccineDataResultObject addVaccineDataResultObject = addVaccineDataDataAccessManager.getAddVaccineDataResultObject(successfullyAddedRecord);
        return addVaccineDataResultObject;
    }

    public LoadVaccineDataResultObject getLoadVaccineDataResultObject(LoadVaccineDataObject loadVaccineDataObject) {
        VaccineRecordObject[] vaccineRecordObjects = addVaccineDataDataAccessManager.getVaccineRecordObjects(loadVaccineDataObject);
        boolean successfullyAddedRecords = addVaccineDataDataAccess.getLoadVaccineDataDataAccessResultObject(vaccineRecordObjects);
        LoadVaccineDataResultObject loadVaccineDataResultObject = addVaccineDataDataAccessManager.getLoadVaccineDataResultObject(successfullyAddedRecords);
        return loadVaccineDataResultObject;
    }
}