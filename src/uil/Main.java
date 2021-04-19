package uil;

import dal.dao.TeamMemberRecordObject;
import dal.dao.VaccineRecordObject;
import sl.aboutteamservice.GetTeamInfo;
import sl.addvaccinedataservice.AddVaccineData;
import sl.addvaccinedataservice.AddVaccineDataResponse;
import sl.addvaccinedataservice.LoadVaccineData;
import sl.addvaccinedataservice.LoadVaccineDataResponse;
import sl.savevaccinedataservice.SaveVaccineData;
import sl.savevaccinedataservice.SaveVaccineDataResponse;
import sl.visualizevaccinedataservice.GetVaccinesByLocation;
import sl.visualizevaccinedataservice.GetVaccinesByLocationResponse;
import sl.visualizevaccinedataservice.GetVaccinesByType;
import sl.visualizevaccinedataservice.GetVaccinesByTypeResponse;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;

public class Main {
    private static GetTeamInfo getTeamInfo = new GetTeamInfo();
    private static LoadVaccineData loadVaccineData = new LoadVaccineData();
    private static AddVaccineData addVaccineData = new AddVaccineData();
    private static SaveVaccineData saveVaccineData = new SaveVaccineData();
    private static GetVaccinesByType getVaccinesByType = new GetVaccinesByType();
    private static GetVaccinesByLocation getVaccinesByLocation = new GetVaccinesByLocation();
    private static JFileChooser fileChooser = new JFileChooser();
    private static final int BAR_CHART_HEIGHT = 325, BAR_CHART_WIDTH = 1000, BAR_CHART_X_START = 250, BAR_CHART_Y_START = 350, BAR_OFFSET = 2;
    private static final Map<JLabel, JLabel> BAR_LABEL_MAP = new HashMap<>();
    private static final JFrame main = new JFrame("Covid Data");

    public static void main (String[] args) {
        JButton about=new JButton("About");
        main.setSize(1000,550);
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

        JButton visDataByType=new JButton("Visualize Data by Vaccine Type");
        visDataByType.setBounds(0,250,250,50);
        main.add(visDataByType);

        JButton visDataByLocation=new JButton("Visualize Data by Vaccine Location");
        visDataByLocation.setBounds(0,300,250,50);
        main.add(visDataByLocation);

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
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            BAR_LABEL_MAP.clear();
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
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            BAR_LABEL_MAP.clear();

            int returnOperation = fileChooser.showOpenDialog(main);
            if (returnOperation == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                loadInput.setText(file.getAbsolutePath());
            } else {
                loadInput.setText("");
            }
        });
        loadSubmit.addActionListener(e -> {
            if (loadInput.getText() != null && !loadInput.getText().equals("")) {
                if (!new File(loadInput.getText()).exists()) {
                    addResult.setVisible(true);
                    addResult.setText("File does not exist");
                    addResult.setForeground(Color.red);
                } else {
                    try {
                        LoadVaccineDataResponse loadVaccineDataResponse = loadVaccineData.getLoadVaccineDataResponse(new String(Files.readAllBytes(Paths.get(loadInput.getText()))));
                        if (loadVaccineDataResponse.vaccinationDataSuccessfullyAdded) {
                            addResult.setText("Vaccine record successfully added");
                            addResult.setForeground(Color.green);
                        } else {
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
                    } catch (IOException ioException) {
                        addResult.setText("Invalid file path");
                        addResult.setForeground(Color.red);
                    }
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
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            BAR_LABEL_MAP.clear();

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

        visDataByType.addActionListener(e -> {
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
            load.setVisible(false);
            loadInput.setVisible(false);
            loadSubmit.setVisible(false);
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            BAR_LABEL_MAP.clear();

            GetVaccinesByTypeResponse getVaccinesByTypeResponse = getVaccinesByType.getGetVaccinesByTypeResponse();
            Map<String, List<VaccineRecordObject>> vaccineTypeMap = getVaccinesByTypeResponse.vaccineTypeMap;
            Map<String, Integer> recordsPerVaccineType = new HashMap<>();
            vaccineTypeMap.forEach((type, records) -> recordsPerVaccineType.put(type, records.size()));
            List<Integer> recordSizes = new ArrayList<>();
            recordsPerVaccineType.forEach((type, recordCount) -> recordSizes.add(recordCount));
            int largestRecordSize = 0;
            if (recordSizes.stream().max(Integer::compare).isPresent())
                largestRecordSize = recordSizes.stream().max(Integer::compare).get();
            int barWidth = BAR_CHART_WIDTH / recordSizes.size();
            AtomicInteger currentBarIndex = new AtomicInteger();
            int finalLargestRecordSize = largestRecordSize;
            recordsPerVaccineType.forEach((type, recordCount) -> createBar(type, recordCount, finalLargestRecordSize, barWidth, currentBarIndex.incrementAndGet()));
        });
        visDataByLocation.addActionListener(e -> {
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
            load.setVisible(false);
            loadInput.setVisible(false);
            loadSubmit.setVisible(false);
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            BAR_LABEL_MAP.clear();

            GetVaccinesByLocationResponse getVaccinesByLocationResponse = getVaccinesByLocation.getGetVaccinesByLocationResponse();
            Map<String, List<VaccineRecordObject>> vaccineLocationMap = getVaccinesByLocationResponse.vaccineLocationMap;
            Map<String, Integer> recordsPerVaccineLocation = new HashMap<>();
            vaccineLocationMap.forEach((location, records) -> recordsPerVaccineLocation.put(location, records.size()));
            List<Integer> recordSizes = new ArrayList<>();
            recordsPerVaccineLocation.forEach((location, recordCount) -> recordSizes.add(recordCount));
            int largestRecordSize = 0;
            if (recordSizes.stream().max(Integer::compare).isPresent())
                largestRecordSize = recordSizes.stream().max(Integer::compare).get();
            int barWidth = BAR_CHART_WIDTH / recordSizes.size();
            AtomicInteger currentBarIndex = new AtomicInteger();
            int finalLargestRecordSize = largestRecordSize;
            recordsPerVaccineLocation.forEach((location, recordCount) -> createBar(location, recordCount, finalLargestRecordSize, barWidth, currentBarIndex.incrementAndGet()));
        });
    }

    private static void createBar(String label, int recordCount, int maxSize, int barWidth, int currentBarIndex) {
        JLabel bar = new JLabel(String.valueOf(recordCount));
        JLabel barLabel = new JLabel(label);
        int barHeight = (int)(BAR_CHART_HEIGHT * ((double)recordCount / maxSize));
        bar.setBounds(BAR_CHART_X_START + (currentBarIndex - 1) * barWidth,BAR_CHART_Y_START - barHeight, barWidth - BAR_OFFSET, barHeight);
        bar.setOpaque(true);
        bar.setBackground(Color.CYAN);
        barLabel.setBounds(BAR_CHART_X_START + (currentBarIndex - 1) * barWidth - BAR_OFFSET, BAR_CHART_Y_START, barWidth, 20);
        bar.setVerticalAlignment(JLabel.TOP);
        bar.setHorizontalAlignment(JLabel.CENTER);
        barLabel.setVerticalAlignment(JLabel.CENTER);
        barLabel.setHorizontalAlignment(JLabel.CENTER);
        barLabel.setFont(new Font(barLabel.getFont().getName(), Font.PLAIN, 8));
        main.add(bar);
        main.add(barLabel, BorderLayout.CENTER);
        bar.setVisible(true);
        barLabel.setVisible(true);
        BAR_LABEL_MAP.put(bar, barLabel);
    }

    private static void removeBarLabel(JLabel bar, JLabel label) {
        bar.setVisible(false);
        label.setVisible(false);
        main.remove(bar);
        main.remove(label);
    }
}