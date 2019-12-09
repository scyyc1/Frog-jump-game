package Menu;

import Game.Process;
import Movement.*;
import Game.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

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
        stage.setWidth(600);
        stage.setHeight(800);
        stage.setResizable(false);

        MyStage background = new MyStage();

        BackgroundImage froggerback = new BackgroundImage("file:src/Image/Background/FrogBackground.png");
        background.add(froggerback);

        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 166, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 220, 166, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 440, 166, 0.75));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 166, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 0, 276, -2));
        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 400, 276, -2));
        //background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 800, 276, -2));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 50, 329, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 270, 329, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 490, 329, 0.75));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 570, 329, 0.75));

        background.add(new Turtle(500, 376, -1, 130, 130));
        background.add(new Turtle(300, 376, -1, 130, 130));
        background.add(new WetTurtle(700, 376, -1, 130, 130));
        background.add(new WetTurtle(600, 217, -1, 130, 130));
        background.add(new WetTurtle(400, 217, -1, 130, 130));
        background.add(new WetTurtle(200, 217, -1, 130, 130));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 200, 100, 1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 0, 100, 1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 100, 120, -1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 200, 120, -1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 100, 140, 1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 200, 140, 1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 100, 160, -1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 300, 160, -1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 100, 180, 1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 200, 180, 1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 100, 200, -1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 200, 200, -1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 100, 220, 1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 200, 220, 1));
        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png", 400, 220, 1));
        //End end2 = new End();
        //End end3 = new End();
        //End end4 = new End();
        //End end5 = new End();
        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(141 + 141-13,96));
        background.add(new End(141 + 141-13+141-13+1,96));
        background.add(new End(141 + 141-13+141-13+141-13+3,96));
        Animal animal = new Animal("file:src/Image/Frogger/froggerUp.png", 26.66666666666, 5);
        background.add(animal);
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 0, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 300, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 600, 649, 1, 120, 120));
        //background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 720, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 100, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 250, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 400, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 550, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 0, 540, 1, 200, 200));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 500, 540, 1, 200, 200));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 500, 490, -5, 50, 50));
        background.add(new Digit(0, 30, 360, 25));
        background.start();
        //background.add(obstacle);
        //background.add(obstacle1);
        //background.add(obstacle2);
        Scene scene = new Scene(background, 600,800);
        stage.setScene(scene);
        stage.show();

        Process process = new Process(background, animal, timer);
        process.start();


//        Stage stage = (Stage) Normal.getScene().getWindow();
//        stage.setWidth(600);
//        stage.setHeight(800);
//        stage.setResizable(false);

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Game/NormalMode.fxml"));
//        AnchorPane root = loader.load();
//        GameController con = loader.getController();

//        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Game/NormalMode.fxml"));
//        Scene s = new Scene(root);
//        stage.setScene(s);

//        GameController normal = new GameController();
//        stage.setScene(new Scene(normal));

    }

    public void EasyMode() throws Exception
    {
        Stage stage = (Stage) Easy.getScene().getWindow();
        stage.setWidth(600);
        stage.setHeight(800);
        stage.setResizable(false);
        MyStage background = new MyStage();

        BackgroundImage froggerback = new BackgroundImage("file:src/Image/Background/Background.png");
        background.add(froggerback);

        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 171, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 220, 171, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 440, 171, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 171, 0.75));
//        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 0, 276, -2));
        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 400, 400, 324, -2));
        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 400, 800, 324, -2));
//        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 50, 329, 0.75));
//        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 270, 329, 0.75));
//        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 490, 329, 0.75));
//        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 570, 329, 0.75));
//
//        background.add(new Turtle(500, 376, -1, 130, 130));
//        background.add(new Turtle(300, 376, -1, 130, 130));
//        background.add(new WetTurtle(700, 376, -1, 130, 130));
        background.add(new WetTurtle(600, 241, -1, 130, 130));
        background.add(new WetTurtle(400, 241, -1, 130, 130));
        background.add(new WetTurtle(200, 241, -1, 130, 130));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 200, 100, 1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 0, 100, 1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 100, 120, -1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 200, 120, -1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 100, 140, 1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 200, 140, 1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 100, 160, -1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 300, 160, -1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 100, 180, 1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 200, 180, 1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 100, 200, -1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 200, 200, -1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 100, 220, 1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 200, 220, 1));
//        //background.add(new Log("file:src/Image/Obstacles/Logs/log2.png",150, 400, 220, 1));
//        //End end2 = new End();
//        //End end3 = new End();
//        //End end4 = new End();
//        //End end5 = new End();
        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(141 + 141-13,96));
        background.add(new End(141 + 141-13+141-13+1,96));
        background.add(new End(141 + 141-13+141-13+141-13+3,96));
        Animal animal = new Animal("file:src/Image/Frogger/froggerUp.png", 38.095238095238, 5);
        background.add(animal);
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 0, 629, 1, 150, 150));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 300, 629, 1, 150, 150));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 600, 629, 1, 150, 150));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 720, 629, 1, 150, 150));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 100, 554, -1, 80, 80));
//        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 250, 554, -1, 80, 80));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 400, 554, -1, 80, 80));
//        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 550, 554, -1, 80, 80));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 0, 476, 1, 250, 250));
//        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 500, 476, 1, 250, 250));
//        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 500, 490, -5, 50, 50));
        background.add(new Digit(0, 30, 360, 25));
        background.start();
        //background.add(obstacle);
        //background.add(obstacle1);
        //background.add(obstacle2);
        Scene scene = new Scene(background, 600,800);
        stage.setScene(scene);
        stage.show();


    }

    public void HardMode() throws Exception
    {
        Stage stage = (Stage) Hard.getScene().getWindow();
        stage.setWidth(600);
        stage.setHeight(800);
        stage.setResizable(false);
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Game/HardMode.fxml"));
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }

    public void backToMenu() throws IOException
    {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }
    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n)
    {
        int shift = 0;
        while (n > 0)
        {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 360 - shift, 25));
            shift += 30;
        }
    }
}
