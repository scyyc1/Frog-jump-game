//package Game;
//
//import Menu.Process;
//import Movement.*;
//import javafx.animation.AnimationTimer;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class EasySetting
//{
//    AnimationTimer timer;
//    MyStage background;
//    Animal animal;
//
//    public static MyStage setEasy()
//    {
//        Stage stage = new Stage();
//        stage.setWidth(600);
//        stage.setHeight(800);
//        stage.setResizable(false);
//        MyStage background = new MyStage();
//
//        BackgroundImage froggerback = new BackgroundImage("file:src/Image/Background/Background.png");
//        background.add(froggerback);
//
//        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 164, 0.75));
//        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 220, 164, 0.75));
//        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 440, 164, 0.75));
//        background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 164, 0.75));
//
//        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 400, 285, -2));
//        background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 800, 285, -2));
//
//        background.add(new Turtle(500, 338, -1, 130, 130));
//        background.add(new Turtle(300, 338, -1, 130, 130));
//        background.add(new Turtle(700, 338, -1, 130, 130));
//        background.add(new Turtle(600, 218, -1, 130, 130));
//        background.add(new Turtle(400, 218, -1, 130, 130));
//        background.add(new Turtle(200, 218, -1, 130, 130));
//
//        End e1 = new End(13,96);
//        End e2 = new End(141,96);
//        End e3 = new End(269, 96);
//        End e4 = new End(398,96);
//        End e5 = new End(528,96);
//
//        e1.setVisible(false);
//        e2.setVisible(false);
//        e3.setVisible(false);
//        e4.setVisible(false);
//        e5.setVisible(false);
//
//        background.add(e1);
//        background.add(e2);
//        background.add(e3);
//        background.add(e4);
//        background.add(e5);
//
//        Animal animal = new Animal("file:src/Image/Frogger/froggerUp.png", 30);
//        background.add(animal);
//        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 0, 643, 1, 120, 120));
//        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 300, 643, 1, 120, 120));
//        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 600, 643, 1, 120, 120));
//        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 720, 643, 1, 120, 120));
//
//        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 100, 586, -1, 50, 50));
//        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 250, 586, -1, 50, 50));
//        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 400, 586, -1, 50, 50));
//
//        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 0, 534, 1, 200, 200));
//        background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 500, 534, 1, 200, 200));
//
//        background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 500, 464, -4, 50, 50));
//        background.start();
//
//        Scene scene = new Scene(background, 600,800);
//        stage.setScene(scene);
//        stage.show();
//
//        Process process = new Process(background, animal, timer);
//        process.start("easy");
//    }
//
//}
