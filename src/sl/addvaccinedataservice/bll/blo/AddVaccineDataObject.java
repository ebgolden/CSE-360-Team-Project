package sl.addvaccinedataservice.bll.blo;

public class AddVaccineDataObject {
    public int id;
    public String lastName;
    public String firstName;
    public String vaccineType;
    public String vaccinationDate;
    public String vaccineLocation;
    public NumberFormatException idFormatException;
    public NumberFormatException vaccinationDateFormatException;
    public NullPointerException missingInformationException;
}