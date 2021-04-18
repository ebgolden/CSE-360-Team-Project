package dal.dao;

public class VaccineRecordObject extends PersonRecord {
    private String vaccineType, vaccinationDate, vaccineLocation;

    public VaccineRecordObject() {
        super();
        vaccineType = "";
        vaccinationDate = "";
        vaccineLocation = "";
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccinationDate(String vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccineLocation(String vaccinationLocation) {
        this.vaccineLocation = vaccinationLocation;
    }

    public String getVaccineLocation() {
        return vaccineLocation;
    }
}