package sample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Observable;

public class Controller {
    public TextField textName;
    public TextField textAge;
    public TextField textOccupation;
    public TextField textLocation;
    public Button addFriendButton;
    public ListView<Friend> friendList = new ListView<>();
    public Label labelName;
    public Label labelAge;
    public Label labelOccupation;
    public Label labelLocation;
    public Button deleteButton;
    public Button selectFileButton;
    public Button newFileSaveButton;

    // adds new friend to friends list from input on main screen
    public void addFriend(ActionEvent actionEvent){
        String name = textName.getText();
        int age = Integer.parseInt(textAge.getText());
        String occupation = textOccupation.getText();
        String location = textLocation.getText();
        Friend temp = new Friend(name, age, occupation, location);
        friendList.getItems().add(temp);
        textName.clear();
        textAge.clear();
        textLocation.clear();
        textOccupation.clear();
    }
// displays a friend's info when they are selected in the list view
    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        labelName.setText(temp.getName());
        labelAge.setText(Integer.toString(temp.getAge()));
        labelOccupation.setText(temp.getOccupation());
        labelLocation.setText(temp.getLocation());
    }
// removes a friend from the friends list, and resets the info displayed.
    public void deleteFriend(ActionEvent actionEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(temp);
        labelName.setText("");
        labelAge.setText("");
        labelOccupation.setText("");
        labelLocation.setText("");
    }

    public void selectFile(ActionEvent actionEvent) throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Friend File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File file = fileChooser.showOpenDialog(null);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            String[] parts = line.split("}");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            String occupation = parts[2];
            String location = parts[3];
            Friend temp = new Friend(name, age, occupation, location );
            friendList.getItems().add(temp);
            //System.out.println(temp.toString());
        }


        //Friend temp = new Friend();

    }

    public void newFileSave(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Friends");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(null);
        ObservableList<Friend>friends;
        friends = friendList.getItems();
        String separator = "}";
        BufferedWriter writer= new BufferedWriter(new FileWriter(file));
        for (Friend each: friends){
            writer.write(each.getName() + separator + each.getAge() + separator + each.getOccupation() + separator + each.getLocation() + System.lineSeparator());

        }
        writer.close();

    }
}
