package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
}
