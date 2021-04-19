package sl.savevaccinedataservice.bll;

import dal.dao.VaccineRecordObject;
import sl.savevaccinedataservice.bll.blo.SaveVaccineDataResultObject;
import sl.savevaccinedataservice.dal.SaveVaccineDataDataAccess;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveVaccineDataBusinessLogic {
    private final String FILE_NAME = "vaccine_records.csv";
    private SaveVaccineDataDataAccess saveVaccineDataDataAccess;
    private File vaccineRecordsFile;
    private FileWriter fileWriter;

    public SaveVaccineDataBusinessLogic() {
        saveVaccineDataDataAccess = new SaveVaccineDataDataAccess();
        vaccineRecordsFile = new File(FILE_NAME);
        fileWriter = null;
    }

    public SaveVaccineDataResultObject getSaveVaccineDataResultObject() {
        SaveVaccineDataResultObject saveVaccineDataResultObject = new SaveVaccineDataResultObject();
        VaccineRecordObject[] vaccineRecordObjects = saveVaccineDataDataAccess.getVaccineRecordObjects();
        try {
            fileWriter = new FileWriter(vaccineRecordsFile);
            fileWriter.write("ID,Last Name,First Name,Vaccine Type,Vaccination Date,Vaccine Location");
            for (VaccineRecordObject vaccineRecordObject : vaccineRecordObjects) {
                String vaccineRecordLine = "\r\n" + getVaccineRecordLine(vaccineRecordObject);
                fileWriter.write(vaccineRecordLine);
            }
            fileWriter.close();
            saveVaccineDataResultObject.successfullySavedVaccineData = true;
        }
        catch (IOException e) {
            saveVaccineDataResultObject.successfullySavedVaccineData = false;
        }
        return saveVaccineDataResultObject;
    }

    private String getVaccineRecordLine(VaccineRecordObject vaccineRecordObject) {
        String vaccineRecordLine = "";
        vaccineRecordLine += vaccineRecordObject.getID() + ",";
        vaccineRecordLine += vaccineRecordObject.getLastName() + ",";
        vaccineRecordLine += vaccineRecordObject.getFirstName() + ",";
        vaccineRecordLine += vaccineRecordObject.getVaccineType() + ",";
        vaccineRecordLine += vaccineRecordObject.getVaccinationDate() + ",";
        vaccineRecordLine += vaccineRecordObject.getVaccineLocation();
        return vaccineRecordLine;
    }
}