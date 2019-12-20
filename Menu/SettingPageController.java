package Menu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Setting page
 * Provide choice for player to adjust the life of each round of game
 *
 * @author scyyc1@nottingham.ac.uk
 */
public class SettingPageController implements Initializable
{
    private static String LifeNumber = "5";
    @FXML public Button Back;
    @FXML public ComboBox<String> life;
    @FXML public Label lifeNum;

    ObservableList<String> LifeChoice = FXCollections.observableArrayList("1", "2", "3", "4", "5");

    public void backToMenu() throws IOException
    {
        Stage Stage = (Stage) Back.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/menu.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        life.setItems(LifeChoice);
    }

    public void ChooseLife()
    {
        LifeNumber = life.getSelectionModel().getSelectedItem();
        lifeNum.setText(LifeNumber);
    }

    public static int getLife()
    {
        int i= Integer.parseInt(LifeNumber);
        return i;
    }
}
