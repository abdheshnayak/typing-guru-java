package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.staticData;
import com.abdheshnayak.typingguru.JavaClasses.tempDatas;
import com.abdheshnayak.typingguru.keyboard_controller.keyboardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FreeWriting {
    public TextArea youTyped;
    public keyboardController keyboardController;
    @FXML
    private ChoiceBox LanguageSelector;
    @FXML
    private Label userNameLabel;

    private Map<String, Integer> keys = new HashMap<>();


    private tempDatas td = new tempDatas();

    public void LanguageController(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(LanguageSelector)) {

            staticData.unvLanguage=LanguageSelector.getValue().toString();

            youTyped.setPromptText("Type Here...");
            youTyped.setText("");

            youTyped.getStyleClass().remove("freeTypingBoxEnglish");
            youTyped.getStyleClass().remove("freeTypingBoxHindi");
            youTyped.getStyleClass().remove("freeTypingBoxNepali");
            youTyped.getStyleClass().remove("freeTypingBoxPunjabi");
            youTyped.getStyleClass().remove("freeTypingBoxUrdu");
            youTyped.getStyleClass().remove("freeTypingBoxTamil");
            youTyped.getStyleClass().remove("freeTypingBoxBengali");

            youTyped.getStyleClass().add("freeTypingBox"+staticData.unvLanguage);


            //            youTyped.getStyleClass().add("redbg");
            keyboardController.changeFont(staticData.unvLanguage);
        }

    }

    FileInputStream input;
    Image image ,image2;
    public void initialize() throws IOException {

        td.addLessons();

        LanguageSelector.getItems().clear();
        String[] lg = td.languages.values().toArray(new String[0]);
        LanguageSelector.getItems().addAll(lg);

        userNameLabel.setText(staticData.usrname);

        LanguageSelector.setValue("English");

    }

    public void onHandleKeyPressed(KeyEvent keyEvent) throws IOException {
        int x;
            try {
            x = (int) keyEvent.getText().charAt(0);
            keyboardController.turnKeyOn(keyEvent.getText(), "greenbg");
        } catch (Exception e) {
            keyboardController.turnKeyOn(keyEvent.getCode().toString(), "greenbg");
            return;
        }
    }

    public void onHandleKeyReleased(KeyEvent keyEvent) {
        keyboardController.clearAllTurned("redbg");
    }
}
