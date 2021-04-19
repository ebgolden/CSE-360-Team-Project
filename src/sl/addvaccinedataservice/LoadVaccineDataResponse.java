package sl.addvaccinedataservice;

public class LoadVaccineDataResponse {
    public boolean vaccinationDataSuccessfullyAdded;
    public NumberFormatException idFormatException;
    public NumberFormatException vaccinationDateFormatException;
    public NullPointerException missingInformationException;
}