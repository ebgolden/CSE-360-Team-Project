package sl.visualizevaccinedataservice;

import sl.visualizevaccinedataservice.bll.VisualizeVaccineDataBusinessLogic;
import sl.visualizevaccinedataservice.bll.VisualizeVaccineDataBusinessLogicManager;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesResultObject;

public class GetVaccines {
    private VisualizeVaccineDataBusinessLogicManager visualizeVaccineDataBusinessLogicManager;
    private VisualizeVaccineDataBusinessLogic visualizeVaccineDataBusinessLogic;

    public GetVaccines() {
        visualizeVaccineDataBusinessLogicManager = new VisualizeVaccineDataBusinessLogicManager();
        visualizeVaccineDataBusinessLogic = new VisualizeVaccineDataBusinessLogic();
    }

    public GetVaccinesResponse getGetVaccinesResponse() {
        GetVaccinesResultObject getVaccinesResultObject = visualizeVaccineDataBusinessLogic.getGetVaccinesResultObject();
        return visualizeVaccineDataBusinessLogicManager.getGetVaccinesResponse(getVaccinesResultObject);
    }
}
