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
import sl.visualizevaccinedataservice.*;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main {
    private static GetTeamInfo getTeamInfo = new GetTeamInfo();
    private static LoadVaccineData loadVaccineData = new LoadVaccineData();
    private static AddVaccineData addVaccineData = new AddVaccineData();
    private static SaveVaccineData saveVaccineData = new SaveVaccineData();
    private static GetVaccines getVaccines = new GetVaccines();
    private static GetVaccinesByType getVaccinesByType = new GetVaccinesByType();
    private static GetVaccinesByLocation getVaccinesByLocation = new GetVaccinesByLocation();
    private static JFileChooser fileChooser = new JFileChooser();
    private static final int BAR_CHART_HEIGHT = 325, BAR_CHART_WIDTH = 1000, BAR_CHART_X_START = 250, BAR_CHART_Y_START = 350, BAR_OFFSET = 2;
    private static final Map<JLabel, JLabel> BAR_LABEL_MAP = new HashMap<>();
    private static JTable table = new JTable();
    private static JScrollPane jScrollPane = new JScrollPane(table);
    private static final JFrame jFrame = new JFrame("Covid Data");
    private static final JPanel main = new JPanel(new BorderLayout(5, 5)),
                                menu = new JPanel(new BorderLayout(4, 4)),
                                menuButtons = new JPanel(new GridLayout(0, 1, 3, 3)),
                                screenContent = new JPanel(new BorderLayout(5, 5)),
                                addDataForm = new JPanel(new GridLayout(0, 2, 3, 3)),
                                loadDataForm = new JPanel(new GridLayout(0, 2, 3, 3)),
                                chartPanel = new JPanel(),
                                chartPanelLabels = new JPanel();

    public static void main (String[] args) {
        jFrame.setSize(1000,550);
        jFrame.add(main);
        main.add(menu, BorderLayout.WEST);
        menu.add(new JScrollPane(menuButtons), BorderLayout.CENTER);
        main.add(screenContent, BorderLayout.CENTER);
        chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.LINE_AXIS));
        chartPanelLabels.setLayout(new BoxLayout(chartPanelLabels, BoxLayout.LINE_AXIS));
        JButton about=new JButton("About");
        about.setBounds(0,0,100,50);
        menuButtons.add(about);

        JButton loadData=new JButton("Load Data");
        loadData.setBounds(0,100,100,50);
        menuButtons.add(loadData);

        JButton addData=new JButton("Add Data");
        addData.setBounds(0,150,100,50);
        menuButtons.add(addData);

        JButton saveData=new JButton("Save Data");
        saveData.setBounds(0,200,100,50);
        menuButtons.add(saveData);

        JButton visDataByType=new JButton("Visualize Data by Vaccine Type");
        visDataByType.setBounds(0,350,250,50);
        menuButtons.add(visDataByType);

        JButton visDataByLocation=new JButton("Visualize Data by Vaccine Location");
        visDataByLocation.setBounds(0,400,250,50);
        menuButtons.add(visDataByLocation);
        jFrame.validate();

        main.setLayout(new FlowLayout());
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
        addDataForm.add(date);
        addDataForm.add(dateText);
        date.setVisible(false);
        dateText.setVisible(false);

        JLabel id = new JLabel("ID:");
        JTextField idText = new JTextField("");
        id.setBounds(200,100,100,25);
        idText.setBounds(300,100,100,25);
        addDataForm.add(id);
        addDataForm.add(idText);
        id.setVisible(false);
        idText.setVisible(false);


        JLabel lastName = new JLabel("Last Name:");
        JTextField lNameText = new JTextField("");
        lastName.setBounds(200,150,100,25);
        lNameText.setBounds(300,150,100,25);
        addDataForm.add(lastName);
        addDataForm.add(lNameText);
        lastName.setVisible(false);
        lNameText.setVisible(false);


        JLabel firstName = new JLabel("First Name:");
        JTextField fNameText = new JTextField("");
        firstName.setBounds(200,200,100,25);
        fNameText.setBounds(300,200,100,25);
        addDataForm.add(firstName);
        addDataForm.add(fNameText);
        firstName.setVisible(false);
        fNameText.setVisible(false);


        JLabel vacType = new JLabel("Vaccine Type:");
        JTextField vacText = new JTextField("");
        vacType.setBounds(200,250,100,25);
        vacText.setBounds(300,250,100,25);
        addDataForm.add(vacType);
        addDataForm.add(vacText);
        vacType.setVisible(false);
        vacText.setVisible(false);

        JLabel vacLoc = new JLabel("Vaccine Location:");
        JTextField vacLocText = new JTextField("");
        vacLoc.setBounds(200,300,125,25);
        vacLocText.setBounds(300,300,100,25);
        addDataForm.add(vacLoc);
        addDataForm.add(vacLocText);
        vacLoc.setVisible(false);
        vacLocText.setVisible(false);

        JButton addSubmit=new JButton("Add Record");
        addSubmit.setBounds(250,350,100,50);
        addDataForm.add(addSubmit);
        addSubmit.setVisible(false);

        JLabel addResult = new JLabel("");
        addResult.setBounds(250,400,650,400);
        addResult.setVerticalAlignment(JLabel.TOP);
        addResult.setVisible(false);

        JLabel load = new JLabel("Enter CSV file location:");
        JTextField loadInput = new JTextField("");
        load.setBounds(200,150,150,25);
        loadInput.setBounds(330,150,300,25);
        loadDataForm.add(load);
        loadDataForm.add(loadInput);
        load.setVisible(false);
        loadInput.setVisible(false);

        JButton loadSubmit=new JButton("Submit File");
        loadSubmit.setBounds(250,200,100,50);
        loadDataForm.add(loadSubmit);
        loadSubmit.setVisible(false);

        jFrame.setContentPane(main);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setLocationByPlatform(true);
        jFrame.setMaximumSize(jFrame.getSize());
        jFrame.setVisible(true);

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
            screenContent.add(aboutEx, BorderLayout.CENTER);
            screenContent.remove(addDataForm);
            screenContent.remove(loadDataForm);
            screenContent.remove(addResult);
            screenContent.remove(chartPanel);
            screenContent.remove(chartPanelLabels);
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            main.remove(jScrollPane);
            table.setVisible(false);
            jScrollPane.setVisible(false);
            main.remove(jScrollPane);
            jFrame.setVisible(true);
            jFrame.pack();
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
            screenContent.add(loadDataForm, BorderLayout.CENTER);
            screenContent.remove(aboutEx);
            screenContent.remove(addDataForm);
            screenContent.remove(addResult);
            screenContent.remove(chartPanel);
            screenContent.remove(chartPanelLabels);
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            main.remove(jScrollPane);
            screenContent.add(addResult, BorderLayout.SOUTH);
            table.setVisible(false);
            jScrollPane.setVisible(false);
            main.remove(jScrollPane);

            int returnOperation = fileChooser.showOpenDialog(main);
            if (returnOperation == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                loadInput.setText(file.getAbsolutePath());
            } else {
                loadInput.setText("");
            }
            jFrame.setVisible(true);
            jFrame.pack();
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
                            addResult.setText("Vaccine records successfully added");
                            addResult.setForeground(Color.green);
                            screenContent.remove(aboutEx);
                            screenContent.remove(addDataForm);
                            screenContent.remove(loadDataForm);
                            screenContent.remove(chartPanel);
                            screenContent.remove(chartPanelLabels);
                            GetVaccinesResponse getVaccinesResponse = getVaccines.getGetVaccinesResponse();
                            VaccineRecordObject[] vaccineRecordObjects = getVaccinesResponse.vaccineRecords;
                            List<String[]> vaccineRecordRows = new ArrayList<>(vaccineRecordObjects.length);
                            for (VaccineRecordObject vaccineRecordObject : vaccineRecordObjects) {
                                List<String> vaccineRecordRow = new ArrayList<>();
                                vaccineRecordRow.add(String.valueOf(vaccineRecordObject.getID()));
                                vaccineRecordRow.add(vaccineRecordObject.getLastName());
                                vaccineRecordRow.add(vaccineRecordObject.getFirstName());
                                vaccineRecordRow.add(vaccineRecordObject.getVaccineType());
                                vaccineRecordRow.add(vaccineRecordObject.getVaccinationDate());
                                vaccineRecordRow.add(vaccineRecordObject.getVaccineLocation());
                                String[] vaccineRecordRowArray = new String[vaccineRecordRow.size()];
                                vaccineRecordRowArray = vaccineRecordRow.toArray(vaccineRecordRowArray);
                                vaccineRecordRows.add(vaccineRecordRowArray);
                            }
                            String[][] vaccineRecordRowsArray = new String[vaccineRecordRows.size()][vaccineRecordRows.get(0).length];
                            vaccineRecordRowsArray = vaccineRecordRows.toArray(vaccineRecordRowsArray);
                            String[] columnLabels = new String[] { "ID", "Last Name", "First Name", "Vaccine Type", "Vaccination Date", "Vaccine Location" };
                            DefaultTableModel defaultTableModel = new DefaultTableModel(vaccineRecordRowsArray, columnLabels);
                            table = new JTable(defaultTableModel);
                            jScrollPane = new JScrollPane(table);
                            Dimension tableDimension = jScrollPane.getPreferredSize();
                            jScrollPane.setPreferredSize(new Dimension(tableDimension.width, tableDimension.height / 3));
                            main.add(jScrollPane, BorderLayout.CENTER);
                            jFrame.setContentPane(main);
                            jFrame.setLocationRelativeTo(null);
                            jFrame.setMinimumSize(jFrame.getSize());
                            jFrame.setVisible(true);
                            jFrame.pack();
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
                                errorText += "Records already exists with some of those IDs";
                            errorText += "</html>";
                            addResult.setText(errorText);
                            addResult.setForeground(Color.red);
                        }
                        addResult.setVisible(true);
                    } catch (IOException ioException) {
                        addResult.setText("Invalid file path");
                        addResult.setForeground(Color.red);
                        addResult.setVisible(true);
                    }
                }
            }
            jFrame.setVisible(true);
            jFrame.pack();
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
            screenContent.add(addDataForm, BorderLayout.CENTER);
            screenContent.remove(aboutEx);
            screenContent.remove(loadDataForm);
            screenContent.remove(addResult);
            screenContent.remove(chartPanel);
            screenContent.remove(chartPanelLabels);
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            main.remove(jScrollPane);
            screenContent.add(addResult, BorderLayout.SOUTH);
            load.setVisible(false);
            loadInput.setVisible(false);
            loadSubmit.setVisible(false);
            table.setVisible(false);
            jScrollPane.setVisible(false);
            main.remove(jScrollPane);
            jFrame.setVisible(true);
            jFrame.pack();
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
            jFrame.setVisible(true);
            jFrame.pack();
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
            jFrame.setVisible(true);
            jFrame.pack();
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
            screenContent.remove(addDataForm);
            screenContent.remove(aboutEx);
            screenContent.remove(loadDataForm);
            screenContent.remove(addResult);
            screenContent.add(chartPanel, BorderLayout.CENTER);
            screenContent.add(chartPanelLabels, BorderLayout.SOUTH);
            main.remove(jScrollPane);
            table.setVisible(false);
            jScrollPane.setVisible(false);
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            chartPanel.removeAll();
            chartPanelLabels.removeAll();
            jFrame.setVisible(true);
            jFrame.pack();

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
            jFrame.setVisible(true);
            jFrame.pack();
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
            screenContent.remove(addDataForm);
            screenContent.remove(aboutEx);
            screenContent.remove(loadDataForm);
            screenContent.remove(addResult);
            screenContent.add(chartPanel, BorderLayout.CENTER);
            screenContent.add(chartPanelLabels, BorderLayout.SOUTH);
            main.remove(jScrollPane);
            table.setVisible(false);
            jScrollPane.setVisible(false);
            BAR_LABEL_MAP.forEach(Main::removeBarLabel);
            chartPanel.removeAll();
            chartPanelLabels.removeAll();
            jFrame.setVisible(true);
            jFrame.pack();

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
            jFrame.setVisible(true);
            jFrame.pack();
        });
    }

    private static void createBar(String label, int recordCount, int maxSize, int barWidth, int currentBarIndex) {
        JLabel bar = new JLabel(String.valueOf(recordCount));
        JLabel barLabel = new JLabel(label);
        int barHeight = (int)(BAR_CHART_HEIGHT * ((double)recordCount / maxSize));
        bar.setPreferredSize(new Dimension(barWidth - BAR_OFFSET, barHeight));
        bar.setMaximumSize(new Dimension(barWidth - BAR_OFFSET, barHeight));
        bar.setOpaque(true);
        bar.setBackground(Color.CYAN);
        barLabel.setBounds(BAR_CHART_X_START + (currentBarIndex - 1) * barWidth - BAR_OFFSET, BAR_CHART_Y_START, barWidth, 20);
        barLabel.setPreferredSize(new Dimension(barWidth - BAR_OFFSET, 20));
        barLabel.setMaximumSize(new Dimension(barWidth - BAR_OFFSET, 20));
        bar.setVerticalAlignment(JLabel.TOP);
        bar.setHorizontalAlignment(JLabel.CENTER);
        barLabel.setVerticalAlignment(JLabel.CENTER);
        barLabel.setHorizontalAlignment(JLabel.CENTER);
        bar.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        barLabel.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        barLabel.setFont(new Font(barLabel.getFont().getName(), Font.PLAIN, 8));
        chartPanel.add(bar, BorderLayout.NORTH);
        chartPanelLabels.add(barLabel, BorderLayout.SOUTH);
        bar.setVisible(true);
        barLabel.setVisible(true);
        BAR_LABEL_MAP.put(bar, barLabel);
        JLabel barSpacing = new JLabel();
        barSpacing.setPreferredSize(new Dimension(BAR_OFFSET, 20));
        barSpacing.setMaximumSize(new Dimension(BAR_OFFSET, 20));
        JLabel labelSpacing = new JLabel();
        labelSpacing.setPreferredSize(new Dimension(BAR_OFFSET, 20));
        labelSpacing.setMaximumSize(new Dimension(BAR_OFFSET, 20));
        chartPanel.add(barSpacing);
        chartPanelLabels.add(labelSpacing);

    }

    private static void removeBarLabel(JLabel bar, JLabel label) {
        bar.setVisible(false);
        label.setVisible(false);
        chartPanel.remove(bar);
        chartPanelLabels.remove(label);
    }
}