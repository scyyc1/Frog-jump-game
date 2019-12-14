package Menu;

import Movement.*;
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

        BackgroundImage froggerback = new BackgroundImage("file:src/Image/Background/Background.png");
        background.add(froggerback);

        background.add(new Image("file:src/Image/Icons/Life.png", 20, 520, 50));

        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 172, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 220, 172, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 440, 172, 0.75));

        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 0, 269, -2));
        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 400, 269, -2));

        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 50, 317, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 270, 317, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 490, 317, 0.75));

        background.add(new Turtle(500, 359, -1, 130, 130));
        background.add(new Turtle(300, 359, -1, 130, 130));
        background.add(new WetTurtle(700, 359, -1, 130, 130));
        background.add(new WetTurtle(600, 214, -1, 130, 130));
        background.add(new WetTurtle(400, 214, -1, 130, 130));
        background.add(new WetTurtle(200, 214, -1, 130, 130));

        End e1 = new End(13,96);
        End e2 = new End(141,96);
        End e3 = new End(269, 96);
        End e4 = new End(398,96);
        End e5 = new End(528,96);

        e1.setVisible(false);
        e2.setVisible(false);
        e3.setVisible(false);
        e4.setVisible(false);
        e5.setVisible(false);

        background.add(e1);
        background.add(e2);
        background.add(e3);
        background.add(e4);
        background.add(e5);

        Animal animal = new Animal(24.2424242, 1);
        background.add(animal);

        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 0, 655, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 300, 655, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 600, 655, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 720, 655, 1, 120, 120));

        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 100, 609, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 250, 609, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 400, 609, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 550, 609, -1, 50, 50));

        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 0, 558, 1, 200, 200));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 500, 558, 1, 200, 200));

        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 450, 512, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 200, 512, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 600, 512, -1, 50, 50));

        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 500, 455, -5, 50, 50));

        background.start();
        Scene scene = new Scene(background, 600,800);
        stage.setScene(scene);
        stage.show();

        Process process = new Process(background, animal, timer);
        process.start("normal");
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

        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 164, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 220, 164, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 440, 164, 0.75));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 164, 0.75));

        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 400, 285, -2));
        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 800, 285, -2));

        background.add(new Turtle(500, 338, -1, 130, 130));
        background.add(new Turtle(300, 338, -1, 130, 130));
        background.add(new Turtle(700, 338, -1, 130, 130));
        background.add(new Turtle(600, 218, -1, 130, 130));
        background.add(new Turtle(400, 218, -1, 130, 130));
        background.add(new Turtle(200, 218, -1, 130, 130));

        End e1 = new End(13,96);
        End e2 = new End(141,96);
        End e3 = new End(269, 96);
        End e4 = new End(398,96);
        End e5 = new End(528,96);

        e1.setVisible(false);
        e2.setVisible(false);
        e3.setVisible(false);
        e4.setVisible(false);
        e5.setVisible(false);

        background.add(e1);
        background.add(e2);
        background.add(e3);
        background.add(e4);
        background.add(e5);

        Animal animal = new Animal(30, 1);
        background.add(animal);
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 0, 643, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 300, 643, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 600, 643, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 720, 643, 1, 120, 120));

        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 100, 586, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 250, 586, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 400, 586, -1, 50, 50));

        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 0, 534, 1, 200, 200));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 500, 534, 1, 200, 200));

        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 500, 464, -4, 50, 50));
        background.start();

        Scene scene = new Scene(background, 600,800);
        stage.setScene(scene);
        stage.show();

        Process process = new Process(background, animal, timer);
        process.start("easy");
    }

    public void HardMode() throws Exception
    {
        Stage stage = (Stage) Normal.getScene().getWindow();
        stage.setWidth(600);
        stage.setHeight(800);
        stage.setResizable(false);

        MyStage background = new MyStage();

        BackgroundImage froggerback = new BackgroundImage("file:src/Image/Background/Backgroundchanged.png");
        background.add(froggerback);

        background.add(new Image("file:src/Image/Icons/Life.png", 20, 520, 50));

        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 172, 1.5));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 220, 172, 1.5));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 440, 172, 1.5));

        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 0, 269, -4));
        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 400, 269, -4));

        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 50, 317, 1.5));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 270, 317, 1.5));
        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 490, 317, 1.5));

        background.add(new WetTurtle(500, 359, -1, 130, 130));
        background.add(new WetTurtle(300, 359, -1, 130, 130));
        background.add(new WetTurtle(700, 359, -1, 130, 130));
        background.add(new WetTurtle(600, 214, -1, 130, 130));
        background.add(new WetTurtle(400, 214, -1, 130, 130));
        background.add(new WetTurtle(200, 214, -1, 130, 130));

        End e1 = new End(13,96);
        End e2 = new End(141,96);
        End e3 = new End(269, 96);
        End e4 = new End(398,96);
        End e5 = new End(528,96);

        e1.setVisible(false);
        e2.setVisible(false);
        e3.setVisible(false);
        e4.setVisible(false);
        e5.setVisible(false);

        background.add(e1);
        background.add(e2);
        background.add(e3);
        background.add(e4);
        background.add(e5);

        Animal animal = new Animal(24.2424242, 1);
        background.add(animal);

        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 0, 655, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 300, 655, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 600, 655, 1, 120, 120));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 720, 655, 1, 120, 120));

        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 100, 609, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 250, 609, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 400, 609, -1, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 550, 609, -1, 50, 50));

        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 0, 558, 1, 200, 200));
        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 500, 558, 1, 200, 200));

        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 450, 512, -3, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 200, 512, -3, 50, 50));
        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 600, 512, -3, 50, 50));

        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 500, 455, -10, 50, 50));

        background.start();
        Scene scene = new Scene(background, 600,800);
        stage.setScene(scene);
        stage.show();

        Process process = new Process(background, animal, timer);
        process.start("hard");
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
