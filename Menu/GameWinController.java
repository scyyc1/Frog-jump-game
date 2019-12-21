package Menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for page if the player pass the game
 *
 * @author scyyc1@nottingham.ac.uk
 */
public class GameWinController implements Initializable
{
    @FXML public Button Back;
    @FXML public Label score;

    public void backToMenu() throws IOException
    {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/menu.fxml"));
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

    public void setScore(int score)
    {
        this.score.setText(String.valueOf(score));
    }
}
