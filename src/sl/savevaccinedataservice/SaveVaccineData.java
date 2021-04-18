package sl.savevaccinedataservice;

import sl.savevaccinedataservice.bll.SaveVaccineDataBusinessLogic;
import sl.savevaccinedataservice.bll.SaveVaccineDataBusinessLogicManager;
import sl.savevaccinedataservice.bll.blo.SaveVaccineDataResultObject;

public class SaveVaccineData {
    private SaveVaccineDataBusinessLogicManager saveVaccineDataBusinessLogicManager;
    private SaveVaccineDataBusinessLogic saveVaccineDataBusinessLogic;

    public SaveVaccineData() {
        saveVaccineDataBusinessLogicManager = new SaveVaccineDataBusinessLogicManager();
        saveVaccineDataBusinessLogic = new SaveVaccineDataBusinessLogic();
    }

    public SaveVaccineDataResponse getSaveDataResponse() {
        SaveVaccineDataResultObject saveVaccineDataResultObject = saveVaccineDataBusinessLogic.getSaveVaccineDataResultObject();
        SaveVaccineDataResponse saveVaccineDataResponse = saveVaccineDataBusinessLogicManager.getSaveVaccineDataResponse(saveVaccineDataResultObject);
        return saveVaccineDataResponse;
    }
}
