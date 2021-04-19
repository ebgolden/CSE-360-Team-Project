package sl.visualizevaccinedataservice.bll.blo;

import dal.dao.VaccineRecordObject;
import java.util.List;
import java.util.Map;

public class GetVaccinesByTypeResultObject {
    public Map<String, List<VaccineRecordObject>> vaccineTypeMap;
}