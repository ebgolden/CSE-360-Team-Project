package sl.addvaccinedataservice.dal;

import sl.addvaccinedataservice.AddVaccineDataResponse;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataResultObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataResultObject;
import sl.addvaccinedataservice.dal.dao.AddVaccineDataDataAccessObject;
import sl.addvaccinedataservice.dal.dao.AddVaccineDataDataAccessResultObject;

public class AddVaccineDataDataAccessManager {
    public AddVaccineDataDataAccessManager() {
        //constructor code
    }

    public AddVaccineDataDataAccessObject getAddVaccineDataDataAccessObject(AddVaccineDataObject addVaccineDataObject) {
        AddVaccineDataDataAccessObject addVaccineDataDataAccessObject = new AddVaccineDataDataAccessObject();
        //code to populate addVaccineDataDataAccessObject
        return addVaccineDataDataAccessObject;
    }

    public AddVaccineDataResultObject getAddVaccineDataResultObject(AddVaccineDataDataAccessResultObject addVaccineDataDataAccessResultObject) {
        AddVaccineDataResultObject addVaccineDataResultObject = new AddVaccineDataResultObject();
        //code to populate addVaccineDataResultObject
        return addVaccineDataResultObject;
    }

    public AddVaccineDataDataAccessObject getAddVaccineDataDataAccessObject(LoadVaccineDataObject loadVaccineDataObject) {
        AddVaccineDataDataAccessObject addVaccineDataDataAccessObject = new AddVaccineDataDataAccessObject();
        //code to populate addVaccineDataDataAccessObject
        return addVaccineDataDataAccessObject;
    }

    public LoadVaccineDataResultObject getLoadVaccineDataResultObject(AddVaccineDataDataAccessResultObject addVaccineDataDataAccessResultObject) {
        LoadVaccineDataResultObject loadVaccineDataResultObject = new LoadVaccineDataResultObject();
        //code to populate loadVaccineDataResultObject
        return loadVaccineDataResultObject;
    }
}