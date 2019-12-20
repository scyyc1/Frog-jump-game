package Calculations;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The defined data type for rank function to store the rank permanent rank
 *
 * @author scyyc1@nottingham.ac.uk
 */
public class Data
{
    private final StringProperty rank;
    private final StringProperty score;
    private final StringProperty name;

    public Data(String rank, int score, String name)
    {
        String s = String.valueOf(score);
        this.rank = new SimpleStringProperty(rank);
        this.score = new SimpleStringProperty(s);
        this.name = new SimpleStringProperty(name);
    }

    public final String getRank()
    {
        return rank.get();
    }

    public final StringProperty rankProperty() { return rank; }

    public final StringProperty scoreProperty()
    {
        return score;
    }

    public final StringProperty nameProperty()
    {
        return name;
    }

    /**
     * The method to transform the score from string to in
     * As the score stored in rank file is string
     * @return the score in the data structure
     */
    public int getScore()
    {
        int temp = Integer.valueOf(score.get());
        return temp;
    }


}
