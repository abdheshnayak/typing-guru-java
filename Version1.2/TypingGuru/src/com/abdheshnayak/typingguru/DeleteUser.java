package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.staticData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteUser {
    @FXML
    private Label wrongpasswordlabel;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button btnYes;
    @FXML
    private Button btnNo;
    @FXML
    private Label usernameLabel;
    addUserClass user= new addUserClass();
    public void initialize(){

        usernameLabel.setText(staticData.usrname);

    }

    public void onActionHandle(ActionEvent event) throws IOException, ClassNotFoundException {
//        System.out.println(user.usrdata.users.get(user.usrdata.users.keySet().toArray()));
        if(event.getSource().equals(btnNo)){
            Stage stage = (Stage) btnNo.getScene().getWindow();
            stage.close();
        }else if(event.getSource().equals(btnYes)){
//            System.out.println("Yes");

            user.readUsers();
            if (user.usrdata.users.containsKey(staticData.usrname)) {
//                String[] keysName = user.usrdata.users.keySet().toArray(new String[0]);
//                System.out.println(user.usrdata.userNames.get(0));
                if (passwordField.getText().trim().equals(user.usrdata.users.get(staticData.usrname))||passwordField.getText().trim().equals(user.usrdata.users.get(user.usrdata.userNames.get(0)))) {
//                    System.out.println("Password Matched");
                    user.usrdata.users.remove(staticData.usrname);
                    user.usrdata.Score.remove(staticData.usrname);
                    user.usrdata.userNames.remove(staticData.usrname);
                    Stage stage = (Stage) btnNo.getScene().getWindow();
                    stage.close();
                    user.writeUsers();

                }else {
                    wrongpasswordlabel.setText("Wrong Password Try Again");
                    passwordField.clear();
//                    System.out.println("Password Not Matched");
                }
            }

        }else {

        }
    }
}
