package Test;

import Calculations.Rank;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the ranking whether the ranking algorithm is correct
 * {@link Rank}
 */
class RankTest
{
    /**
     * Test the whether the bubbleSort function can sort the rank list in descending order
     * {@link Rank}
     *
     * Input the score list and the name list
     * and give the correct sorted list to check whether it perform correct function
     */
    @Test
    public void bubbleSortTest()
    {
        // Test score list
        ArrayList<Integer> list = new ArrayList<Integer>()
        {
            {
                add(5);
                add(8);
                add(10);
                add(1);
                add(7);
            }
        };

        // Test name list
        ArrayList<String> nameList = new ArrayList<String>()
        {
            {
                add("one");
                add("two");
                add("three");
                add("four");
                add("five");
            }
        };

        // Correct score list
        ArrayList<Integer> listCorrect = new ArrayList<Integer>()
        {
            {
                add(10);
                add(8);
                add(7);
                add(5);
                add(1);
            }
        };

        // Correct name list
        ArrayList<String> nameListCorrect = new ArrayList<String>()
        {
            {
                add("three");
                add("two");
                add("five");
                add("one");
                add("four");
            }
        };

        Rank rank = new Rank();
        rank.setList(list);
        rank.setNameList(nameList);
        rank.bubbleSort();
        ArrayList<Integer> listSorted = rank.getList();
        ArrayList<String> nameSorted = rank.getNameList();

        // Check
        Assert.assertEquals(listCorrect, listSorted);
        Assert.assertEquals(nameListCorrect, nameSorted);
    }

    /**
     * Check whether only top 5 rank stored in the Rank
     */
    @Test
    public void checkFive() throws IOException
    {
        Rank easyRank = new Rank();
        easyRank.UpdateRank("./src/Rank/easyRank.txt");

        ArrayList<Integer> list = easyRank.getList();
        ArrayList<String> name = easyRank.getNameList();

        Assert.assertEquals(true, (list.size() <= 5));
        Assert.assertEquals(true, (name.size() <= 5));


        Rank normalRank = new Rank();
        normalRank.UpdateRank("./src/Rank/normalRank.txt");

        list = normalRank.getList();
        name = normalRank.getNameList();

        Assert.assertEquals(true, (list.size() <= 5));
        Assert.assertEquals(true, (name.size() <= 5));


        Rank hardRank = new Rank();
        normalRank.UpdateRank("./src/Rank/hardRank.txt");

        list = hardRank.getList();
        name = hardRank.getNameList();

        Assert.assertEquals(true, (list.size() <= 5));
        Assert.assertEquals(true, (name.size() <= 5));
    }


}