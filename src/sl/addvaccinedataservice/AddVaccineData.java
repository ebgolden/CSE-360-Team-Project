package sl.addvaccinedataservice;

import sl.addvaccinedataservice.bll.AddVaccineDataBusinessLogic;
import sl.addvaccinedataservice.bll.AddVaccineDataBusinessLogicManager;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.AddVaccineDataResultObject;

public class AddVaccineData {
    private AddVaccineDataBusinessLogicManager addVaccineDataBusinessLogicManager;
    private AddVaccineDataBusinessLogic addVaccineDataBusinessLogic;

    public AddVaccineData() {
        addVaccineDataBusinessLogicManager = new AddVaccineDataBusinessLogicManager();
        addVaccineDataBusinessLogic = new AddVaccineDataBusinessLogic();
    }

    public AddVaccineDataResponse getAddVaccineDataResponse(AddVaccineDataRequest addVaccineDataRequest) {
        AddVaccineDataObject addDataObject = addVaccineDataBusinessLogicManager.getAddVaccineDataObject(addVaccineDataRequest);
        AddVaccineDataResultObject addDataResultObject = addVaccineDataBusinessLogic.getAddVaccineDataResultObject(addDataObject);
        AddVaccineDataResponse addVaccineDataResponse = addVaccineDataBusinessLogicManager.getAddVaccineDataResponse(addDataResultObject);
        return addVaccineDataResponse;
    }
}