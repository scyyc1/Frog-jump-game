package Calculations;

import Menu.NameController;
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
    ArrayList<Integer> list = null;
    ArrayList<String> nameList = null;

    public Rank()
    {
        list = new ArrayList<Integer>();
        nameList = new ArrayList<String>();
    }

    /**
     *The function takes the score calculated from the game {@link Movement.Animal}
     * and add the score to the file (controlled by {@link Process}). Each line represent a score
     * @param score The score recorded in game
     * @param path The corresponding file to store
     * @throws IOException if fail to open file or fail to create or write the file
     */
    public void AddToRank(int score, String path) throws IOException
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

        UpdateRank(path);
        list.add(score);
        nameList.add(NameController.getName());
        bubbleSort();

        // Write to the end of the rank file
        FileWriter fw = new FileWriter(file,false);
        BufferedWriter bufw = new BufferedWriter(fw);
        bufw.write("");

        for(int i = 0; (i<list.size() && i<5); i++)
        {
            try
            {
                fw = new FileWriter(file,true);
                bufw = new BufferedWriter(fw);
                String temp = String.valueOf(list.get(i));
                bufw.write(temp);
                bufw.newLine();
                bufw.write(nameList.get(i));
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
    }

    /**
     * Get the rank information in the files and display in {@link Menu.RankPageController}
     * @param path The path to corresponding mode of rank
     * @return  The rank to display in {@link Menu.RankPageController}
     * @throws IOException if fail to open file or create the file
     */
    public void UpdateRank(String path) throws IOException
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

        try
        {
            if (file.isFile() && file.exists())
            {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);

                String lineTxt = null;

                int counter = 0;
                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    counter++;
                    if(counter % 2 != 0)
                    {
                       int temp = Integer.parseInt(lineTxt);
                       list.add(temp);
                    }
                    else
                    {
                        nameList.add(lineTxt);
                    }
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Can't find the rank!");
                alert.show();
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getList()
    {
        return list;
    }

    public ArrayList<String> getNameList()
    {
        return nameList;
    }

    public void setList(ArrayList<Integer> list)
    {
        this.list = list;
    }

    public void setNameList(ArrayList<String> nameList)
    {
        this.nameList = nameList;
    }

    /**
     * Rearrange the rank in descending order
     * @return The rearranged list
     */
    public void bubbleSort()
    {
        int temp;
        String tempName;
        for (int i = list.size() - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if(list.get(j).compareTo(list.get(j+1)) < 0)
                {
                    tempName = nameList.get(j);
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                    nameList.set(j, nameList.get(j+1));
                    nameList.set(j+1, tempName);
                }
            }
        }
    }
}