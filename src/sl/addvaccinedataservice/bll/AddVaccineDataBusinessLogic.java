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
        boolean successfullyAddedRecord = false;
        if (addVaccineDataObject.idFormatException == null && addVaccineDataObject.vaccinationDateFormatException == null && addVaccineDataObject.missingInformationException == null) {
            VaccineRecordObject vaccineRecordObject = addVaccineDataDataAccessManager.getVaccineRecordObject(addVaccineDataObject);
            successfullyAddedRecord = addVaccineDataDataAccess.getAddVaccineDataDataAccessResultObject(vaccineRecordObject);
        }
        return addVaccineDataDataAccessManager.getAddVaccineDataResultObject(successfullyAddedRecord, addVaccineDataObject.idFormatException, addVaccineDataObject.vaccinationDateFormatException, addVaccineDataObject.missingInformationException);
    }

    public LoadVaccineDataResultObject getLoadVaccineDataResultObject(LoadVaccineDataObject loadVaccineDataObject) {
        boolean successfullyAddedRecords = false;
        NumberFormatException idFormatException = null;
        NumberFormatException vaccinationDateFormatException = null;
        NullPointerException missingInformationException = null;
        for (AddVaccineDataObject addVaccineDataObject : loadVaccineDataObject.vaccineDataObjects) {
            if (idFormatException == null && addVaccineDataObject.idFormatException != null)
                idFormatException = addVaccineDataObject.idFormatException;
            if (vaccinationDateFormatException == null && addVaccineDataObject.vaccinationDateFormatException != null)
                vaccinationDateFormatException = addVaccineDataObject.vaccinationDateFormatException;
            if (missingInformationException == null && addVaccineDataObject.missingInformationException != null)
                missingInformationException = addVaccineDataObject.missingInformationException;
        }
        if (idFormatException == null && vaccinationDateFormatException == null && missingInformationException == null) {
            VaccineRecordObject[] vaccineRecordObjects = addVaccineDataDataAccessManager.getVaccineRecordObjects(loadVaccineDataObject);
            successfullyAddedRecords = addVaccineDataDataAccess.getLoadVaccineDataDataAccessResultObject(vaccineRecordObjects);
        }
        return addVaccineDataDataAccessManager.getLoadVaccineDataResultObject(successfullyAddedRecords, idFormatException, vaccinationDateFormatException, missingInformationException);
    }
}