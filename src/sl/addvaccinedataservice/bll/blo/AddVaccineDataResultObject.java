package sl.addvaccinedataservice.bll.blo;

public class AddVaccineDataResultObject {
    public boolean successfullyAddedRecord;
    public NumberFormatException idFormatException;
    public NumberFormatException vaccinationDateFormatException;
    public NullPointerException missingInformationException;
}