package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.staticData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.*;

public class UserSelector {

    public static String user;

    @FXML
    private Button btnStart;
    @FXML
    private Button btnDelete;
    @FXML
    private ChoiceBox choicebox;
    @FXML
    private Button btnCancel;
    @FXML
    private BorderPane UserSelectorBorderPane;
    @FXML
    private Button btnNewUser;

    private addUserClass usr= new addUserClass();


    private void initializeHelper() throws IOException, ClassNotFoundException {

//        usr.WriteLanguage();
        choicebox.getItems().clear();

        choicebox.getItems().add("Guest User");
//        usr.writeUsers();
        usr.readUsers();

        String[] keysName= usr.usrdata.userNames.toArray(new String[0]);

        choicebox.getItems().addAll(keysName);




        choicebox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });

        choicebox.setValue("Guest User");

    }
    public void initialize() throws IOException, ClassNotFoundException {

        initializeHelper();


    }

    public void ButtonClickedHandle(javafx.scene.input.MouseEvent mouseEvent) throws IOException, ClassNotFoundException {

        if (mouseEvent.getSource().equals(btnNewUser)) {
            userDialog("addUserWindow.fxml");
            initializeHelper();
        } else if (mouseEvent.getSource().equals(btnCancel)) {





            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
//            System.out.println("Close Button Clicked");
        } else if (mouseEvent.getSource().equals(btnStart)) {


            if (choicebox.getValue().toString().equals("Guest User")) {
                staticData.usrname = choicebox.getValue().toString();
                Stage stage = (Stage) btnCancel.getScene().getWindow();
                stage.close();
//            Stage stage = new Stage();
                GridPane root;
                root = (GridPane) FXMLLoader.load(getClass().getResource("Mainwindow.fxml"));
//            PasswordChecker ps = new PasswordChecker();
//            ps.usr= choicebox.getValue().toString();
                Scene scene = new Scene(root, 1280, 720);
                stage.setScene(scene);
                stage.show();

            } else {

                staticData.usrname = choicebox.getValue().toString();
                Stage stage = (Stage) btnCancel.getScene().getWindow();
                stage.close();
//            Stage stage = new Stage();
                GridPane root;
                root = (GridPane) FXMLLoader.load(getClass().getResource("passwordChecker.fxml"));
//            PasswordChecker ps = new PasswordChecker();
//            ps.usr= choicebox.getValue().toString();
                Scene scene = new Scene(root, 500, 200);
                stage.setScene(scene);
                stage.show();
            }
            }else if (mouseEvent.getSource().equals(btnDelete)&& (!choicebox.getValue().toString().equals("Guest User")) ) {
//                System.out.println("Delete btn Clicked");
                staticData.usrname = choicebox.getValue().toString();
                Stage stage = new Stage();
                GridPane root;
                root = (GridPane) FXMLLoader.load(getClass().getResource("deleteUser.fxml"));
    //            PasswordChecker ps = new PasswordChecker();
    //            ps.usr= choicebox.getValue().toString();
                Scene scene = new Scene(root, 600, 300);
                stage.setScene(scene);
                stage.showAndWait();
                initializeHelper();
        }

    }

    public void userDialog(String fxmlName) throws IOException, ClassNotFoundException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(UserSelectorBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxmlName));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
//            System.out.println("Exception:");
            e.printStackTrace();
            return;
        }

//            Parent root = FXMLLoader.load(getClass().getResource("addUserWindow.fxml"));
//            dialog.getDialogPane().setContent(root);
//            dialog.setTitle("Add New User");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
//        System.out.println("Ok");
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent()&&result.get()==ButtonType.OK){
            addUserClass newUser = fxmlLoader.getController();
            if(newUser.save()==1){
                result=dialog.showAndWait();
            }

//            System.out.println("OK Pressed");

        }else {
//            System.out.println("Cancel Pressed");
        }


    }

}
