package Calculations;

import Movement.Digit;
import Movement.MyStage;

/**
 * This class contain the method to display gaming information on screen
 */
public class Show
{
    /**
     * Display the score on screen
     * @param n score
     * @param background The scene to display {@link Movement.Animal}
     */
    public static void setScore(int n, MyStage background)
    {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 530 - shift, 25));
            shift+=30;
        }
    }

    /**
     * Display the remained life of the animal
     * @param n the remained life
     * @param background The scene to display {@link Movement.Animal}
     */
    public static void setLife(int n, MyStage background)
    {
        background.add(new Digit(n, 30, 560, 50));
    }
}
