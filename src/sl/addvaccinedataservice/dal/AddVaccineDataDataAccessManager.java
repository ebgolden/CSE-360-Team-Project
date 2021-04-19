package sl.addvaccinedataservice.dal;

import dal.dao.VaccineRecordObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataResultObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataResultObject;

public class AddVaccineDataDataAccessManager {
    public VaccineRecordObject getVaccineRecordObject(AddVaccineDataObject addVaccineDataObject) {
        VaccineRecordObject vaccineRecordObject = new VaccineRecordObject();
        vaccineRecordObject.setID(addVaccineDataObject.id);
        vaccineRecordObject.setLastName(addVaccineDataObject.lastName);
        vaccineRecordObject.setFirstName(addVaccineDataObject.firstName);
        vaccineRecordObject.setVaccineType(addVaccineDataObject.vaccineType);
        vaccineRecordObject.setVaccinationDate(addVaccineDataObject.vaccinationDate);
        vaccineRecordObject.setVaccineLocation(addVaccineDataObject.vaccineLocation);
        return vaccineRecordObject;
    }

    public AddVaccineDataResultObject getAddVaccineDataResultObject(boolean successfullyAddedRecord, NumberFormatException idFormatException, NumberFormatException vaccinationDateFormatException, NullPointerException missingInformationException) {
        AddVaccineDataResultObject addVaccineDataResultObject = new AddVaccineDataResultObject();
        addVaccineDataResultObject.successfullyAddedRecord = successfullyAddedRecord;
        addVaccineDataResultObject.idFormatException = idFormatException;
        addVaccineDataResultObject.vaccinationDateFormatException = vaccinationDateFormatException;
        addVaccineDataResultObject.missingInformationException = missingInformationException;
        return addVaccineDataResultObject;
    }

    public VaccineRecordObject[] getVaccineRecordObjects(LoadVaccineDataObject loadVaccineDataObject) {
        VaccineRecordObject[] vaccineRecordObjects = new VaccineRecordObject[loadVaccineDataObject.vaccineDataObjects.length];
        for (int vaccineRecordIndex = 0; vaccineRecordIndex < loadVaccineDataObject.vaccineDataObjects.length; ++vaccineRecordIndex)
            vaccineRecordObjects[vaccineRecordIndex] = getVaccineRecordObject(loadVaccineDataObject.vaccineDataObjects[vaccineRecordIndex]);
        return vaccineRecordObjects;
    }

    public LoadVaccineDataResultObject getLoadVaccineDataResultObject(boolean successfullyAddedRecords, NumberFormatException idFormatException, NumberFormatException vaccinationDateFormatException, NullPointerException missingInformationException) {
        LoadVaccineDataResultObject loadVaccineDataResultObject = new LoadVaccineDataResultObject();
        loadVaccineDataResultObject.successfullyAddedRecords = successfullyAddedRecords;
        loadVaccineDataResultObject.idFormatException = idFormatException;
        loadVaccineDataResultObject.vaccinationDateFormatException = vaccinationDateFormatException;
        loadVaccineDataResultObject.missingInformationException = missingInformationException;
        return loadVaccineDataResultObject;
    }
}