package sl.visualizevaccinedataservice;

import sl.visualizevaccinedataservice.bll.VisualizeVaccineDataBusinessLogic;
import sl.visualizevaccinedataservice.bll.VisualizeVaccineDataBusinessLogicManager;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByLocationResultObject;

public class GetVaccinesByLocation {
    private VisualizeVaccineDataBusinessLogicManager visualizeVaccineDataBusinessLogicManager;
    private VisualizeVaccineDataBusinessLogic visualizeVaccineDataBusinessLogic;

    public GetVaccinesByLocation() {
        visualizeVaccineDataBusinessLogicManager = new VisualizeVaccineDataBusinessLogicManager();
        visualizeVaccineDataBusinessLogic = new VisualizeVaccineDataBusinessLogic();
    }

    public GetVaccinesByLocationResponse getGetVaccinesByLocationResponse() {
        GetVaccinesByLocationResultObject getVaccinesByLocationResultObject = visualizeVaccineDataBusinessLogic.getGetVaccinesByLocationResultObject();
        return visualizeVaccineDataBusinessLogicManager.getGetVaccinesByLocationResponse(getVaccinesByLocationResultObject);
    }
}