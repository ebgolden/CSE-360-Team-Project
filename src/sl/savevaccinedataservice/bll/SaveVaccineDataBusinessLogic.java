package sl.savevaccinedataservice.bll;

import sl.savevaccinedataservice.bll.blo.SaveVaccineDataResultObject;
import sl.savevaccinedataservice.dal.SaveVaccineDataDataAccess;
import sl.savevaccinedataservice.dal.SaveVaccineDataDataAccessManager;
import sl.savevaccinedataservice.dal.dao.SaveVaccineDataDataAccessObject;

public class SaveVaccineDataBusinessLogic {
    private SaveVaccineDataDataAccessManager saveVaccineDataDataAccessManager;
    private SaveVaccineDataDataAccess saveVaccineDataDataAccess;

    public SaveVaccineDataBusinessLogic() {
        saveVaccineDataDataAccessManager = new SaveVaccineDataDataAccessManager();
        saveVaccineDataDataAccess = new SaveVaccineDataDataAccess();
    }

    public SaveVaccineDataResultObject getSaveVaccineDataResultObject() {
        SaveVaccineDataDataAccessObject saveVaccineDataDataAccessObject = saveVaccineDataDataAccess.getSaveVaccineDataDataAccessObject();
        SaveVaccineDataResultObject saveVaccineDataResultObject = saveVaccineDataDataAccessManager.getSaveVaccineDataResultObject(saveVaccineDataDataAccessObject);
        saveVaccineDataResultObject = filterSaveVaccineDataResultObject(saveVaccineDataResultObject);
        return saveVaccineDataResultObject;
    }

    private SaveVaccineDataResultObject filterSaveVaccineDataResultObject(SaveVaccineDataResultObject saveVaccineDataResultObject) {
        SaveVaccineDataResultObject filteredSaveVaccineDataResultObject = saveVaccineDataResultObject;
        return filteredSaveVaccineDataResultObject;
    }
}