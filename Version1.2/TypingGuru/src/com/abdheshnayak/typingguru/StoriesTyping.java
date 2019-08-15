package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.fileReaderClass;
import com.abdheshnayak.typingguru.JavaClasses.staticData;
import com.abdheshnayak.typingguru.JavaClasses.tempDatas;
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
    @FXML
    private WebView toTypeViewLayoutWebView;
//    @FXML
//    private Label userTyping;

    @FXML
    private Label userNameLabel;

    @FXML
    private WebView webopen;
    private int tempcursorpointer=0;
    private int ptr,tempptr=0;
    private Map<String, Integer> keys = new HashMap<>();

    private int tempspaceCounter;
    private String[] lsnparts;
    private String[] lsnparts1;
    private tempDatas td = new tempDatas();

    private String filename;
    private String taskC;

    private String tempKeyboardtoType="file://"+ staticData.myDir+"/.src/Images/keyboard/temptoTypehtmlfile.html";
    private String tempKeyboard="file://"+staticData.myDir+"/.src/Images/keyboard/tempKeyboard.html";

//    public void closeFunction(MouseEvent mouseEvent) {
//
//        if(mouseEvent.getSource().equals(ele)){
//            bg.stop();
//            MainWindowController.stage.close();
//        }
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        System.out.println("onStart");
//    }
//
//
//    @Override
//    public void init() throws Exception {
//        super.init();
//        System.out.println("onInit");
//    }
//
//    @Override
//    public void stop() throws Exception {
//        System.out.println("onStop");
//
//        super.stop();
//    }

//    public  class Backgrounds{
//
//
//        final Timeline timeline=new Timeline(
//                new KeyFrame(
//                        Duration.seconds(1),
//                        event -> {
//                            System.out.println("hello");
//                        }
//                )
//        );
//
//        public void go(){
//            timeline.setCycleCount(Animation.INDEFINITE);
//            timeline.play();
////            timeline.stop();
//        }
//        public void stop(){
//
//            timeline.stop();
//        }
//
//    }


//    public Backgrounds bg= new Backgrounds();

    public void initialize() throws IOException {



        MainWindowController.stage.close();


//       bg.go();


        staticData.tempSwitch=false;
        staticData.timerSeconds=0;




        td.cursorPointer=0;
        userNameLabel.setText(staticData.usrname);


        td.t = new Thread(td.hw);
        td.t1= new Thread(td.tw);

        td.addLessons();
        userNameLabel.setText(staticData.usrname);

        Random random=new Random();

        filename = staticData.myDir+"/.src/lesson/" + td.lsnlistMap.get(random.nextInt(td.lsnlistMap.size()));

        fileReaderClass f = new fileReaderClass(filename);
        td.lsn = f.run();
        // td.toPrint="";
        lsnparts = td.lsn.split("");

        lsnparts1=td.lsn.split("");
        ptr = 0;
        String strFirst = "";

        String strWord = "";
        while (!lsnparts[ptr].equals(" ")) {
            strWord = strWord + lsnparts[ptr];
            ptr++;
            ////System.out.println(ptr);
        }
//        System.out.println("1 :"+strWord);
        
        String strLast = "";
        boolean wordptr = false;
        for (int i = ptr; i < 400; i++) {
            ////System.out.println(i);
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
        td.tw.write(strFirst, strWord, strLast);
        td.t1.run();

        taskC="_";
//        userTyping.setText("");


        td.toPrint="";
        lsnparts= td.lsn.split("");
        for(int i = 0 ;i<20;i++){
            td.toPrint=td.toPrint+lsnparts[i];
        }
        td.tempString="";
        for(int i = 1 ;i<20;i++){
            td.tempString=td.tempString+lsnparts[i];
        }
        td.temp1=td.toPrint.split("");
        keys.clear();
        keys.put(td.temp1[td.cursorPointer],1);
        td.hw.write(keys,taskC);
        td.t.run();

        keyboardLoad();


    }

    private   void keyboardLoad() {




        WebEngine webEngine= webopen.getEngine();
        webEngine.load(tempKeyboard);

        WebEngine webEngine1= toTypeViewLayoutWebView.getEngine();
        webEngine1.load(tempKeyboardtoType);
    }

    public void onHandleKeyPressed(KeyEvent keyEvent) throws IOException {

        int x;
        try {
            x= (int) keyEvent.getText().charAt(0);
        }catch (Exception e){
            keys.clear();
            keys.put(keyEvent.getCode().toString(),2);
            keys.put(td.temp1[0],1);
            td.hw.write(keys,taskC);
            td.t.run();
            keyboardLoad();
            return;
        }

        if(x==8 ||x==127||x==16||(keyEvent.getText().equals("CAPS"))||(keyEvent.getText().equals("ESCAPE")))
        {


            keys.clear();
            keys.put(keyEvent.getCode().toString(),2);
            keys.put(td.temp1[td.cursorPointer],1);
            td.hw.write(keys,taskC);
            td.t.run();
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
                String strFirst="";
                while(temp!=tempspaceCounter){
                    if(lsnparts1[ptr].equals(" ")){
                        temp++;
                    }
                    strFirst=strFirst+lsnparts1[ptr];
                    ptr++;
                }

                tempptr=ptr-1;


                String strWord = "";
                while (!lsnparts1[ptr].equals(" ")) {
                    strWord = strWord + lsnparts1[ptr];
                    ptr++;
                }


//                System.out.println("2 :"+strWord);

                String strLast = "";
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
                td.tw.write(strFirst, strWord, strLast);
                td.t1.run();

            }


            td.toPrint="";
            if(td.cursorPointer==td.lsn.length()){
                td.lsnNext();
            }


            td.cursorPointer++;
            tempcursorpointer++;


            td.toPrint="";
            for(int i=tempptr;i<tempptr+tempcursorpointer;i++){
                td.toPrint=td.toPrint+lsnparts1[i];
            }
            taskC=td.toPrint+"_";
//            userTyping.setText(td.toPrint);

            if(td.cursorPointer%400==0) {
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
                ptr = 0;
                String strFirst = "";

                tempptr=ptr;
                String strWord = "";
                while (!lsnparts1[ptr].equals(" ")) {
                    strWord = strWord + lsnparts1[ptr];
                    ptr++;
                }



//                System.out.println("3 :"+strWord);

                String strLast = "";
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
                td.tw.write(strFirst, strWord, strLast);
                td.t1.run();





            }








            td.toPrint= "";
            for (int i = td.cursorPointer; i < td.lstcursorPointer+400; i++) {
                td.toPrint = td.toPrint + lsnparts[i];
            }

            td.temp1=td.toPrint.split("");

            if(td.temp1[0].equals(" ")){
                td.temp1[0]="SPACE";
            }



            keys.clear();
            keys.put(tempStr,0);
            keys.put(td.temp1[0],1);

            td.hw.write(keys,taskC);
            td.t.run();

            int temp=td.cursorPointer;


            keyboardLoad();


        }
        else {
            td.toPrint= "";
            for (int i = td.lstcursorPointer; i < td.cursorPointer; i++) {
                td.toPrint = td.toPrint + lsnparts[i];
            }
            td.toPrint=td.toPrint+"_";

            String temp;
            temp= tempStr;

            switch (keyEvent.getCode().toString()){
                case "ESCAPE":
                    temp="ESCAPE";
                    break;
                case "SPACE":
                    temp="SPACE";
                    break;
                case "ENTER":
                    temp="ENTER";
                    break;
                case "BACK_SPACE":
                    temp="BACK_SPACE";
                    break;
                case "TAB":
                    temp="TAB";

            }

            keys.clear();
            keys.put(temp,2);
            keys.put(td.temp1[0],1);
            td.hw.write(keys,taskC);
            td.t.run();
            keyboardLoad();

            td.toPrint= "";
            for (int i = td.cursorPointer+1; i < td.lstcursorPointer+20; i++) {
                td.toPrint = td.toPrint + lsnparts[i];
            }
        }
//        System.out.println("CP :"+td.cursorPointer+" ptr: "+ptr+" tptr:"+tempptr);
    }


}
