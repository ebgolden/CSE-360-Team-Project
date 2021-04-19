package sl.visualizevaccinedataservice.bll;

import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByLocationResultObject;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByTypeResultObject;
import sl.visualizevaccinedataservice.dal.VisualizeVaccineDataDataAccess;
import sl.visualizevaccinedataservice.dal.VisualizeVaccineDataDataAccessManager;
import sl.visualizevaccinedataservice.dal.dao.VisualizeVaccineDataDataAccessObject;

public class VisualizeVaccineDataBusinessLogic {
    private VisualizeVaccineDataDataAccessManager visualizeVaccineDataDataAccessManager;
    private VisualizeVaccineDataDataAccess visualizeVaccineDataDataAccess;

    public VisualizeVaccineDataBusinessLogic() {
        visualizeVaccineDataDataAccessManager = new VisualizeVaccineDataDataAccessManager();
        visualizeVaccineDataDataAccess = new VisualizeVaccineDataDataAccess();
    }

    public GetVaccinesByLocationResultObject getGetVaccinesByLocationResultObject() {
        VisualizeVaccineDataDataAccessObject visualizeVaccineDataDataAccessObject = visualizeVaccineDataDataAccess.getVisualizeVaccineDataDataAccessObject();
        GetVaccinesByLocationResultObject getVaccinesByLocationResultObject = visualizeVaccineDataDataAccessManager.getGetVaccinesByLocationResultObject(visualizeVaccineDataDataAccessObject);
        getVaccinesByLocationResultObject = filterGetVaccinesByLocationResultObject(getVaccinesByLocationResultObject);
        return getVaccinesByLocationResultObject;
    }

    private GetVaccinesByLocationResultObject filterGetVaccinesByLocationResultObject(GetVaccinesByLocationResultObject getVaccinesByLocationResultObject) {
        GetVaccinesByLocationResultObject filteredGetVaccinesByLocationResultObject = getVaccinesByLocationResultObject;
        return filteredGetVaccinesByLocationResultObject;
    }

    public GetVaccinesByTypeResultObject getGetVaccinesByTypeResultObject() {
        VisualizeVaccineDataDataAccessObject visualizeVaccineDataDataAccessObject = visualizeVaccineDataDataAccess.getVisualizeVaccineDataDataAccessObject();
        GetVaccinesByTypeResultObject getVaccinesByTypeResultObject = visualizeVaccineDataDataAccessManager.getGetVaccinesByTypeResultObject(visualizeVaccineDataDataAccessObject);
        getVaccinesByTypeResultObject = filterGetVaccinesByTypeResultObject(getVaccinesByTypeResultObject);
        return getVaccinesByTypeResultObject;
    }

    private GetVaccinesByTypeResultObject filterGetVaccinesByTypeResultObject(GetVaccinesByTypeResultObject getVaccinesByTypeResultObject) {
        GetVaccinesByTypeResultObject filteredGetVaccinesByTypeResultObject = getVaccinesByTypeResultObject;
        return filteredGetVaccinesByTypeResultObject;
    }
}