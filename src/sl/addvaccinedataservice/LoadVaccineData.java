package sl.addvaccinedataservice;

import sl.addvaccinedataservice.bll.AddVaccineDataBusinessLogic;
import sl.addvaccinedataservice.bll.AddVaccineDataBusinessLogicManager;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataObject;
import sl.addvaccinedataservice.bll.blo.LoadVaccineDataResultObject;

public class LoadVaccineData {
    private AddVaccineDataBusinessLogicManager addVaccineDataBusinessLogicManager;
    private AddVaccineDataBusinessLogic addVaccineDataBusinessLogic;

    public LoadVaccineData() {
        addVaccineDataBusinessLogicManager = new AddVaccineDataBusinessLogicManager();
        addVaccineDataBusinessLogic = new AddVaccineDataBusinessLogic();
    }

    public LoadVaccineDataResponse getLoadVaccineDataResponse(String vaccineData) {
        LoadVaccineDataObject loadDataObject = addVaccineDataBusinessLogicManager.getLoadVaccineDataObject(vaccineData);
        LoadVaccineDataResultObject loadDataResultObject = addVaccineDataBusinessLogic.getLoadVaccineDataResultObject(loadDataObject);
        return addVaccineDataBusinessLogicManager.getLoadVaccineDataResponse(loadDataResultObject);
    }
}