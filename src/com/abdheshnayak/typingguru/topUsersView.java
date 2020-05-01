package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.staticData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

import static com.abdheshnayak.typingguru.JavaClasses.SorterClass.*;

public class topUsersView {

    @FXML
    private Label headline;
    @FXML
    private TableColumn tName;
    @FXML
    private TableColumn tScore;
    @FXML
    private Button closebtn;
    @FXML
    private TableView<data> tableview;
    @FXML
    private ListView viewScores;
    @FXML
    private ListView viewUsers;
    public void initialize() throws IOException, ClassNotFoundException {
        tableview.setEditable(true);
        tName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tScore.setCellValueFactory(new PropertyValueFactory<>("score"));

        addUserClass user= new addUserClass();
        user.readUsers();


        Map<String, Integer> sortedMapAsc;
        if(staticData.order==1) {
            sortedMapAsc= sortByComparator(user.usrdata.Score, ASC);
        }
        else {
            sortedMapAsc = sortByComparator(user.usrdata.Score, DESC);
            headline.setText("Less Speed Users");
        }

        String[] keysName;
        keysName = sortedMapAsc.keySet().toArray(new String[0]);

        for ( String i:keysName){
//            System.out.println("hello");
//            System.out.println(i);
            tableview.getItems().add(new data(i,sortedMapAsc.get(i).toString()));

        }
    }



    public void handleclosebtn(ActionEvent event) {
        if(event.getSource().equals(closebtn)){
            Stage stage= (Stage) closebtn.getScene().getWindow();
            stage.close();
        }
    }

    public static class data{
        public String name;
        public String score;

        public data(String name, String score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public String getScore() {
            return score;
        }
    }
}