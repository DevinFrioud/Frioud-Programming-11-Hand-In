package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Optional;

public class Controller {
    public RadioButton recordSelectButton;
    public RadioButton cassetteSelectButton;
    public RadioButton cdSelectButton;
    public Label configLabel1;
    public Label configLabel2;
    public Label configLabel3;
    public Button addMediaButton;
    public Button clearEntryButton;
    final ToggleGroup record = new ToggleGroup();
    final ToggleGroup cassette = new ToggleGroup();
    final ToggleGroup CD = new ToggleGroup();
    public TextField nameField;
    public TextField conditionField;
    public TextField genreField;
    public TextField catNumberField;
    public TextField artistField;
    public TextField config1Field;
    public TextField config2Field;
    public TextField labelField;
    public TextField releaseYearField;
    public TextField config3Field;
    public ListView<Media> mediaList = new ListView<>();
    public Label displayConfigLabel1;
    public Label displayConfigLabel2;
    public Label displayConfigLabel3;
    public Label formatLabel;
    public Label nameLabel;
    public Label conditionLabel;
    public Label labelLabel;
    public Label catNumberLabel;
    public Label releaseYearLabel;
    public Label genreLabel;
    public Label artistLabel;
    public Label config1LabelResult;
    public Label config2LabelResult;
    public Label config3LabelResult;
    public Button deleteSelectedButton;
    public Button saveMediaButton;
    public Button loadMediaButton;
//method to set up the Add Media page to add a record
    public void switchOptionsRecord(ActionEvent actionEvent) {
        recordSelectButton.setToggleGroup(record);
        recordSelectButton.setSelected(true);
        cassetteSelectButton.setToggleGroup(cassette);
        cassetteSelectButton.setSelected(false);
        cdSelectButton.setToggleGroup(CD);
        cdSelectButton.setSelected(false);
        configLabel1.setText("Speed:");
        configLabel2.setText("Size:");
        configLabel3.setText("Colour:");

    }
    //method to set up the Add Media page to add a cassette
    public void switchOptionsCassette(ActionEvent actionEvent) {
        recordSelectButton.setToggleGroup(record);
        recordSelectButton.setSelected(false);
        cassetteSelectButton.setToggleGroup(cassette);
        cassetteSelectButton.setSelected(true);
        cdSelectButton.setToggleGroup(CD);
        cdSelectButton.setSelected(false);
        configLabel1.setText("Length:");
        configLabel2.setText("Tape Type:");
        configLabel3.setText("Colour:");
    }
    //method to set up the Add Media page to add a CD
    public void switchOptionsCD(ActionEvent actionEvent) {
        recordSelectButton.setToggleGroup(record);
        recordSelectButton.setSelected(false);
        cassetteSelectButton.setToggleGroup(cassette);
        cassetteSelectButton.setSelected(false);
        cdSelectButton.setToggleGroup(CD);
        cdSelectButton.setSelected(true);
        configLabel1.setText("Length:");
        configLabel2.setText("Bit Rate:");
        configLabel3.setText("Colour:");
    }
// runs a method to add record, cassette, or CD depending on which is selected according to the radio buttons
    public void addMedia(ActionEvent actionEvent) {
        if (recordSelectButton.isSelected() == true){
            addRecord();
        }
        else if (cassetteSelectButton.isSelected() == true){
            addCassette();
        }
        else if (cdSelectButton.isSelected() == true){
            addCD();
        }
    }
// clears all text entered in the fields of the add media page
    public void clearEntry(ActionEvent actionEvent) {
        nameField.setText("");
        conditionField.setText("");
        labelField.setText("");
        catNumberField.setText("");
        releaseYearField.setText("");
        genreField.setText("");
        artistField.setText("");
        config1Field.setText("");
        config2Field.setText("");
        config3Field.setText("");
    }
// method to create a record object and add it to the listView with the info entered in the add media page
    public void addRecord (){
        String name = nameField.getText();
        String condition = conditionField.getText();
        String label = labelField.getText();
        String catNumber = catNumberField.getText();
        int releaseYear = Integer.parseInt(releaseYearField.getText());
        String genre = genreField.getText();
        String artist = artistField.getText();
        int speed = Integer.parseInt(config1Field.getText());
        int size = Integer.parseInt(config2Field.getText());
        String colour = config3Field.getText();
        Record temp  = new Record(name, condition, label, catNumber, releaseYear, genre, artist,"record", speed, size, colour);
        mediaList.getItems().add(temp);
        nameField.clear();
        conditionField.clear();
        labelField.clear();
        catNumberField.clear();
        releaseYearField.clear();
        genreField.clear();
        artistField.clear();
        config1Field.clear();
        config2Field.clear();
        config3Field.clear();
    }
    // method to create a cassette object and add it to the listView with the info entered in the add media page
    public void addCassette (){
        String name = nameField.getText();
        String condition = conditionField.getText();
        String label = labelField.getText();
        String catNumber = catNumberField.getText();
        int releaseYear = Integer.parseInt(releaseYearField.getText());
        String genre = genreField.getText();
        String artist = artistField.getText();
        String length = config1Field.getText();
        String tapeType = config2Field.getText();
        String colour = config3Field.getText();
        Cassette temp  = new Cassette(name, condition, label, catNumber, releaseYear, genre, artist, "cassette", length, tapeType, colour);
        mediaList.getItems().add(temp);
        nameField.clear();
        conditionField.clear();
        labelField.clear();
        catNumberField.clear();
        releaseYearField.clear();
        genreField.clear();
        artistField.clear();
        config1Field.clear();
        config2Field.clear();
        config3Field.clear();
    }
    // method to create a CD object and add it to the listView with the info entered in the add media page
    public void addCD () {
        String name = nameField.getText();
        String condition = conditionField.getText();
        String label = labelField.getText();
        String catNumber = catNumberField.getText();
        int releaseYear = Integer.parseInt(releaseYearField.getText());
        String genre = genreField.getText();
        String artist = artistField.getText();
        String length = config1Field.getText();
        String bitRate = config2Field.getText();
        String colour = config3Field.getText();
        CompactDisk temp = new CompactDisk(name, condition, label, catNumber, releaseYear, genre, artist, "CD", length, bitRate, colour);
        mediaList.getItems().add(temp);
        nameField.clear();
        conditionField.clear();
        labelField.clear();
        catNumberField.clear();
        releaseYearField.clear();
        genreField.clear();
        artistField.clear();
        config1Field.clear();
        config2Field.clear();
        config3Field.clear();

    }

    // displays the details of the media saved in the listview
    public void displayMedia(MouseEvent mouseEvent) {
        Media temp;
        temp = mediaList.getSelectionModel().getSelectedItem();
        if (temp.getFormat().equals("record")){
            temp = mediaList.getSelectionModel().getSelectedItem();
            formatLabel.setText("Record");
            nameLabel.setText(temp.getName());
            conditionLabel.setText(temp.getCondition());
            labelLabel.setText(temp.getLabel());
            catNumberLabel.setText(temp.getCatNumber());
            releaseYearLabel.setText(Integer.toString(temp.getReleaseYear()));
            genreLabel.setText(temp.getGenre());
            artistLabel.setText(temp.getArtist());
            displayConfigLabel1.setText("Speed:");
            displayConfigLabel2.setText("Size:");
            displayConfigLabel3.setText("Colour:");
            config1LabelResult.setText(temp.get1Configs());
            config2LabelResult.setText(temp.get2Configs());
            config3LabelResult.setText(temp.get3Configs());
        }
        else if (temp.getFormat().equals("cassette")){
            formatLabel.setText("Cassette");
            temp = mediaList.getSelectionModel().getSelectedItem();
            nameLabel.setText(temp.getName());
            conditionLabel.setText(temp.getCondition());
            labelLabel.setText(temp.getLabel());
            catNumberLabel.setText(temp.getCatNumber());
            releaseYearLabel.setText(Integer.toString(temp.getReleaseYear()));
            genreLabel.setText(temp.getGenre());
            artistLabel.setText(temp.getArtist());
            displayConfigLabel1.setText("Length:");
            displayConfigLabel2.setText("Tape Type:");
            displayConfigLabel3.setText("Colour:");
            config1LabelResult.setText(temp.get1Configs());
            config2LabelResult.setText(temp.get2Configs());
            config3LabelResult.setText(temp.get3Configs());
        }
        else if (temp.getFormat().equals("CD")){
            formatLabel.setText("CD");
            temp = mediaList.getSelectionModel().getSelectedItem();
            nameLabel.setText(temp.getName());
            conditionLabel.setText(temp.getCondition());
            labelLabel.setText(temp.getLabel());
            catNumberLabel.setText(temp.getCatNumber());
            releaseYearLabel.setText(Integer.toString(temp.getReleaseYear()));
            genreLabel.setText(temp.getGenre());
            artistLabel.setText(temp.getArtist());
            displayConfigLabel1.setText("Length:");
            displayConfigLabel2.setText("Bit Rate:");
            displayConfigLabel3.setText("Colour:");
            config1LabelResult.setText(temp.get1Configs());
            config2LabelResult.setText(temp.get2Configs());
            config3LabelResult.setText(temp.get3Configs());
        }

    }
//deletes a selected item from the listview, and clears the displayed info
    public void deleteSelected(ActionEvent actionEvent) {
        Media temp;
        temp = mediaList.getSelectionModel().getSelectedItem();
        mediaList.getItems().remove(temp);
        formatLabel.setText("");
        nameLabel.setText("");
        conditionLabel.setText("");
        labelLabel.setText("");
        catNumberLabel.setText("");
        releaseYearLabel.setText("");
        genreLabel.setText("");
        artistLabel.setText("");
        config1LabelResult.setText("");
        config2LabelResult.setText("");
        config3LabelResult.setText("");

    }
//method to save media
    public void saveMedia(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Media");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(null);
        ObservableList<Media>mediaObservableList;
        mediaObservableList = mediaList.getItems();
        String seperator = "}";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Media each: mediaObservableList){
            writer.write(each.getFormat() + seperator + each.getName() + seperator + each.getCondition() + seperator + each.getLabel() + seperator + each.getCatNumber() + seperator + each.getReleaseYear() + seperator + each.getGenre() + seperator + each.getArtist()+ seperator + each.get1Configs() + seperator + each.get2Configs() + seperator + each.get3Configs() + System.lineSeparator());
        }
        writer.close();


    }
//method to load media into listview from a selected file
    public void loadMedia(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Records");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File file = fileChooser.showOpenDialog(null);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            String[] parts = line.split("}");
            String format  = parts [0];
            if (format.equals("record")){
                String name  = parts[1];
                String condition = (parts[2]);
                String label = parts [3];
                String catNumber = parts[4];
                int releaseYear = Integer.parseInt(parts[5]);
                String genre = parts[6];
                String artist = parts[7];
                int speed = Integer.parseInt(parts[8]);
                int size = Integer.parseInt(parts[9]);
                String colour = parts [10];
                Record temp = new Record(name, condition, label, catNumber, releaseYear, genre, artist, format, speed, size, colour);
                mediaList.getItems().add(temp);

            }
            else if (format.equals("cassette")){
                String name  = parts[1];
                String condition = parts[2];
                String label = parts [3];
                String catNumber = parts[4];
                int releaseYear = Integer.parseInt(parts[5]);
                String genre = parts[6];
                String artist = parts[7];
                String length = parts[8];
                String tapeType = parts [9];
                String colour = parts [10];
                Cassette temp = new Cassette(name, condition, label, catNumber, releaseYear, genre, artist, format, length, tapeType, colour);
                mediaList.getItems().add(temp);


            }
            else if (format.equals("CD")){
                String name  = parts[1];
                String condition = parts[2];
                String label = parts [3];
                String catNumber = parts[4];
                int releaseYear = Integer.parseInt(parts[5]);
                String genre = parts[6];
                String artist = parts[7];
                String length = parts[8];
                String bitRate = parts[9];
                String colour = parts [10];
                CompactDisk temp = new CompactDisk(name, condition, label, catNumber, releaseYear, genre, artist, format, length, bitRate, colour);
                mediaList.getItems().add(temp);


            }

        }
    }
}


