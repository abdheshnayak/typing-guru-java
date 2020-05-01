package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.staticData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Program Started Succesfully");
//        staticData.usrname=a.usrdata.users.get()
//        Parent root = FXMLLoader.load(getClass().getResource("FreeWriting.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("UserSelector.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("ExampleFxml.fxml"));
        primaryStage.setTitle("Typing Guru");

        FileInputStream input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/DialogIcon.png");

        primaryStage.getIcons().add(new Image(input));
//        primaryStage.setScene(new Scene(root,1280,740));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        staticData.myDir=System.getProperty("user.dir");
    //    System.out.println(staticData.myDir);
        launch(args);
    }
}
