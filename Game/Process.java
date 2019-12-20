package Game;

import Calculations.Rank;
import Calculations.Show;
import Menu.GameWinController;
import Movement.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Describe the process of game and control its start and end
 */
public class Process
{
    private MyStage background;
    private Animal animal;
    private AnimationTimer timer;
    private String mode;

    public Process(MyStage background, Animal animal, AnimationTimer timer)
    {
        this.background = background;
        this.animal = animal;
        this.timer = timer;
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeLife())
                {
                    Show.setLife(animal.getLife(), background);
                }
                if (animal.changeScore())
                {
                    Show.setScore(animal.getPoints(), background);
                }
                if (animal.getStop())
                {
                    background.stopMusic();
                    stop();
                    background.stop();
                    int score = animal.getPoints();
                    try
                    {
                        if(mode == "easy")
                        {
                            Rank.AddToRank(score, "./src/Rank/easyRank.txt");
                        }
                        else if(mode == "normal")
                        {
                            Rank.AddToRank(score, "./src/Rank/normalRank.txt");
                        }
                        else if(mode == "hard")
                        {
                            Rank.AddToRank(score, "./src/Rank/hardRank.txt");
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    try
                    {
                        if(mode == "easy")
                        {
                            Rank.GetRank("./src/Rank/easyRank.txt");
                        }
                        else if(mode == "normal")
                        {
                            Rank.GetRank("./src/Rank/normalRank.txt");
                        }
                        else
                        {
                            Rank.GetRank("./src/Rank/hardRank.txt");
                        }
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    Parent root = null;

                    int life = animal.getLife();

                    if(life != 0)
                    {
                        FXMLLoader loader = null;
                        try
                        {
                            loader = new FXMLLoader(getClass().getResource("GameWin.fxml"));
                            root = loader.load();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        GameWinController win = loader.getController();
                        win.setScore(animal.getPoints());
                    }
                    else
                    {
                        FXMLLoader loader = null;
                        try
                        {
                            loader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
                            root = loader.load();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }

                    Stage stage = (Stage) background.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        };
    }

    /**
     * Start the game process
     *
     * @param mode justify which mode to start
     */
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
}
