package Menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NameController
{
    String name;

    @FXML public TextField player;
    @FXML public Button submit;

    public void goToMenu() throws IOException
    {
        Stage stage = (Stage) submit.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }

    public String getName()
    {
        return name;
    }
}
