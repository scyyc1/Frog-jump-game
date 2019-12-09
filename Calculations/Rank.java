package Calculations;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Rank
{
//    public static void EnterScore(int score) throws IOException {
//
//        String path = "/Menu/";
//        File file = new File(path);
//
//        String fileName = "Rank.txt";
//        File filename = new File(path + fileName);
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        AddToRank(score, filename);
//    }

    public static void AddToRank(int score) throws IOException
    {
        File file = new File("./src/Rank/Rank.txt");

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

    public static void DispalyRank() throws IOException
    {
        File file = new File("./src/Rank/Rank.txt");

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

        for (Integer s : list)
        {
            System.out.println(s.intValue());
        }

    }

    private static ArrayList<Integer> bubbleSort(ArrayList<Integer> list)
    {
        int temp;
        for (int i = list.size() - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if(list.get(j).compareTo(list.get(j+1)) > 0){
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }// end inner loop
        }//end outer loop
        return list;
    }// end bubble sort
}