package sl.addvaccinedataservice.bll.blo;

public class LoadVaccineDataResultObject {
    public boolean successfullyAddedRecords;
    public NumberFormatException idFormatException;
    public NumberFormatException vaccinationDateFormatException;
    public NullPointerException missingInformationException;
}