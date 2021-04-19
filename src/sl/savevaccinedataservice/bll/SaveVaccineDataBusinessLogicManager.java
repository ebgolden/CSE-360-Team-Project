package sl.savevaccinedataservice.bll;

import sl.savevaccinedataservice.SaveVaccineDataResponse;
import sl.savevaccinedataservice.bll.blo.SaveVaccineDataResultObject;

public class SaveVaccineDataBusinessLogicManager {
    public SaveVaccineDataResponse getSaveVaccineDataResponse(SaveVaccineDataResultObject saveVaccineDataResultObject) {
        SaveVaccineDataResponse saveVaccineDataResponse = new SaveVaccineDataResponse();
        saveVaccineDataResponse.successfullySavedVaccineData = saveVaccineDataResultObject.successfullySavedVaccineData;
        return saveVaccineDataResponse;
    }
}
