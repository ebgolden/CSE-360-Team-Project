package sl.visualizevaccinedataservice;

import dal.dao.VaccineRecordObject;
import java.util.List;
import java.util.Map;

public class GetVaccinesByLocationResponse {
    public Map<String, List<VaccineRecordObject>> vaccineLocationMap;
}