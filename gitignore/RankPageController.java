package Menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RankPageController
{
    @FXML
    public Button Back;

    public void backToMenu() throws IOException
    {
        Stage Stage = (Stage) Back.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }
}
