package Menu;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import Calculations.*;

public class RankPageController implements Initializable
{
    @FXML public Button Back;

    @FXML public TableView<Data> easy;
    @FXML public TableColumn<Data, String> easy_rank;
    @FXML public TableColumn<Data, Integer> easy_score;

    @FXML public TableView<Data> normal;
    @FXML public TableColumn<Data, String> normal_rank;
    @FXML public TableColumn<Data, String> normal_score;

    @FXML public TableView<Data> hard;
    @FXML public TableColumn<Data, String> hard_rank;
    @FXML public TableColumn<Data, Integer> hard_score;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        easy_rank.setCellValueFactory(new PropertyValueFactory<Data, String>("Rank"));
        easy_score.setCellValueFactory(new PropertyValueFactory<Data, Integer>("Score"));

        normal_rank.setCellValueFactory(new PropertyValueFactory<Data, String>("rank"));
        normal_score.setCellValueFactory(new PropertyValueFactory<Data, String>("score"));

        hard_rank.setCellValueFactory(new PropertyValueFactory<Data, String>("Rank"));
        hard_score.setCellValueFactory(new PropertyValueFactory<Data, Integer>("Score"));

        ArrayList<Integer> easyList = null;
        ArrayList<Integer> normalList = null;
        ArrayList<Integer> hardList = null;

        try
        {
            easyList = Rank.GetRank("./src/Rank/easyRank.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            normalList = Rank.GetRank("./src/Rank/normalRank.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            hardList = Rank.GetRank("./src/Rank/hardRank.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        ObservableList<Data> ez = setColContent(easyList);
        easy.setItems(ez);

        ObservableList<Data> nor = setColContent(normalList);
        normal.setItems(nor);

        ObservableList<Data> hd = setColContent(hardList);
        hard.setItems(hd);
    }

    private ObservableList<Data> setColContent(ArrayList<Integer> rank)
    {
        ObservableList<Data> list = FXCollections.observableArrayList();

        int counter = 0;
        while (counter < rank.size() && counter < 5)
        {
            if (counter == 0)
            {
                list.add(new Data("1ST", rank.get(counter)));
            } else if (counter == 1)
            {
                list.add(new Data("2ND", rank.get(counter)));
            } else if (counter == 2)
            {
                list.add(new Data("3RD", rank.get(counter)));
            } else
            {
                list.add(new Data((counter+1) + "TH", rank.get(counter)));
            }
            counter++;
        }
        return list;
    }

    public void backToMenu() throws IOException
    {
        Stage Stage = (Stage) Back.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }
}
