package sl.visualizevaccinedataservice.dal;

import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByLocationResultObject;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByTypeResultObject;
import sl.visualizevaccinedataservice.dal.dao.VisualizeVaccineDataDataAccessObject;

public class VisualizeVaccineDataDataAccessManager {
    public VisualizeVaccineDataDataAccessManager() {
        //constructor code
    }

    public GetVaccinesByLocationResultObject getGetVaccinesByLocationResultObject(VisualizeVaccineDataDataAccessObject visualizeVaccineDataDataAccessObject) {
        GetVaccinesByLocationResultObject getVaccinesByLocationResultObject = new GetVaccinesByLocationResultObject();
        //code to populate getVaccinesByLocationResultObject
        return getVaccinesByLocationResultObject;
    }

    public GetVaccinesByTypeResultObject getGetVaccinesByTypeResultObject(VisualizeVaccineDataDataAccessObject visualizeVaccineDataDataAccessObject) {
        GetVaccinesByTypeResultObject getVaccinesByTypeResultObject = new GetVaccinesByTypeResultObject();
        //code to populate getVaccinesByTypeResultObject
        return getVaccinesByTypeResultObject;
    }
}
