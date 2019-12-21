package Game;

import Calculations.Rank;
import Calculations.Show;
import Menu.GameWinController;
import Menu.TwoPWinController;
import Movement.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Describe the process of game and control its start and end
 *
 * Constructor takes string mode to determine which mode to execute
 * Making use of singleton pattern to ensure the only access in one round
 *
 * @author scyyc1@nottingham.ac.uk
 */

public class Process
{
    private static Process process = new Process();

    public static Process getProcess() { return process;}

    private static MyStage background;
    private static Animal animal1;
    private static Animal animal2;
    private static AnimationTimer timer;
    private static String mode;

//    public Process(MyStage background, Animal animal, AnimationTimer timer, String mode)
//    {
//        this.background = background;
//        this.animal = animal;
//        this.timer = timer;
//        this.mode = mode;
//    }

    /**
     * Constructor that avoid Process being initialized
     */
    private Process() {}

    public void setProcess(MyStage background, Animal animal1, Animal animal2, AnimationTimer timer, String mode)
    {
        this.background = background;
        this.animal1 = animal1;
        this.animal2 = animal2;
        this.timer = timer;
        this.mode = mode;
    }

    /**
     * Create the timer for the game and control when the player win the game or lose
     */
    public static void createTimer() {
        if(mode.equalsIgnoreCase("2P"))
        {
            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (animal2.changeLife())
                    {
                        Show.setLifePTwo(animal2.getLife(), background);
                    }
                    if (animal1.changeLife())
                    {
                        Show.setLifePOne(animal1.getLife(), background);
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
                            loader = new FXMLLoader(getClass().getResource("/View/TwoPWin.fxml"));
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
        else
        {
            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (animal1.changeLife())
                    {
                        Show.setLife(animal1.getLife(), background);
                    }
                    if (animal1.changeScore())
                    {
                        Show.setScore(animal1.getPoints(), background);
                    }
                    if (animal1.getStop())
                    {
                        background.stopMusic();
                        stop();
                        background.stop();
                        int score = animal1.getPoints();
                        Rank rank = new Rank();
                        try
                        {
                            if(mode == "easy")
                            {
                                rank.AddToRank(score, "./src/Rank/easyRank.txt");
                            }
                            else if(mode == "normal")
                            {
                                rank.AddToRank(score, "./src/Rank/normalRank.txt");
                            }
                            else if(mode == "hard")
                            {
                                rank.AddToRank(score, "./src/Rank/hardRank.txt");
                            }
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                        Parent root = null;

                        int life = animal1.getLife();

                        if(life != 0)
                        {
                            FXMLLoader loader = null;
                            try
                            {
                                loader = new FXMLLoader(getClass().getResource("/View/GameWin.fxml"));
                                root = loader.load();
                            } catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            GameWinController win = loader.getController();
                            win.setScore(animal1.getPoints());
                        }
                        else
                        {
                            FXMLLoader loader = null;
                            try
                            {
                                loader = new FXMLLoader(getClass().getResource("/View/GameOver.fxml"));
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

    }

    /**
     * Start the game process
     */
    public static void start()
    {
        background.playMusic();
        createTimer();
        timer.start();
    }

    /**
     * Stop when necessary
     */
    public static void stop()
    {
        timer.stop();
    }

    public void setLifePTwo(int n)
    {
        background.add(new Digit(n, 20, 557, 25));
    }
}
