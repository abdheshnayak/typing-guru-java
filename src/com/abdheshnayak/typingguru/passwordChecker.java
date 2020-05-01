package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.staticData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class passwordChecker {
    @FXML
    private Label wrongLabel;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button closebtn;
    @FXML
    private Button loginbtn;
    @FXML
    private Label UserName;

    public void initialize() {
        UserName.setText(staticData.usrname);
    }

    public void onMouceclickHandle(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if (mouseEvent.getSource().equals(closebtn)) {
            Stage stage = (Stage) closebtn.getScene().getWindow();
            stage.close();

//            Stage stage = new Stage();
            GridPane root;
            root = (GridPane) FXMLLoader.load(getClass().getResource("UserSelector.fxml"));
//            PasswordChecker ps = new PasswordChecker();
//            ps.usr= choicebox.getValue().toString();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        } else if (mouseEvent.getSource().equals(loginbtn)) {

            addUserClass usr = new addUserClass();
            usr.readUsers();
            if (usr.usrdata.users.containsKey(staticData.usrname)) {
                if (passwordField.getText().trim().equals(usr.usrdata.users.get(staticData.usrname))) {
                    Stage stage = (Stage) loginbtn.getScene().getWindow();
                    stage.close();
                    //            Stage stage = new Stage();
                    GridPane root;
                    root = (GridPane) FXMLLoader.load(getClass().getResource("Mainwindow.fxml"));
                    //            PasswordChecker ps = new PasswordChecker();
                    //            ps.usr= choicebox.getValue().toString();
                    Scene scene = new Scene(root, 1280, 720);
                    stage.setScene(scene);
                    stage.show();
                }else {

                    wrongLabel.setText("Wrong Password Try Again !!");
                    passwordField.clear();
                }
            }
        }
    }

    public void onEnterClicked(ActionEvent event) throws IOException, ClassNotFoundException {
        addUserClass usr = new addUserClass();
        usr.readUsers();
        if (usr.usrdata.users.containsKey(staticData.usrname)) {

            if (passwordField.getText().trim().equals(usr.usrdata.users.get(staticData.usrname))) {

                Stage stage = (Stage) loginbtn.getScene().getWindow();
                stage.close();
                //            Stage stage = new Stage();
                GridPane root;
                root = (GridPane) FXMLLoader.load(getClass().getResource("Mainwindow.fxml"));
                //            PasswordChecker ps = new PasswordChecker();
                //            ps.usr= choicebox.getValue().toString();
                Scene scene = new Scene(root, 1280, 720);
                stage.setScene(scene);
                stage.show();

            }else {
                wrongLabel.setText("Wrong Password Try Again !!");
                passwordField.clear();
            }
        }
    }
}