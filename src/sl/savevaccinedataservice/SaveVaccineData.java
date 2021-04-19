package sl.savevaccinedataservice;

import sl.savevaccinedataservice.bll.SaveVaccineDataBusinessLogic;
import sl.savevaccinedataservice.bll.SaveVaccineDataBusinessLogicManager;
import sl.savevaccinedataservice.bll.blo.SaveVaccineDataResultObject;

public class SaveVaccineData {
    private SaveVaccineDataBusinessLogic saveVaccineDataBusinessLogic;
    private SaveVaccineDataBusinessLogicManager saveVaccineDataBusinessLogicManager;

    public SaveVaccineData() {
        saveVaccineDataBusinessLogic = new SaveVaccineDataBusinessLogic();
        saveVaccineDataBusinessLogicManager = new SaveVaccineDataBusinessLogicManager();
    }

    public SaveVaccineDataResponse getSaveVaccineDataResponse() {
        SaveVaccineDataResultObject saveVaccineDataResultObject = saveVaccineDataBusinessLogic.getSaveVaccineDataResultObject();
        return saveVaccineDataBusinessLogicManager.getSaveVaccineDataResponse(saveVaccineDataResultObject);
    }
}