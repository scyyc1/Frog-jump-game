package Game;

import Calculations.Rank;
import Menu.TwoPWinController;
import Movement.Animal;
import Movement.Digit;
import Movement.MyStage;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class TwoPProcess
{
    private MyStage background;
    private Animal animal1;
    private Animal animal2;
    private AnimationTimer timer;
    private String mode;

    public TwoPProcess(MyStage background, Animal animal1, Animal animal2, AnimationTimer timer)
    {
        this.background = background;
        this.animal1 = animal1;
        this.timer = timer;
        this.animal2 = animal2;
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal2.changeLife())
                {
                    setLifePTwo(animal2.getLife());
                }
                if (animal1.changeLife())
                {
                    setLife(animal1.getLife());
                }
                if (animal1.getEnd() == 3 || animal2.getEnd() == 3 || animal1.getLife() == 0 || animal2.getLife() == 0)
                {
                    background.stopMusic();
                    stop();
                    background.stop();

                    Parent root = null;

                    int life = animal1.getLife();

                    FXMLLoader loader = null;
                    try
                    {
                        loader = new FXMLLoader(getClass().getResource("/Menu/TwoPWin.fxml"));
                        root = loader.load();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    TwoPWinController win = loader.getController();

                    if(animal1.getEnd() == 3 || animal2.getLife() == 0)
                    {
                        win.setWinner("Player 1");
                    }
                    else
                    {
                        win.setWinner("Player 2");
                    }


                    Stage stage = (Stage) background.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        };
    }
    // Start the game
    public void start(String mode)
    {
        this.mode = mode;
        background.playMusic();
        createTimer();
        timer.start();
    }

    public void stop()
    {
        timer.stop();
    }

    public void setNumber(int n)
    {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 560 - shift, 10));
            shift+=30;
        }
    }

    public void setLife(int n)
    {
        background.add(new Digit(n, 20, 557, 52));
    }

    public void setLifePTwo(int n)
    {
        background.add(new Digit(n, 20, 557, 25));
    }
}
