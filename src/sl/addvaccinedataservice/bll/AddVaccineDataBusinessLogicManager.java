package sl.addvaccinedataservice.bll;

import sl.addvaccinedataservice.AddVaccineDataResponse;
import sl.addvaccinedataservice.LoadVaccineDataResponse;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataResultObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataResultObject;
import java.util.Arrays;

public class AddVaccineDataBusinessLogicManager {
    public AddVaccineDataObject getAddVaccineDataObject(String vaccineData) {
        AddVaccineDataObject addVaccineDataObject = new AddVaccineDataObject();
        String[] vaccineDataAttributes = splitVaccineDataIntoAttributes(vaccineData);
        addVaccineDataObject.id = Integer.parseInt(vaccineDataAttributes[0]);
        addVaccineDataObject.lastName = vaccineDataAttributes[1];
        addVaccineDataObject.firstName = vaccineDataAttributes[2];
        addVaccineDataObject.vaccineType = vaccineDataAttributes[3];
        addVaccineDataObject.vaccinationDate = vaccineDataAttributes[4];
        addVaccineDataObject.vaccineLocation = vaccineDataAttributes[5];
        return addVaccineDataObject;
    }

    private String[] splitVaccineDataIntoAttributes(String vaccineData) {
        return vaccineData.split(",");
    }

    public AddVaccineDataResponse getAddVaccineDataResponse(AddVaccineDataResultObject addVaccineDataResultObject) {
        AddVaccineDataResponse addVaccineDataResponse = new AddVaccineDataResponse();
        addVaccineDataResponse.vaccinationDataSuccessfullyAdded = addVaccineDataResultObject.successfullyAddedRecord;
        return addVaccineDataResponse;
    }

    public LoadVaccineDataObject getLoadVaccineDataObject(String vaccineData) {
        LoadVaccineDataObject loadVaccineDataObject = new LoadVaccineDataObject();
        String[] vaccineDataRows = Arrays.stream(splitVaccineDataIntoRows(vaccineData)).skip(1).toArray(String[]::new);
        loadVaccineDataObject.vaccineDataObjects = new AddVaccineDataObject[vaccineDataRows.length];
        for (int vaccineDataIndex = 0; vaccineDataIndex < vaccineDataRows.length; ++vaccineDataIndex)
            loadVaccineDataObject.vaccineDataObjects[vaccineDataIndex] = getAddVaccineDataObject(vaccineDataRows[vaccineDataIndex]);
        return loadVaccineDataObject;
    }

    private String[] splitVaccineDataIntoRows(String vaccineData) {
        return vaccineData.split("\r\n");
    }

    public LoadVaccineDataResponse getLoadVaccineDataResponse(LoadVaccineDataResultObject loadVaccineDataResultObject) {
        LoadVaccineDataResponse loadVaccineDataResponse = new LoadVaccineDataResponse();
        loadVaccineDataResponse.vaccinationDataSuccessfullyAdded = loadVaccineDataResultObject.successfullyAddedRecords;
        return loadVaccineDataResponse;
    }
}