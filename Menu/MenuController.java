package Menu;

import java.io.IOException;

import Game.TwoPlayer;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller for main menu
 *
 * Provide entrances to other pages
 * {@link SettingPageController}{@link ModePageController}{@link RankPageController}{@link TwoPlayer}
 *
 * @author scyyc1@nottingham.ac.uk
 */
public class MenuController
{
    AnimationTimer timer;

    @FXML
    public Button TwoP;

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
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/ModePage.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }

    public void chooseSettings() throws IOException
    {
        Stage Stage = (Stage) setting.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/SettingPage.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }

    public void seeRanking() throws IOException
    {
        Stage Stage = (Stage) rank.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/RankPage.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }

    public void TwoPMode() throws Exception
    {
        Stage stage = (Stage) TwoP.getScene().getWindow();
        TwoPlayer tp = TwoPlayer.getTP();
        tp.start(stage);
    }
}
