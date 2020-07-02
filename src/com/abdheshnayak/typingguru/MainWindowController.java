package com.abdheshnayak.typingguru;


import com.abdheshnayak.typingguru.JavaClasses.fileReaderClass;
import com.abdheshnayak.typingguru.JavaClasses.staticData;
import com.abdheshnayak.typingguru.JavaClasses.tempDatas;
import com.abdheshnayak.typingguru.keyboard_controller.keyboardController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import static com.abdheshnayak.typingguru.JavaClasses.SorterClass.ASC;
import static com.abdheshnayak.typingguru.JavaClasses.SorterClass.sortByComparator;

public class MainWindowController {

    public static Stage stage = new Stage();

    @FXML
    public keyboardController keyboardController;
    public Text toType;
    public Text youTyped;
    @FXML
    private MenuItem aboutAppbtn;

    @FXML
    private ImageView StoriesIcon;
    @FXML
    private Button btnStories;
    @FXML
    private ChoiceBox LanguageSelector;
    @FXML
    private MenuItem quite;
    @FXML
    private Label DevLevel;
    @FXML
    private Button btnFree;
    @FXML
    private Label highScoreLablename;
    @FXML
    private Label highScoreLable;
    @FXML
    private Label timerLabel;
    @FXML
    private Label speedLabel;
    @FXML
    private Button btnBottom;
    @FXML
    private Button btnTop;
    @FXML
    private Label userNameLabel;
    @FXML
    private GridPane MainGridPane;
    @FXML
    private ImageView adduserIcon;
    @FXML
    private Button btnAddUser;
    @FXML
    private ImageView userIcon;
    @FXML
    private ImageView level1Icon;
    @FXML
    private ImageView level2Icon;
    @FXML
    private ImageView level3Icon;

    @FXML
    private ImageView FreeIcon;
    @FXML
    private ImageView bottomIcon;
    @FXML
    private ImageView topicon;
    @FXML
    private ImageView HomeIcon;

    @FXML
    private Button btnNepali;
    @FXML
    private Button btnEnglish;
    private String task;
    private String taskC;

    @FXML
    private Button level1;
    @FXML
    private Button level2;

    @FXML
    private Button level3;

    private static tempDatas td=new tempDatas();


    private void setImageFun() throws IOException {

        FileInputStream input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/usericon.png");
        Image image = new Image(input);
        userIcon.setImage(image);


        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/usericon.png");
        image = new Image(input);
        adduserIcon.setImage(image);


        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/home.png");
        image = new Image(input);
        HomeIcon.setImage(image);

        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/topIcon.png");
        image = new Image(input);
        topicon.setImage(image);


        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/Down.png");
        image = new Image(input);
        bottomIcon.setImage(image);

        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/Stories.png");
        image = new Image(input);
        StoriesIcon.setImage(image);


        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/freeWriting.png");
        image = new Image(input);
        FreeIcon.setImage(image);

        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/level1icon.png");
        image = new Image(input);
        level1Icon.setImage(image);


        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/level2icon.png");
        image = new Image(input);
        level2Icon.setImage(image);

        input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/level3icon.png");
        image = new Image(input);
        level3Icon.setImage(image);
    }


    public void QuiteAction(ActionEvent actionEvent) {

        Stage s= (Stage) btnBottom.getScene().getWindow();
        s.close();

    }

    public void LanguageController(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        if(actionEvent.getSource().equals(LanguageSelector)) {
            staticData.unvLanguage=LanguageSelector.getValue().toString();
            keyboardController.changeFont(LanguageSelector.getValue().toString());
            changeFont(LanguageSelector.getValue().toString());
        }
    }

    public void AboutAppFun(ActionEvent actionEvent) throws IOException {
        if (td.dialogptr) {
            td.dialogptr = false;

            FileInputStream input = new FileInputStream(staticData.myDir + "/.src/Images/Icons/DialogIcon.png");
            stage.getIcons().add(new Image(input));
            GridPane root;

            root = (GridPane) FXMLLoader.load(getClass().getResource("aboutApp.fxml"));
            Scene scene = new Scene(root, 960, 540);
            stage.setScene(scene);

            stage.showAndWait();

            td.dialogptr = true;
        }
    }

    public void onHandleKeyReleased(KeyEvent keyEvent) {
        keyboardController.clearAllTurned("redbg");
    }


//    BackGround Task
    public  class Backgrounds{
        public void go(){
            final Timeline timeline=new Timeline(
                    new KeyFrame(
                            Duration.seconds(1),
                            event -> {
                                if(staticData.tempSwitch){
                                    staticData.timerSeconds++;

                                    int pt,second,minute;
                                    second=staticData.timerSeconds;
                                    pt=second/60;
                                    minute=pt;
                                    pt=60*pt;
                                    second=second-pt;

                                    timerLabel.setText(" "+minute+" : "+second);

                                    float tend,diff;
                                    int fspeed;
                                    tend=staticData.timerSeconds;
                                    diff=tend/td.spaceCounter;

                                    fspeed=(int)(60/diff);

                                    speedLabel.setText(String.valueOf(fspeed));
                                    if(staticData.timerSeconds%100==0){
                                        if(td.user.usrdata.Score.get(staticData.usrname)<fspeed) {
                                            td.user.usrdata.Score.replace(staticData.usrname,fspeed);
                                            try {
                                                td.user.writeUsers();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }
                    )
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }

    }


    public void keyboardLoad(){
        String  ch = td.lsn.substring(td.cursorPointer,td.cursorPointer+1);
        keyboardController.turnKeyOn(ch,"greenbg");
//        System.out.println(lsnparts[td.cursorPointer]);
    }

    public void initializeHelper() throws IOException, ClassNotFoundException {

        td.user.readUsers();
        if(!td.user.usrdata.Score.containsKey(staticData.usrname)){
            td.user.usrdata.Score.put(staticData.usrname,0);
        }


        Map<String, Integer> sortedMapAsc;
        sortedMapAsc= sortByComparator(td.user.usrdata.Score, ASC);
        String[] keysName = sortedMapAsc.keySet().toArray(new String[0]);

        highScoreLablename.setText(keysName[0]);
        highScoreLable.setText(String.valueOf(td.user.usrdata.Score.get(keysName[0])));

        Backgrounds backgrounds=new Backgrounds();
        backgrounds.go();

        userNameLabel.setText(staticData.usrname);

        String filename ;
        filename=staticData.myDir+"/.src/lesson/"+td.lsnlist.get(0);
        fileReaderClass f = new fileReaderClass(filename);
        td.lsn= f.run();
        td.toPrint="";
        String[] lsnparts= td.lsn.split("");
        for(int i = 0 ;i<20;i++){
            td.toPrint=td.toPrint+lsnparts[i];
        }
        td.tempString="";
        for(int i = 1 ;i<20;i++){
            td.tempString=td.tempString+lsnparts[i];
        }
        task=td.toPrint;

        td.temp1=td.toPrint.split("");
        taskC="";
        toType.setText(task);
        youTyped.setText(taskC);

        keyboardLoad();
    }


    public void initialize() throws IOException, ClassNotFoundException {

        td.addLessons();

        DevLevel.setText("By: Abdhesh Nayak");

        td.user.readUsers();
        if(!td.user.usrdata.Score.containsKey(staticData.usrname)){
            td.user.usrdata.Score.put(staticData.usrname,0);
        }


        Map<String, Integer> sortedMapAsc;
        sortedMapAsc= sortByComparator(td.user.usrdata.Score, ASC);
        String[] keysName = sortedMapAsc.keySet().toArray(new String[0]);

        highScoreLablename.setText(keysName[0]);
        highScoreLable.setText(String.valueOf(td.user.usrdata.Score.get(keysName[0])));

        Backgrounds backgrounds=new Backgrounds();
        backgrounds.go();


        userNameLabel.setText(staticData.usrname);

        String filename ;
        filename=staticData.myDir+"/.src/lesson/"+td.lsnlist.get(0);
        fileReaderClass f = new fileReaderClass(filename);
        td.lsn= f.run();
        td.toPrint="";
        String[] lsnparts= td.lsn.split("");
        for(int i = 0 ;i<20;i++){
            td.toPrint=td.toPrint+lsnparts[i];
        }
        td.tempString="";
        for(int i = 1 ;i<20;i++){
            td.tempString=td.tempString+lsnparts[i];
        }
        task=td.toPrint;

        td.temp1=td.toPrint.split("");
        taskC="";
        toType.setText(task);
        youTyped.setText(taskC);
        keyboardLoad();

        setImageFun();

        LanguageSelector.getItems().clear();
        String[] lg = td.languages.values().toArray(new String[0]);
        LanguageSelector.getItems().addAll(lg);

        LanguageSelector.setValue("English");


    }



    public void onHandleKeyPressed(KeyEvent keyEvent) throws IOException{
        int x;
//        keyboardController.onHandleKeyPressed(keyEvent);
        try {
            x = (int) keyEvent.getText().charAt(0);
//            keyboardController.turnKeyOn(keyEvent.getText(), "redbg");
        } catch (Exception e) {
            keyboardController.turnKeyOn(keyEvent.getCode().toString(), "redbg");
            return;
        }

        if(x==8 ||x==127||x==16||(keyEvent.getText().equals("CAPS"))||(keyEvent.getText().equals("ESCAPE")))
        {
            return;
        }

        String[] lsnparts= td.lsn.split("");
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
            }
            //td.spaceCounter++;
            td.toPrint="";

            td.cursorPointer++;

            if(td.cursorPointer+20 > td.lsn.length()-1){
                td.lsnNext();
                td.cursorPointer = 0;
                td.lstcursorPointer = 0;
                td.toPrint = td.lsn.substring(td.cursorPointer,td.cursorPointer+20);
                toType.setText(td.toPrint);
                td.toPrint = td.lsn.substring(0,1);

            }else if(td.cursorPointer%20==0) {
                td.lstcursorPointer=td.cursorPointer;
                td.toPrint = td.lsn.substring(td.cursorPointer,td.cursorPointer+20);

                task=td.toPrint;
                toType.setText(task);

            }

            td.toPrint= "";
            for (int i = td.lstcursorPointer; i < td.cursorPointer; i++) {
                td.toPrint = td.toPrint + lsnparts[i];
            }
            td.toPrint=td.toPrint+"";
            taskC=td.toPrint;
            youTyped.setText(taskC);
            keyboardController.turnKeyOn(td.lsn.substring(td.cursorPointer,td.cursorPointer+1),"greenbg");
        }
        else {
            keyboardController.turnKeyOn(keyEvent.getText(),"redbg");
        }
    }


    public void mouceClickedAction(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        staticData.tempSwitch=false;
        staticData.timerSeconds=0;
        td.spaceCounter=0;

        String filename ;

        filename = staticData.myDir+"/.src/lesson/"+td.lsnlist.get(0);
        if(mouseEvent.getSource().equals(level1)) {
            filename = staticData.myDir+"/.src/lesson/"+td.lsnlist.get(0);
        }else if (mouseEvent.getSource().equals(level2)) {
            filename = staticData.myDir+"/.src/lesson/"+td.lsnlist.get(20);
        }else if (mouseEvent.getSource().equals(level3)) {
            filename = staticData.myDir+"/.src/lesson/"+td.lsnlist.get(30);

        }else if(mouseEvent.getSource().equals(btnNepali)){
//            td.cursorPointer=0;
            staticData.keyBoardType=false;

            staticData.unvLanguage=LanguageSelector.getValue().toString();

//            return;
        }else if(mouseEvent.getSource().equals(btnEnglish)) {
//            td.cursorPointer=0;
            staticData.keyBoardType=true;
//            taskC="";
//            td.hw.write(keys,task,taskC);

            staticData.unvLanguage=LanguageSelector.getValue().toString();

        }else if(mouseEvent.getSource().equals(btnTop)||mouseEvent.getSource().equals(btnBottom)){
            if(mouseEvent.getSource().equals(btnTop)){
                staticData.order=1;
            }else{
                staticData.order=2;
            }
//            System.out.println("btnTop Clicked");
            if(td.dialogptr) {
                td.dialogptr = false;

                Stage stage = new Stage();

                FileInputStream input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/DialogIcon.png");
                stage.getIcons().add(new Image(input));

                BorderPane root;

                root = (BorderPane) FXMLLoader.load(getClass().getResource("topUsersView.fxml"));
                Scene scene = new Scene(root, 800, 600);
                stage.setScene(scene);
                stage.showAndWait();
                td.dialogptr=true;
            }

        }else if (mouseEvent.getSource().equals(btnAddUser)){
            userDialog("addUserWindow.fxml");
            return;
        }else if(mouseEvent.getSource().equals(btnStories)){
            if(td.dialogptr) {
                staticData.keyBoardType=true;
                td.dialogptr = false;
                System.out.println("Free Button");

                FileInputStream input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/DialogIcon.png");
                stage.getIcons().add(new Image(input));
//                Stage stage = (Stage) btnBottom.getScene().getWindow();
                GridPane root;


                root = (GridPane) FXMLLoader.load(getClass().getResource("StoriesTyping.fxml"));
                Scene scene = new Scene(root, 1280, 770);
                stage.setScene(scene);



                stage.showAndWait();



                td.dialogptr=true;
                staticData.timerSeconds=0;
//                StoriesTyping.backgrounds.timeline.stop();


            }
        }else if(mouseEvent.getSource().equals(btnFree)){
            if(td.dialogptr) {
                td.dialogptr = false;
//                System.out.println("Free Button");
                Stage stage = new Stage();

                FileInputStream input = new FileInputStream(staticData.myDir+"/.src/Images/Icons/DialogIcon.png");
                stage.getIcons().add(new Image(input));

//                Stage stage = (Stage) btnBottom.getScene().getWindow();
                GridPane root;


                root = (GridPane) FXMLLoader.load(getClass().getResource("FreeWriting.fxml"));
                Scene scene = new Scene(root, 1280, 750);
                stage.setScene(scene);


                stage.showAndWait();

                td.dialogptr=true;
                staticData.timerSeconds=0;
//                StoriesTyping.backgrounds.timeline.stop();;

            }
        }else {
            filename = staticData.myDir+"/.src/lesson/"+td.lsnlist.get(0);
        }
        fileReaderClass f = new fileReaderClass(filename);
        td.lsn= f.run();

        td.toPrint="";
        String[] lsnparts= td.lsn.split("");
        for(int i = 0 ;i<20;i++){
            td.toPrint=td.toPrint+lsnparts[i];
        }
        td.tempString="";
        for(int i = 1 ;i<20;i++){
            td.tempString=td.tempString+lsnparts[i];
        }
        task=td.toPrint;

        taskC="";
        toType.setText(task);
        youTyped.setText(taskC);

        keyboardLoad();

        td.cursorPointer=0;
        td.lstcursorPointer=0;
        td.temp1=td.toPrint.split("");

    }


    public void userDialog(String fxmlName) throws IOException, ClassNotFoundException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(MainGridPane.getScene().getWindow());
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxmlName));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
//            System.out.println("Exception:");
            e.printStackTrace();
            return;
        }


        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent()&&result.get()==ButtonType.OK){
            addUserClass newUser = fxmlLoader.getController();
            if(newUser.save()==1){
                result=dialog.showAndWait();
            }

        }else {

        }


    }

    public void changeFont(String language) {

        toType.getStyleClass().remove("English");
        toType.getStyleClass().remove("Hindi");
        toType.getStyleClass().remove("Nepali");
        toType.getStyleClass().remove("Punjabi");
        toType.getStyleClass().remove("Urdu");
        toType.getStyleClass().remove("Tamil");
        toType.getStyleClass().remove("Bengali");


        toType.getStyleClass().add(language);

        youTyped.getStyleClass().remove("English");
        youTyped.getStyleClass().remove("Hindi");
        youTyped.getStyleClass().remove("Nepali");
        youTyped.getStyleClass().remove("Punjabi");
        youTyped.getStyleClass().remove("Urdu");
        youTyped.getStyleClass().remove("Tamil");
        youTyped.getStyleClass().remove("Bengali");

        youTyped.getStyleClass().add(language);

    }
}