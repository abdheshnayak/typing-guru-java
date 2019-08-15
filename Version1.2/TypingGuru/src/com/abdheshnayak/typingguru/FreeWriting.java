package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.fileReaderClass;
import com.abdheshnayak.typingguru.JavaClasses.staticData;
import com.abdheshnayak.typingguru.JavaClasses.tempDatas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class FreeWriting {
    @FXML
    private ImageView playpauseImage;
    @FXML
    private Button powerBtn;
    @FXML
    private ChoiceBox LanguageSelector;
    @FXML
    private WebView toTypeViewLayoutWebView;
    @FXML
    private Label userNameLabel;
    @FXML
    private WebView webopen;
    private Map<String, Integer> keys = new HashMap<>();

    private boolean pwrBtnFlag=false;

    private tempDatas td = new tempDatas();

    private String taskC;
    private String strWord = "";


    private String tempKeyboardtoType="file://"+ staticData.myDir+"/.src/Images/keyboard/temptoTypehtmlfile.html";
    private String tempKeyboard="file://"+staticData.myDir+"/.src/Images/keyboard/tempKeyboard.html";



//    public void LanguageController(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
//
//        if(actionEvent.getSource().equals(LanguageSelector)) {
//            staticData.unvLanguage=LanguageSelector.getValue().toString();
//            td.hw.ChangeLanguage(LanguageSelector.getValue().toString());
//            td.t.run();
//            keyboardLoad();
//        }
//
//    }


    public void LanguageController(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(LanguageSelector)) {
            strWord="";
            staticData.unvLanguage=LanguageSelector.getValue().toString();
            td.hw.ChangeLanguage(LanguageSelector.getValue().toString());
            td.t.run();
            playpauseImage.setImage(image);
            powerBtn.setText("Start");
            pwrBtnFlag=false;

            td.tw.write("Type Here....After Clicking On Start Button.");
            td.t1.run();

            keyboardLoad();
        }

    }

    FileInputStream input;
    Image image ,image2;
    public void initialize() throws IOException {
        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/play.png");
        image = new Image(input);
        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/pause.png");
        image2= new Image(input);
        playpauseImage.setImage(image);


        powerBtn.setText("Start");

        td.addLessons();

        td.t = new Thread(td.hw);

        td.hw.setToNull();
        td.hw.ChangeLanguage(staticData.unvLanguage);





//        td.user.readLanguages();
        LanguageSelector.getItems().clear();
        String[] lg = td.languages.values().toArray(new String[0]);
        LanguageSelector.getItems().addAll(lg);

//        LanguageSelector.setValue("English");

        userNameLabel.setText(staticData.usrname);


        td.t1= new Thread(td.tw);


        td.tw.write("Type Here");
        td.t1.run();


        keys.clear();
        td.hw.write(keys);
        td.t.run();

        keyboardLoad();

        LanguageSelector.setValue("English");

    }

    private   void keyboardLoad() {
        WebEngine webEngine= webopen.getEngine();
        webEngine.load(tempKeyboard);

        WebEngine webEngine1= toTypeViewLayoutWebView.getEngine();
        webEngine1.load(tempKeyboardtoType);
    }


    public void onHandleKeyPressed(KeyEvent keyEvent) throws IOException {
        if(pwrBtnFlag==true) {
            int x;

//            System.out.println("Size = " + strWord.length());
//                    System.out.println(keyEvent.toString());
            //        System.out.println(keyEvent.getCode());
            switch (keyEvent.getCode().toString()) {
                case "CAPS":
                    if (keys.containsKey("CAPS")) {
                        keys.remove(keyEvent.getCode().toString());
                        td.hw.write(keys);
                        td.t.run();
                        keyboardLoad();
                        return;
                    }
                case "ALT":
                case "TAB":
                case "SHIFT":
                case "ENTER":
                case "ESCAPE":
                case "CONTROL":
                    //                System.out.println("hello");
                    keys.clear();
                    keys.put(keyEvent.getCode().toString(), 1);
                    td.hw.write(keys);
                    td.t.run();
                    keyboardLoad();
                    return;
                case "BACK_SPACE":
                    keys.clear();
                    if (strWord.length() == 0) {
                        keys.put(keyEvent.getCode().toString(), 2);
                    } else {
                        keys.put(keyEvent.getCode().toString(), 1);

                        strWord = strWord.substring(0, strWord.length() - 1);
                        td.tw.write(strWord);
                        td.t1.run();
                    }
                    td.hw.write(keys);
                    td.t.run();
                    keyboardLoad();
                    return;
            }
            String tempStr;
            tempStr = keyEvent.getText();

            if (keyEvent.isShiftDown()) {
                tempStr = td.is.convert(tempStr);
            }

            strWord = strWord + tempStr;

            //        System.out.println(keys.size());
            keys.put(tempStr, 1);
            if (keys.size() > 1) {
                keys.clear();
                keys.put(tempStr, 1);
            }
            td.t.run();
            td.tw.write(strWord);
            td.t1.run();
            keyboardLoad();
        }
    }

    public void powerBtnController(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(powerBtn)){
            if(pwrBtnFlag==true){
                pwrBtnFlag=false;
                playpauseImage.setImage(image);
                powerBtn.setText("Start");

            }else {
                pwrBtnFlag=true;
                playpauseImage.setImage(image2);
                powerBtn.setText("Pause");

            }
        }
    }
}
