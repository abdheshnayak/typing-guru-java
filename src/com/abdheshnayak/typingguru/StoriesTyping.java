package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.fileReaderClass;
import com.abdheshnayak.typingguru.JavaClasses.staticData;
import com.abdheshnayak.typingguru.JavaClasses.tempDatas;
import com.abdheshnayak.typingguru.keyboard_controller.keyboardController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class StoriesTyping {
    public keyboardController keyboardController;
    @FXML
    public Text toTypeText;
    @FXML
    private WebView toTypeViewLayoutWebView;

    @FXML
    private Label userNameLabel;

    private int tempcursorpointer=0;
    private int ptr,tempptr=0;

    private int tempspaceCounter;
    private String[] lsnparts;
    private String[] lsnparts1;
    private tempDatas td = new tempDatas();

    private String filename;
    private String taskC;

    private String tempKeyboardtoType="file://"+ staticData.myDir+"/.src/Images/keyboard/temptoTypehtmlfile.html";

    private String lsnString;

    String letter = "<span class=\"highlight\" >";
    String sl;

    public void initialize() throws IOException {

        MainWindowController.stage.close();

        staticData.tempSwitch=false;

        td.cursorPointer=0;
        userNameLabel.setText(staticData.usrname);

        td.t1= new Thread(td.tw);

        td.addLessons();


        Random random=new Random();

        filename = staticData.myDir+"/.src/lesson/" + td.lsnlistMap.get(random.nextInt(td.lsnlistMap.size()));

        fileReaderClass f = new fileReaderClass(filename);

        td.lsn = f.run();
        // td.toPrint="";

        lsnparts = td.lsn.split("");

        lsnparts1=td.lsn.split("");

        lsnString = td.lsn;

        ptr = 0;
        strFirst = "";

        strWord = "";
        while (!lsnparts[ptr].equals(" ")) {
            strWord = strWord + lsnparts[ptr];
            ptr++;
        }

        strLast = "";
        boolean wordptr = false;
        for (int i = ptr; i < 400; i++) {

            if (i % 85 == 0 && i > 0) {
                wordptr = true;
            }
            if (wordptr == true && lsnparts[i].equals(" ")) {
                wordptr = false;
            }

            strLast = strLast + lsnparts[i];
            if (i == 399) {
                wordptr = true;
                for (int j = i + 1; j < 500; j++) {
                    if (wordptr == true && lsnparts[j].equals(" ")) {
                        wordptr = false;
                        break;
                    }
                    strLast = strLast + lsnparts[j];
                }
            }
        }
        ptr+=2;
        td.toPrint="";
        if (td.toPrint.length() <= strWord.length()) {

            sl = td.toPrint + letter + strWord.substring(0,1) + "</span>" + strWord.substring(1);
        }else {
            sl = td.toPrint +letter+ " </span>";
        }
        td.tw.write(strFirst,sl,strLast);
        td.tw.run();

        taskC="_";
        toTypeText.setText(taskC);
//        userTyping.setText("");

        td.toPrint = td.lsn.substring(0,20);
        td.tempString = td.lsn.substring(1,20);
        keyboardController.turnKeyOn(td.toPrint.substring(td.cursorPointer,td.cursorPointer+1),"greenbg");

        keyboardLoad();
    }

    private   void keyboardLoad() {
        WebEngine webEngine1= toTypeViewLayoutWebView.getEngine();
        webEngine1.load(tempKeyboardtoType);
    }

    private int wordStart =0 ,wordEnd =0;
    private String strFirst="",strWord="",strLast="";

    public void onHandleKeyPressed(KeyEvent keyEvent) throws IOException {

        int x;
        try {
            x= (int) keyEvent.getText().charAt(0);
        }catch (Exception e){
            keyboardController.turnKeyOn(keyEvent.getCode().toString(),"redbg");
            keyboardLoad();
            return;
        }


        lsnparts= td.lsn.split("");


        String tempStr;
        tempStr=keyEvent.getText();

        if(keyEvent.isShiftDown()){
            tempStr=td.is.convert(tempStr);
        }


        if(tempStr.equals(lsnparts[td.cursorPointer])){
            if(!staticData.tempSwitch){
                staticData.tempSwitch=true;
            }

            if(lsnparts[td.cursorPointer].equals(" ")){
                td.spaceCounter++;
                tempspaceCounter++;
                taskC="_";
//                userTyping.setText("");
                tempcursorpointer=0;



                int temp=0;
                ptr=0;
                strFirst="";
                while(temp!=tempspaceCounter){
                    if(lsnparts1[ptr].equals(" ")){
                        temp++;
                    }
                    strFirst=strFirst+lsnparts1[ptr];
                    ptr++;
                }


                tempptr=ptr-1;

                strWord = "";

                wordStart = ptr;

                while (!lsnparts1[ptr].equals(" ")) {
                    strWord = strWord + lsnparts1[ptr];
                    ptr++;
                }

                wordEnd = ptr;

                strLast = "";
                boolean wordptr = false;
                for (int i = ptr; i < 400; i++) {
                    if (i % 85 == 0 && i > 0) {
                        wordptr = true;
                    }
                    if (wordptr == true && lsnparts1[i].equals(" ")) {
                        wordptr = false;
                    }
                    strLast = strLast + lsnparts1[i];
                    if (i == 399) {
                        wordptr = true;
                        for (int j = i + 1; j < 500; j++) {
                            if (wordptr == true && lsnparts1[j].equals(" ")) {
                                wordptr = false;
                                break;
                            }
                            strLast = strLast + lsnparts1[j];
                        }
                    }
                }

            }


            td.toPrint="";
            if(td.cursorPointer==td.lsn.length()){
                td.lsnNext();
            }

            td.cursorPointer++;

            tempcursorpointer++;

            td.toPrint = lsnString.substring(tempptr,tempptr+tempcursorpointer);


            taskC=td.toPrint+"_";



            if (td.toPrint.length() <= strWord.length()) {

                sl = td.toPrint + letter + strWord.substring(td.toPrint.length() - 1, td.toPrint.length()) + "</span>" + strWord.substring(td.toPrint.length());
            }else {
                sl = td.toPrint + letter+" </span>";
            }
            td.tw.write(strFirst,sl,strLast);
            td.tw.run();

            toTypeText.setText(taskC);
//            userTyping.setText(td.toPrint);

            if(td.cursorPointer%400==0) {
                td.spaceCounter=0;
                tempspaceCounter=0;
                td.lstcursorPointer=td.cursorPointer;
                int temp=td.cursorPointer;

                while (!lsnparts[temp].equals(" ")){
                    temp--;
                }

                td.toPrint="";
                temp++;
                for (int i = temp; i < td.cursorPointer + 500; i++) {
                    td.toPrint = td.toPrint + lsnparts[i];
                }

                lsnparts1 = td.toPrint.split("");

                lsnString = td.toPrint;

                ptr = 1;
                strFirst = "";

                tempptr=0;
                strWord = "";
                while (!lsnparts1[ptr].equals(" ")) {
                    strWord = strWord + lsnparts1[ptr];
                    ptr++;
                }

                strLast = "";
                boolean wordptr = false;
                for (int i = ptr; i < 400; i++) {
                    if (i % 85 == 0 && i > 0) {
                        wordptr = true;
                    }
                    if (wordptr == true && lsnparts1[i].equals(" ")) {
                        wordptr = false;
                    }
                    strLast = strLast + lsnparts1[i];
                    if (i == 399) {
                        wordptr = true;
                        for (int j = i + 1; j < 500; j++) {
                            if (wordptr == true && lsnparts1[j].equals(" ")) {
                                wordptr = false;
                                break;
                            }
                            strLast = strLast + lsnparts1[j];
                        }
                    }
                }

            }



            td.toPrint = td.lsn.substring(td.cursorPointer,td.cursorPointer+400);

            td.temp1=td.toPrint.split("");

            keyboardController.turnKeyOn(td.temp1[0],"greenbg");

            keyboardLoad();
        }
        else {
            keyboardController.turnKeyOn(keyEvent.getText(),"redbg");
            keyboardLoad();
        }
    }


}