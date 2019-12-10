package Calculations;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data
{
    private final StringProperty rank;
    private final StringProperty score;

    public Data(String rank, int score)
    {
        String s = String.valueOf(score);
        this.rank = new SimpleStringProperty(rank);
        this.score = new SimpleStringProperty(s);
    }

    public final String getRank()
    {
        return rank.get();
    }

    public final StringProperty rankProperty()
    {
        return rank;
    }

    public final StringProperty scoreProperty()
    {
        return score;
    }

    public int getScore()
    {
        int temp = Integer.valueOf(score.get());
        return temp;
    }


}
