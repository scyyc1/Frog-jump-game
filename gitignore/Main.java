package Menu;

import Game.Process;
import Movement.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		background = new MyStage();
		Scene scene  = new Scene(background,600,800);



        Parent menu = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Scene main_menu = new Scene(menu);

		// Set the style of cursor
		String c = "file:src/Image/Frogger/froggerUpJump-red.png";
		main_menu.setCursor(Cursor.cursor(c));

        primaryStage.setScene(main_menu);
        primaryStage.show();

		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);

		BackgroundImage froggerback = new BackgroundImage("file:src/Image/Background/FrogBackground.png");

		background.add(froggerback);

//		background.add(new )

		background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/Image/Obstacles/Logs/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/Image/Obstacles/Logs/log3.png", 150, 490, 329, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));

		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:src/Image/Frogger/froggerUp.png", 26.66666666666, 5);
		background.add(animal);
		background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/Image/Obstacles/Trucks/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/Image/Obstacles/Cars/car1Left.png", 500, 490, -5, 50, 50));
		background.add(new Digit(0, 30, 360, 25));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);


		background.start();
//		primaryStage.setScene(scene);
//		primaryStage.show();

		Process process = new Process(background, animal, timer);
		process.start();
	}
}
