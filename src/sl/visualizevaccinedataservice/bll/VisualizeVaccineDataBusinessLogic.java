package sl.visualizevaccinedataservice.bll;

import dal.dao.VaccineRecordObject;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByLocationResultObject;
import sl.visualizevaccinedataservice.bll.blo.GetVaccinesByTypeResultObject;
import sl.visualizevaccinedataservice.dal.VisualizeVaccineDataDataAccess;
import java.util.*;
import java.util.stream.Collectors;

public class VisualizeVaccineDataBusinessLogic {
    private VisualizeVaccineDataDataAccess visualizeVaccineDataDataAccess;

    public VisualizeVaccineDataBusinessLogic() {
        visualizeVaccineDataDataAccess = new VisualizeVaccineDataDataAccess();
    }

    public GetVaccinesByLocationResultObject getGetVaccinesByLocationResultObject() {
        VaccineRecordObject[] vaccineRecordObjects = visualizeVaccineDataDataAccess.getVaccineRecordObjects();
        return sortGetVaccinesByLocationResultObject(vaccineRecordObjects);
    }

    private GetVaccinesByLocationResultObject sortGetVaccinesByLocationResultObject(VaccineRecordObject[] vaccineRecordObjects) {
        GetVaccinesByLocationResultObject sortedGetVaccinesByLocationResultObject = new GetVaccinesByLocationResultObject();
        sortedGetVaccinesByLocationResultObject.vaccineLocationMap = Arrays.stream(vaccineRecordObjects).collect(Collectors.groupingBy(VaccineRecordObject::getVaccineLocation, Collectors.mapping(record -> record, Collectors.toList())));
        return sortedGetVaccinesByLocationResultObject;
    }

    public GetVaccinesByTypeResultObject getGetVaccinesByTypeResultObject() {
        VaccineRecordObject[] vaccineRecordObjects = visualizeVaccineDataDataAccess.getVaccineRecordObjects();
        return sortGetVaccinesByTypeResultObject(vaccineRecordObjects);
    }

    private GetVaccinesByTypeResultObject sortGetVaccinesByTypeResultObject(VaccineRecordObject[] vaccineRecordObjects) {
        GetVaccinesByTypeResultObject sortedGetVaccinesByTypeResultObject = new GetVaccinesByTypeResultObject();
        sortedGetVaccinesByTypeResultObject.vaccineTypeMap = Arrays.stream(vaccineRecordObjects).collect(Collectors.groupingBy(VaccineRecordObject::getVaccineType, Collectors.mapping(record -> record, Collectors.toList())));
        return sortedGetVaccinesByTypeResultObject;
    }
}