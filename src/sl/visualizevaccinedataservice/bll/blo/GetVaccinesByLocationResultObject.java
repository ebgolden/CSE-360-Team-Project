package sl.visualizevaccinedataservice.bll.blo;

import dal.dao.VaccineRecordObject;
import java.util.List;
import java.util.Map;

public class GetVaccinesByLocationResultObject {
    public Map<String, List<VaccineRecordObject>> vaccineLocationMap;
}