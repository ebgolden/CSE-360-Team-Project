package sl.visualizevaccinedataservice;

import sl.visualizevaccinedataservice.bll.VisualizeVaccineDataBusinessLogic;
import sl.visualizevaccinedataservice.bll.VisualizeVaccineDataBusinessLogicManager;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByTypeResultObject;

public class GetVaccinesByType {
    private VisualizeVaccineDataBusinessLogicManager visualizeVaccineDataBusinessLogicManager;
    private VisualizeVaccineDataBusinessLogic visualizeVaccineDataBusinessLogic;

    public GetVaccinesByType() {
        visualizeVaccineDataBusinessLogicManager = new VisualizeVaccineDataBusinessLogicManager();
        visualizeVaccineDataBusinessLogic = new VisualizeVaccineDataBusinessLogic();
    }

    public GetVaccinesByTypeResponse getGetVaccinesByTypeResponse() {
        GetVaccinesByTypeResultObject getVaccinesByTypeResultObject = visualizeVaccineDataBusinessLogic.getGetVaccinesByTypeResultObject();
        GetVaccinesByTypeResponse getVaccinesByTypeResponse = visualizeVaccineDataBusinessLogicManager.getGetVaccinesByTypeResponse(getVaccinesByTypeResultObject);
        return getVaccinesByTypeResponse;
    }
}