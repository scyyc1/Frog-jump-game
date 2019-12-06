package Menu;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController
{
    @FXML
    public Button mode;

    @FXML
    public Button rank;

    @FXML
    public Button setting;

    @FXML
    public Button exit;

    public void ExitGame()
    {
        System.out.println("Bye!");
        System.exit(0);
    }

    public void chooseMode() throws IOException
    {
        Stage Stage = (Stage) mode.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("ModePage.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }

    public void chooseSettings() throws IOException
    {
        Stage Stage = (Stage) setting.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("SettingPage.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }

    public void seeRanking() throws IOException
    {
        Stage Stage = (Stage) rank.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("RankPage.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }
}
