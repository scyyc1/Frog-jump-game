package Menu;

import Movement.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import Game.*;

/**
 * Provide entrance to every mode of 1P game
 * {@link EasySetting}{@link NormalSetting}{@link HardSetting}
 *
 * @author scyyc1@nottingham.ac.uk
 */
public class ModePageController extends Pane
{
    AnimationTimer timer;
    MyStage background;
    Animal animal;

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
        setStage(stage);
        NormalSetting n = NormalSetting.getNormalSetting();
        n.start(stage);
    }

    public void EasyMode() throws Exception
    {
        Stage stage = (Stage) Easy.getScene().getWindow();
        setStage(stage);
        EasySetting e = EasySetting.getEasySetting();
        e.start(stage);
    }

    public void HardMode() throws Exception
    {
        Stage stage = (Stage) Normal.getScene().getWindow();
        setStage(stage);
        HardSetting h = HardSetting.getHardSetting();
        h.start(stage);
    }

    public void backToMenu() throws IOException
    {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/menu.fxml"));
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }

    private Stage setStage(Stage stage)
    {
        stage.setWidth(600);
        stage.setHeight(800);
        stage.setResizable(false);
        return stage;
    }
}
