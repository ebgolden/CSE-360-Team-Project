package sl.visualizevaccinedataservice.bll;

import sl.visualizevaccinedataservice.GetVaccinesByLocationResponse;
import sl.visualizevaccinedataservice.GetVaccinesByTypeResponse;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByLocationResultObject;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByTypeResultObject;

public class VisualizeVaccineDataBusinessLogicManager {
    public GetVaccinesByLocationResponse getGetVaccinesByLocationResponse(GetVaccinesByLocationResultObject getVaccinesByLocationResultObject) {
        GetVaccinesByLocationResponse getVaccinesByLocationResponse = new GetVaccinesByLocationResponse();
        getVaccinesByLocationResponse.vaccineLocationMap = getVaccinesByLocationResultObject.vaccineLocationMap;
        return getVaccinesByLocationResponse;
    }

    public GetVaccinesByTypeResponse getGetVaccinesByTypeResponse(GetVaccinesByTypeResultObject getVaccinesByTypeResultObject) {
        GetVaccinesByTypeResponse getVaccinesByTypeResponse = new GetVaccinesByTypeResponse();
        getVaccinesByTypeResponse.vaccineTypeMap = getVaccinesByTypeResultObject.vaccineTypeMap;
        return getVaccinesByTypeResponse;
    }
}