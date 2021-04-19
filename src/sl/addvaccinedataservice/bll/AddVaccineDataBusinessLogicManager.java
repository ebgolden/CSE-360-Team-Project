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
        if (vaccineDataAttributes.length < 6)
            addVaccineDataObject.missingInformationException = new NullPointerException("Vaccine record 1: All fields must be completed");
        else {
            try {
                addVaccineDataObject.id = Integer.parseInt(vaccineDataAttributes[0]);
            } catch (NumberFormatException e) {
                addVaccineDataObject.idFormatException = new NumberFormatException("Vaccine record 1: ID must be a numerical and a positive integer");
            }
            addVaccineDataObject.lastName = vaccineDataAttributes[1];
            addVaccineDataObject.firstName = vaccineDataAttributes[2];
            addVaccineDataObject.vaccineType = vaccineDataAttributes[3];
            addVaccineDataObject.vaccinationDate = vaccineDataAttributes[4];
            String[] vaccinationDateSplit = addVaccineDataObject.vaccinationDate.split("/");
            boolean dateFormatCorrect = (vaccinationDateSplit.length != 3 || vaccinationDateSplit[0].length() != 2 || vaccinationDateSplit[1].length() != 2 || vaccinationDateSplit[2].length() != 2);
            try {
                Integer.parseInt(vaccinationDateSplit[0]);
                Integer.parseInt(vaccinationDateSplit[1]);
                Integer.parseInt(vaccinationDateSplit[2]);
            } catch (NumberFormatException e) {
                dateFormatCorrect = false;
            }
            if (!dateFormatCorrect)
                addVaccineDataObject.vaccinationDateFormatException = new NumberFormatException("Vaccine record 1: Vaccination Date must be formatted as mm/dd/yyyy and each part must be a positive integer");
            addVaccineDataObject.vaccineLocation = vaccineDataAttributes[5];
            for (String vaccineDataAttribute : vaccineDataAttributes) {
                if (vaccineDataAttribute == null || vaccineDataAttribute.equals("")) {
                    addVaccineDataObject.missingInformationException = new NullPointerException("Vaccine record 1: All fields must be completed");
                    break;
                }
            }
        }
        return addVaccineDataObject;
    }

    private String[] splitVaccineDataIntoAttributes(String vaccineData) {
        return vaccineData.split(",");
    }

    public AddVaccineDataResponse getAddVaccineDataResponse(AddVaccineDataResultObject addVaccineDataResultObject) {
        AddVaccineDataResponse addVaccineDataResponse = new AddVaccineDataResponse();
        addVaccineDataResponse.vaccinationDataSuccessfullyAdded = addVaccineDataResultObject.successfullyAddedRecord;
        addVaccineDataResponse.idFormatException = addVaccineDataResultObject.idFormatException;
        addVaccineDataResponse.vaccinationDateFormatException = addVaccineDataResultObject.vaccinationDateFormatException;
        addVaccineDataResponse.missingInformationException = addVaccineDataResultObject.missingInformationException;
        return addVaccineDataResponse;
    }

    public LoadVaccineDataObject getLoadVaccineDataObject(String vaccineData) {
        LoadVaccineDataObject loadVaccineDataObject = new LoadVaccineDataObject();
        String[] vaccineDataRows = Arrays.stream(splitVaccineDataIntoRows(vaccineData)).skip(1).toArray(String[]::new);
        loadVaccineDataObject.vaccineDataObjects = new AddVaccineDataObject[vaccineDataRows.length];
        for (int vaccineDataIndex = 0; vaccineDataIndex < vaccineDataRows.length; ++vaccineDataIndex) {
            loadVaccineDataObject.vaccineDataObjects[vaccineDataIndex] = getAddVaccineDataObject(vaccineDataRows[vaccineDataIndex]);
            if (loadVaccineDataObject.vaccineDataObjects[vaccineDataIndex].idFormatException != null)
                loadVaccineDataObject.vaccineDataObjects[vaccineDataIndex].idFormatException = new NumberFormatException("Vaccine record " + (vaccineDataIndex + 1) + ": ID must be a numerical and a positive integer");
            if (loadVaccineDataObject.vaccineDataObjects[vaccineDataIndex].vaccinationDateFormatException != null)
                loadVaccineDataObject.vaccineDataObjects[vaccineDataIndex].vaccinationDateFormatException = new NumberFormatException("Vaccine record " + (vaccineDataIndex + 1) + ": Vaccination Date must be formatted as mm/dd/yyyy and each part must be a positive integer");
            if (loadVaccineDataObject.vaccineDataObjects[vaccineDataIndex].missingInformationException != null)
                loadVaccineDataObject.vaccineDataObjects[vaccineDataIndex].missingInformationException = new NullPointerException("Vaccine record " + (vaccineDataIndex + 1) + ": All fields must be completed");
        }
        return loadVaccineDataObject;
    }

    private String[] splitVaccineDataIntoRows(String vaccineData) {
        return vaccineData.split("\r\n");
    }

    public LoadVaccineDataResponse getLoadVaccineDataResponse(LoadVaccineDataResultObject loadVaccineDataResultObject) {
        LoadVaccineDataResponse loadVaccineDataResponse = new LoadVaccineDataResponse();
        loadVaccineDataResponse.vaccinationDataSuccessfullyAdded = loadVaccineDataResultObject.successfullyAddedRecords;
        loadVaccineDataResponse.idFormatException = loadVaccineDataResultObject.idFormatException;
        loadVaccineDataResponse.vaccinationDateFormatException = loadVaccineDataResultObject.vaccinationDateFormatException;
        loadVaccineDataResponse.missingInformationException = loadVaccineDataResultObject.missingInformationException;
        return loadVaccineDataResponse;
    }
}