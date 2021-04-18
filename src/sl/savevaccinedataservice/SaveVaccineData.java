package sl.savevaccinedataservice;

import sl.savevaccinedataservice.bll.SaveVaccineDataBusinessLogic;

public class SaveVaccineData {
    private SaveVaccineDataBusinessLogic saveVaccineDataBusinessLogic;

    public SaveVaccineData() {
        saveVaccineDataBusinessLogic = new SaveVaccineDataBusinessLogic();
    }

    public void getSaveDataResponse() {
        saveVaccineDataBusinessLogic.getSaveVaccineDataResultObject();
    }
}