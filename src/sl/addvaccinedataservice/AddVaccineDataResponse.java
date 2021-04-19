package sl.addvaccinedataservice;

public class AddVaccineDataResponse {
    public boolean vaccinationDataSuccessfullyAdded;
    public NumberFormatException idFormatException;
    public NumberFormatException vaccinationDateFormatException;
    public NullPointerException missingInformationException;
}