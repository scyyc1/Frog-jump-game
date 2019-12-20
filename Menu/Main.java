package Menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("Name.fxml"));
        Scene main_menu = new Scene(menu);

		// Set the style of cursor
		String c = "file:src/Image/Frogger/froggerUpJump-red.png";
		main_menu.setCursor(Cursor.cursor(c));

        primaryStage.setScene(main_menu);
        primaryStage.show();
	}
}
