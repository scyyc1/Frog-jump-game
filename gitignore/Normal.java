package Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Normal
{
    public void NormalMode() throws Exception
    {
        Stage stage = new Stage();
        stage.setWidth(600);
        stage.setHeight(800);
        stage.setResizable(false);
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("NormalMode.fxml"));
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }
}
