package sl.visualizevaccinedataservice;

import dal.dao.VaccineRecordObject;
import java.util.List;
import java.util.Map;

public class GetVaccinesByTypeResponse {
    public Map<String, List<VaccineRecordObject>> vaccineTypeMap;
}