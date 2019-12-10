package Game;

import Calculations.Rank;
import Movement.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;

import java.io.IOException;

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
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop())
                {
                    System.out.print("STOPP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    int score = animal.getPoints();
                    alert.setHeaderText("Your High Score: "+score+"!");
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
                        else
                        {
                            Rank.AddToRank(score, "./src/Rank/hardRank.txt");
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    alert.setContentText("Highest Possible Score: 800");
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
                    alert.show();
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
}
