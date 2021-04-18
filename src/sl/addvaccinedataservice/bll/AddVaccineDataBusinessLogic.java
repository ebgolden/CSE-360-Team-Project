package sl.addvaccinedataservice.bll;

import sl.aboutteamservice.bll.blo.AboutTeamObject;
import sl.aboutteamservice.dal.AboutTeamDataAccess;
import sl.aboutteamservice.dal.AboutTeamDataAccessManager;
import sl.aboutteamservice.dal.dao.AboutTeamDataAccessObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataResultObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataResultObject;
import sl.addvaccinedataservice.dal.AddVaccineDataDataAccess;
import sl.addvaccinedataservice.dal.AddVaccineDataDataAccessManager;
import sl.addvaccinedataservice.dal.dao.AddVaccineDataDataAccessObject;
import sl.addvaccinedataservice.dal.dao.AddVaccineDataDataAccessResultObject;

public class AddVaccineDataBusinessLogic {
    private AddVaccineDataDataAccessManager addVaccineDataDataAccessManager;
    private AddVaccineDataDataAccess addVaccineDataDataAccess;

    public AddVaccineDataBusinessLogic() {
        addVaccineDataDataAccessManager = new AddVaccineDataDataAccessManager();
        addVaccineDataDataAccess = new AddVaccineDataDataAccess();
    }

    public AddVaccineDataResultObject getAddVaccineDataResultObject(AddVaccineDataObject addVaccineDataObject) {
        AddVaccineDataDataAccessObject addVaccineDataDataAccessObject = addVaccineDataDataAccessManager.getAddVaccineDataDataAccessObject(addVaccineDataObject);
        AddVaccineDataDataAccessResultObject addVaccineDataDataAccessResultObject = addVaccineDataDataAccess.getAddVaccineDataDataAccessResultObject(addVaccineDataDataAccessObject);
        AddVaccineDataResultObject addVaccineDataResultObject = addVaccineDataDataAccessManager.getAddVaccineDataResultObject(addVaccineDataDataAccessResultObject);
        addVaccineDataResultObject = filterAddVaccineDataResultObject(addVaccineDataResultObject);
        return addVaccineDataResultObject;
    }

    private AddVaccineDataResultObject filterAddVaccineDataResultObject(AddVaccineDataResultObject addVaccineDataResultObject) {
        AddVaccineDataResultObject filteredAddVaccineDataResultObject = addVaccineDataResultObject;
        return filteredAddVaccineDataResultObject;
    }

    public LoadVaccineDataResultObject getLoadVaccineDataResultObject(LoadVaccineDataObject loadVaccineDataObject) {
        AddVaccineDataDataAccessObject addVaccineDataDataAccessObject = addVaccineDataDataAccessManager.getAddVaccineDataDataAccessObject(loadVaccineDataObject);
        AddVaccineDataDataAccessResultObject addVaccineDataDataAccessResultObject = addVaccineDataDataAccess.getAddVaccineDataDataAccessResultObject(addVaccineDataDataAccessObject);
        LoadVaccineDataResultObject loadVaccineDataResultObject = addVaccineDataDataAccessManager.getLoadVaccineDataResultObject(addVaccineDataDataAccessResultObject);
        loadVaccineDataResultObject = filterLoadVaccineDataResultObject(loadVaccineDataResultObject);
        return loadVaccineDataResultObject;
    }

    private LoadVaccineDataResultObject filterLoadVaccineDataResultObject(LoadVaccineDataResultObject loadVaccineDataResultObject) {
        LoadVaccineDataResultObject filteredLoadVaccineDataResultObject = loadVaccineDataResultObject;
        return filteredLoadVaccineDataResultObject;
    }
}