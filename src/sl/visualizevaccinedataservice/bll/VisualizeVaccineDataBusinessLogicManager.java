package sl.visualizevaccinedataservice.bll;

import sl.visualizevaccinedataservice.GetVaccinesByLocationResponse;
import sl.visualizevaccinedataservice.GetVaccinesByTypeResponse;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByLocationResultObject;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByTypeResultObject;

public class VisualizeVaccineDataBusinessLogicManager {
    public VisualizeVaccineDataBusinessLogicManager() {
        //constructor code
    }

    public GetVaccinesByLocationResponse getGetVaccinesByLocationResponse(GetVaccinesByLocationResultObject getVaccinesByLocationResultObject) {
        GetVaccinesByLocationResponse getVaccinesByLocationResponse = new GetVaccinesByLocationResponse();
        //code to populate getVaccinesByLocationResponse
        return getVaccinesByLocationResponse;
    }

    public GetVaccinesByTypeResponse getGetVaccinesByTypeResponse(GetVaccinesByTypeResultObject getVaccinesByTypeResultObject) {
        GetVaccinesByTypeResponse getVaccinesByTypeResponse = new GetVaccinesByTypeResponse();
        //code to populate getVaccinesByTypeResponse
        return getVaccinesByTypeResponse;
    }
}
