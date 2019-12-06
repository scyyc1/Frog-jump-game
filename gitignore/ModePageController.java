package Menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import Game.*;

public class ModePageController
{
    @FXML
    public Button Easy;

    @FXML
    public Button Normal;

    @FXML
    public Button Hard;

    @FXML
    public Button Back;

    public void NormalMode() throws Exception
    {
        Stage stage = (Stage) Normal.getScene().getWindow();
        stage.close();
        Normal n = new Normal();
        n.NormalMode();
    }

    public void backToMenu() throws IOException
    {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }
}
