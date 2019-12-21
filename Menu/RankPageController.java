package Menu;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import Calculations.*;

/**
 * Controller of rank page
 * Provide the rank of each mode
 *
 * @author scyyc1@nottingham.ac.uk
 */
public class RankPageController implements Initializable
{
    @FXML public Button Back;

    @FXML public TableView<Data> easy;
    @FXML public TableColumn<Data, String> easy_rank;
    @FXML public TableColumn<Data, Integer> easy_score;
    @FXML public TableColumn<Data, String> easy_name;

    @FXML public TableView<Data> normal;
    @FXML public TableColumn<Data, String> normal_rank;
    @FXML public TableColumn<Data, String> normal_score;
    @FXML public TableColumn<Data, String> normal_name;

    @FXML public TableView<Data> hard;
    @FXML public TableColumn<Data, String> hard_rank;
    @FXML public TableColumn<Data, Integer> hard_score;
    @FXML public TableColumn<Data, String> hard_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        easy_rank.setCellValueFactory(new PropertyValueFactory<Data, String>("rank"));
        easy_score.setCellValueFactory(new PropertyValueFactory<Data, Integer>("score"));
        easy_name.setCellValueFactory(new PropertyValueFactory<Data, String>("name"));

        normal_rank.setCellValueFactory(new PropertyValueFactory<Data, String>("rank"));
        normal_score.setCellValueFactory(new PropertyValueFactory<Data, String>("score"));
        normal_name.setCellValueFactory(new PropertyValueFactory<Data, String>("name"));

        hard_rank.setCellValueFactory(new PropertyValueFactory<Data, String>("rank"));
        hard_score.setCellValueFactory(new PropertyValueFactory<Data, Integer>("score"));
        hard_name.setCellValueFactory(new PropertyValueFactory<Data, String>("name"));

        ArrayList<Integer> easyList = null;
        ArrayList<Integer> normalList = null;
        ArrayList<Integer> hardList = null;

        ArrayList<String> easyName = null;
        ArrayList<String> normalName = null;
        ArrayList<String> hardName = null;

        Rank es= new Rank();
        try
        {
            es.UpdateRank("./src/Rank/easyRank.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        easyList = es.getList();
        easyName = es.getNameList();

        Rank n = new Rank();
        try
        {
            n.UpdateRank("./src/Rank/normalRank.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        normalList = n.getList();
        normalName = n.getNameList();

        Rank h = new Rank();
        try
        {
            h.UpdateRank("./src/Rank/hardRank.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        hardList = h.getList();
        hardName = h.getNameList();

        ObservableList<Data> ez = setColContent(easyList, easyName);
        easy.setItems(ez);

        ObservableList<Data> nor = setColContent(normalList, normalName);
        normal.setItems(nor);

        ObservableList<Data> hd = setColContent(hardList, hardName);
        hard.setItems(hd);
    }

    private ObservableList<Data> setColContent(ArrayList<Integer> rank, ArrayList<String> name)
    {
        ObservableList<Data> list = FXCollections.observableArrayList();

        int counter = 0;
        while (counter < rank.size() && counter < 5)
        {
            if (counter == 0)
            {
                list.add(new Data("1ST", rank.get(counter), name.get(counter)));
            } else if (counter == 1)
            {
                list.add(new Data("2ND", rank.get(counter), name.get(counter)));
            } else if (counter == 2)
            {
                list.add(new Data("3RD", rank.get(counter), name.get(counter)));
            } else
            {
                list.add(new Data((counter+1) + "TH", rank.get(counter), name.get(counter)));
            }
            counter++;
        }
        return list;
    }

    public void backToMenu() throws IOException
    {
        Stage Stage = (Stage) Back.getScene().getWindow();
        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/menu.fxml"));
        Scene s = new Scene(root);
        Stage.setScene(s);
        Stage.show();
    }
}
