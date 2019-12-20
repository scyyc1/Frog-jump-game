package Calculations;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rank class makes use of {@link Data} type to store the rank data
 * @author scyyc1@nottingham.ac.uk
 */
public class Rank
{
    /**
     *The function takes the score calculated from the game {@link Movement.Animal}
     * and add the score to the file {@link Process}. Each line represent a score
     * @param score The score recorded in game
     * @param path The corresponding file to store
     * @throws IOException
     */
    public static void AddToRank(int score, String path) throws IOException
    {
        File file = new File(path);

        // Check if the rank file doesn't exist, create one
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        // Write to the end of the rank file
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bufw = new BufferedWriter(fw);

        try
        {
            String temp = String.valueOf(score);
            bufw.write(temp);
            bufw.newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bufw != null)
            {
                try
                {
                    bufw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (fw != null)
            {
                try
                {
                    fw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Get the rank information in the files and display in {@link Menu.RankPageController}
     * @param path The path to corresponding mode of rank
     * @return  The rank to display in {@link Menu.RankPageController}
     * @throws IOException
     */
    public static ArrayList<Integer> GetRank(String path) throws IOException
    {
        File file = new File(path);
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        try
        {
            if (file.isFile() && file.exists())
            {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);

                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    int temp = Integer.parseInt(lineTxt);
                    list.add(temp);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Can't find the rank!");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }

        ArrayList<Integer> SortList = bubbleSort(list);

        return SortList;
    }

    /**
     * Rearrange the rank in descending order
     * @param list The list to rearrange
     * @return The rearranged list
     */
    private static ArrayList<Integer> bubbleSort(ArrayList<Integer> list)
    {
        int temp;
        for (int i = list.size() - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if(list.get(j).compareTo(list.get(j+1)) < 0){
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return list;
    }
}