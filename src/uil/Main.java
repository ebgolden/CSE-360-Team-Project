package uil;

import dal.dao.TeamMemberRecordObject;
import sl.aboutteamservice.GetTeamInfo;
import sl.addvaccinedataservice.AddVaccineData;
import sl.addvaccinedataservice.AddVaccineDataResponse;
import sl.addvaccinedataservice.LoadVaccineData;
import sl.addvaccinedataservice.LoadVaccineDataResponse;
import sl.savevaccinedataservice.SaveVaccineData;
import sl.savevaccinedataservice.SaveVaccineDataResponse;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;

public class Main {
    private static GetTeamInfo getTeamInfo = new GetTeamInfo();
    private static LoadVaccineData loadVaccineData = new LoadVaccineData();
    private static AddVaccineData addVaccineData = new AddVaccineData();
    private static SaveVaccineData saveVaccineData = new SaveVaccineData();
    private static JFileChooser fc = new JFileChooser();

    public static void main (String[] args) {
        JFrame main=new JFrame("Covid Data");

        JButton about=new JButton("About");
        main.setSize(800,500);
        about.setBounds(0,0,100,50);
        main.add(about);

        JButton loadData=new JButton("Load Data");
        loadData.setBounds(0,100,100,50);
        main.add(loadData);

        JButton addData=new JButton("Add Data");
        addData.setBounds(0,150,100,50);
        main.add(addData);

        JButton saveData=new JButton("Save Data");
        saveData.setBounds(0,200,100,50);
        main. add(saveData);

        JButton visData=new JButton("Visualize Data");
        visData.setBounds(0,250,150,50);
        main.add(visData);

        main.setLayout(null);
        main.setVisible(true);
        Font font = new Font("Serif", Font.BOLD, 16);

        final JTextArea aboutEx=new JTextArea();
        aboutEx.setBounds(200,0, 300,300);
        aboutEx.setVisible(false);
        aboutEx.setFont(font);


        JLabel date = new JLabel("Date:");
        JTextField dateText = new JTextField("");
        date.setBounds(200,50,100,25);
        dateText.setBounds(300,50,100,25);
        main.add(date);
        main.add(dateText);
        date.setVisible(false);
        dateText.setVisible(false);

        JLabel id = new JLabel("ID:");
        JTextField idText = new JTextField("");
        id.setBounds(200,100,100,25);
        idText.setBounds(300,100,100,25);
        main.add(id);
        main.add(idText);
        id.setVisible(false);
        idText.setVisible(false);


        JLabel lastName = new JLabel("Last Name:");
        JTextField lNameText = new JTextField("");
        lastName.setBounds(200,150,100,25);
        lNameText.setBounds(300,150,100,25);
        main.add(lastName);
        main.add(lNameText);
        lastName.setVisible(false);
        lNameText.setVisible(false);


        JLabel firstName = new JLabel("First Name:");
        JTextField fNameText = new JTextField("");
        firstName.setBounds(200,200,100,25);
        fNameText.setBounds(300,200,100,25);
        main.add(firstName);
        main.add(fNameText);
        firstName.setVisible(false);
        fNameText.setVisible(false);


        JLabel vacType = new JLabel("Vaccine Type:");
        JTextField vacText = new JTextField("");
        vacType.setBounds(200,250,100,25);
        vacText.setBounds(300,250,100,25);
        main.add(vacType);
        main.add(vacText);
        vacType.setVisible(false);
        vacText.setVisible(false);

        JLabel vacLoc = new JLabel("Vaccine Location:");
        JTextField vacLocText = new JTextField("");
        vacLoc.setBounds(200,300,125,25);
        vacLocText.setBounds(300,300,100,25);
        main.add(vacLoc);
        main.add(vacLocText);
        vacLoc.setVisible(false);
        vacLocText.setVisible(false);

        JButton addSubmit=new JButton("Add Record");
        addSubmit.setBounds(250,350,100,50);
        main.add(addSubmit);
        addSubmit.setVisible(false);

        JLabel addResult = new JLabel("");
        addResult.setBounds(250,400,650,400);
        main.add(addResult);
        addResult.setVerticalAlignment(JLabel.TOP);
        addResult.setVisible(false);

        JLabel load = new JLabel("Enter CSV file location:");
        JTextField loadInput = new JTextField("");
        load.setBounds(200,150,150,25);
        loadInput.setBounds(330,150,300,25);
        main.add(load);
        main.add(loadInput);
        load.setVisible(false);
        loadInput.setVisible(false);

        JButton loadSubmit=new JButton("Submit File");
        loadSubmit.setBounds(250,200,100,50);
        main.add(loadSubmit);
        loadSubmit.setVisible(false);

        main.add(aboutEx);





        about.addActionListener(e -> {
            date.setVisible(false);
            dateText.setVisible(false);
            id.setVisible(false);
            idText.setVisible(false);
            lastName.setVisible(false);
            lNameText.setVisible(false);
            firstName.setVisible(false);
            fNameText.setVisible(false);
            vacType.setVisible(false);
            vacText.setVisible(false);
            vacLoc.setVisible(false);
            vacLocText.setVisible(false);
            addSubmit.setVisible(false);
            addResult.setVisible(false);
            load.setVisible(false);
            loadInput.setVisible(false);
            loadSubmit.setVisible(false);
            TeamMemberRecordObject[] teamMemberRecordObjects = getTeamInfo.getGetTeamInfoResponse().teamMemberRecordObjects;
            StringBuilder aboutExText = new StringBuilder("Program for Visualizing Covid Data\nGroup Number 9\n");
            for (TeamMemberRecordObject teamMemberRecordObject : teamMemberRecordObjects)
                aboutExText.append("\nTeam Member ").append(teamMemberRecordObject.getID()).append("\n").append(teamMemberRecordObject.getFirstName()).append(" ").append(teamMemberRecordObject.getLastName());
            aboutEx.setText(aboutExText.toString());
            aboutEx.setEditable(false);
            aboutEx.setVisible(true);

        });


        loadData.addActionListener(e -> {
            aboutEx.setVisible(false);
            date.setVisible(false);
            dateText.setVisible(false);
            id.setVisible(false);
            idText.setVisible(false);
            lastName.setVisible(false);
            lNameText.setVisible(false);
            firstName.setVisible(false);
            fNameText.setVisible(false);
            vacType.setVisible(false);
            vacText.setVisible(false);
            vacLoc.setVisible(false);
            vacLocText.setVisible(false);
            addSubmit.setVisible(false);
            addResult.setVisible(false);
            load.setVisible(true);
            loadInput.setVisible(true);
            loadSubmit.setVisible(true);

            int returnVal = fc.showOpenDialog(main);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                loadInput.setText(file.getAbsolutePath());
            } else {
                loadInput.setText("");
            }
        });
        loadSubmit.addActionListener(e -> {
            if (loadInput.getText() != null && !loadInput.getText().equals(""))
            {
                try {
                    LoadVaccineDataResponse loadVaccineDataResponse = loadVaccineData.getLoadVaccineDataResponse(new String(Files.readAllBytes(Paths.get(loadInput.getText()))));
                    if (loadVaccineDataResponse.vaccinationDataSuccessfullyAdded) {
                        addResult.setText("Vaccine record successfully added");
                        addResult.setForeground(Color.green);
                    }
                    else {
                        String errorText = "<html>";
                        if (loadVaccineDataResponse.idFormatException != null)
                            errorText += loadVaccineDataResponse.idFormatException.getMessage() + "<br/>";
                        if (loadVaccineDataResponse.vaccinationDateFormatException != null)
                            errorText += loadVaccineDataResponse.vaccinationDateFormatException.getMessage() + "<br/>";
                        if (loadVaccineDataResponse.missingInformationException != null)
                            errorText += loadVaccineDataResponse.missingInformationException.getMessage();
                        if (loadVaccineDataResponse.idFormatException == null && loadVaccineDataResponse.vaccinationDateFormatException == null && loadVaccineDataResponse.missingInformationException == null)
                            errorText += "A record already exists with that ID";
                        errorText += "</html>";
                        addResult.setText(errorText);
                        addResult.setForeground(Color.red);
                    }
                    addResult.setVisible(true);
                }
                catch (IOException ioException) {
                    addResult.setText("Invalid file path");
                    addResult.setForeground(Color.red);
                }
            }
        });
        addData.addActionListener(e -> {
            aboutEx.setVisible(false);
            date.setVisible(true);
            dateText.setVisible(true);
            id.setVisible(true);
            idText.setVisible(true);
            lastName.setVisible(true);
            lNameText.setVisible(true);
            firstName.setVisible(true);
            fNameText.setVisible(true);
            vacType.setVisible(true);
            vacText.setVisible(true);
            addSubmit.setVisible(true);
            addResult.setVisible(false);
            vacLoc.setVisible(true);
            vacLocText.setVisible(true);
            load.setVisible(false);
            loadInput.setVisible(false);
            loadSubmit.setVisible(false);


        });
        addSubmit.addActionListener(e -> {
            String vaccineDataString = idText.getText().replace(",", " ")
                                    + "," + lNameText.getText().replace(",", " ")
                                    + "," + fNameText.getText().replace(",", " ")
                                    + "," + vacText.getText().replace(",", " ")
                                    + "," + dateText.getText().replace(",", " ")
                                    + "," + vacLocText.getText().replace(",", " ");
            AddVaccineDataResponse addVaccineDataResponse = addVaccineData.getAddVaccineDataResponse(vaccineDataString);
            if (addVaccineDataResponse.vaccinationDataSuccessfullyAdded) {
                addResult.setText("Vaccine record successfully added");
                addResult.setForeground(Color.green);
            }
            else {
                String errorText = "<html>";
                if (addVaccineDataResponse.idFormatException != null)
                    errorText += addVaccineDataResponse.idFormatException.getMessage() + "<br/>";
                if (addVaccineDataResponse.vaccinationDateFormatException != null)
                    errorText += addVaccineDataResponse.vaccinationDateFormatException.getMessage() + "<br/>";
                if (addVaccineDataResponse.missingInformationException != null)
                    errorText += addVaccineDataResponse.missingInformationException.getMessage();
                if (addVaccineDataResponse.idFormatException == null && addVaccineDataResponse.vaccinationDateFormatException == null && addVaccineDataResponse.missingInformationException == null)
                    errorText += "A record already exists with that ID";
                errorText += "</html>";
                addResult.setText(errorText);
                addResult.setForeground(Color.red);
            }
            addResult.setVisible(true);
        });
        saveData.addActionListener(e -> {
            SaveVaccineDataResponse saveVaccineDataResponse = saveVaccineData.getSaveVaccineDataResponse();
            if (saveVaccineDataResponse.successfullySavedVaccineData) {
                addResult.setText("Vaccine records successfully saved");
                addResult.setForeground(Color.green);
            }
            else {
                addResult.setText("Vaccine records could not be saved");
                addResult.setForeground(Color.red);
            }
            addResult.setVisible(true);
        });

    }
}