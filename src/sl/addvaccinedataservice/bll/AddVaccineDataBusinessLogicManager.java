package sl.addvaccinedataservice.bll;

import sl.addvaccinedataservice.AddVaccineDataRequest;
import sl.addvaccinedataservice.AddVaccineDataResponse;
import sl.addvaccinedataservice.LoadVaccineDataRequest;
import sl.addvaccinedataservice.LoadVaccineDataResponse;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataResultObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataResultObject;

public class AddVaccineDataBusinessLogicManager {
    public AddVaccineDataBusinessLogicManager() {
        //constructor code
    }

    public AddVaccineDataObject getAddVaccineDataObject(AddVaccineDataRequest addVaccineDataRequest) {
        AddVaccineDataObject addVaccineDataObject = new AddVaccineDataObject();
        //code to populate addVaccineDataObject
        return addVaccineDataObject;
    }

    public AddVaccineDataResponse getAddVaccineDataResponse(AddVaccineDataResultObject addVaccineDataResultObject) {
        AddVaccineDataResponse addVaccineDataResponse = new AddVaccineDataResponse();
        //code to populate addVaccineDataResponse
        return addVaccineDataResponse;
    }

    public LoadVaccineDataObject getLoadVaccineDataObject(LoadVaccineDataRequest loadVaccineDataRequest) {
        LoadVaccineDataObject loadVaccineDataObject = new LoadVaccineDataObject();
        //code to populate loadVaccineDataObject
        return loadVaccineDataObject;
    }

    public LoadVaccineDataResponse getLoadVaccineDataResponse(LoadVaccineDataResultObject loadVaccineDataResultObject) {
        LoadVaccineDataResponse loadVaccineDataResponse = new LoadVaccineDataResponse();
        //code to populate loadVaccineDataResponse
        return loadVaccineDataResponse;
    }
}
