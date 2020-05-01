package com.abdheshnayak.typingguru.JavaClasses;

import com.abdheshnayak.typingguru.addUserClass;
import com.abdheshnayak.typingguru.keyboardController.htmlWriter;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class tempDatas {


    public Map<Integer,String> languages=new HashMap<>();
    public isShiftdownConvert is = new isShiftdownConvert();
    public ArrayList<String> lsnlist = new ArrayList<>();

    public Thread t;
    public Thread t1;
    public Thread t2;

    public boolean dialogptr=true;
    public int spaceCounter;
    public String toPrint;
    public int cursorPointer=0;
    public String lsn ;
    public int lstcursorPointer=0;
    public int filePointer =0;


    public htmlWriter hw= new htmlWriter();
    public toTypeController tw=new toTypeController();
    public String[] temp1;
    public String tempString;

    public Map<Integer,String> lsnlistMap=new HashMap<>();


    public addUserClass user = new addUserClass();



    public void lsnNext() throws IOException {
        filePointer++;
        String filename;
        filename=staticData.myDir+"/.src/lesson/"+lsnlist.get(filePointer);
        fileReaderClass f = new fileReaderClass(filename);
        lsn= f.run();


    }

    public void userDialog(GridPane MainGridPane) throws IOException, ClassNotFoundException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(MainGridPane.getScene().getWindow());
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addUserWindow.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Exception:");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        System.out.println("Ok");
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent()&&result.get()==ButtonType.OK){
            addUserClass newUser = fxmlLoader.getController();
            if(newUser.save()==1){
                result=dialog.showAndWait();
            }

            System.out.println("OK Pressed");

        }else {
            System.out.println("Cancel Pressed");
        }

    }

    public void addLessons() throws IOException {

//        languages.put(languages.size(),"English");
        user.readLanguages();
//        languages.putAll(user.langclass.languages);
        languages=user.langclass.languages;



//        languages.put(languages.size(),"English");
//        languages.put(languages.size(),"Hindi");
//        languages.put(languages.size(),"Nepali");
//        languages.put(languages.size(),"Punjabi");
//        languages.put(languages.size(),"Bangali");
//        languages.put(languages.size(),"Urdu");


//        lsnlist.add("Stories/STORY1.LSN");
    //    MainWindowController.speedLabel.setText("hello");

        lsnlist.add("TYPS1E11.LSN");
        lsnlist.add("TYPS1E12.LSN");
        lsnlist.add("TYPS1E13.LSN");
        lsnlist.add("TYPS1E21.LSN");
        lsnlist.add("TYPS1E22.LSN");
        lsnlist.add("TYPS1E23.LSN");
        lsnlist.add("TYPS1E31.LSN");
        lsnlist.add("TYPS1E32.LSN");
        lsnlist.add("TYPS1E33.LSN");
        lsnlist.add("TYPS1E41.LSN");
        lsnlist.add("TYPS1E42.LSN");
        lsnlist.add("TYPS1E43.LSN");
        lsnlist.add("TYPS1E51.LSN");
        lsnlist.add("TYPS1N11.LSN");
        lsnlist.add("TYPS1N12.LSN");
        lsnlist.add("TYPS1N13.LSN");
        lsnlist.add("TYPS1N21.LSN");
        lsnlist.add("TYPS1N22.LSN");
        lsnlist.add("TYPS1N23.LSN");
        lsnlist.add("TYPS1N31.LSN");
        lsnlist.add("TYPS1N32.LSN");
        lsnlist.add("TYPS1N33.LSN");
        lsnlist.add("TYPS1N41.LSN");
        lsnlist.add("TYPS1N42.LSN");
        lsnlist.add("TYPS1N43.LSN");
        lsnlist.add("TYPS1N51.LSN");
        lsnlist.add("TYPS2E11.LSN");
        lsnlist.add("TYPS2E12.LSN");
        lsnlist.add("TYPS2E13.LSN");
        lsnlist.add("TYPS2E21.LSN");
        lsnlist.add("TYPS2E22.LSN");
        lsnlist.add("TYPS2E23.LSN");
        lsnlist.add("TYPS2E31.LSN");
        lsnlist.add("TYPS2E32.LSN");
        lsnlist.add("TYPS2E33.LSN");
        lsnlist.add("TYPS2E41.LSN");
        lsnlist.add("TYPS2E42.LSN");
        lsnlist.add("TYPS2E43.LSN");
        lsnlist.add("TYPS2N11.LSN");
        lsnlist.add("TYPS2N12.LSN");
        lsnlist.add("TYPS2N13.LSN");
        lsnlist.add("TYPS2N21.LSN");
        lsnlist.add("TYPS2N22.LSN");
        lsnlist.add("TYPS2N23.LSN");
        lsnlist.add("TYPS2N31.LSN");
        lsnlist.add("TYPS2N32.LSN");
        lsnlist.add("TYPS2N33.LSN");
        lsnlist.add("TYPS2N41.LSN");
        lsnlist.add("TYPS2N42.LSN");
        lsnlist.add("TYPS2N43.LSN");

        lsnlistMap.put(lsnlistMap.size(),"Stories/STORY1.LSN");
        lsnlistMap.put(lsnlistMap.size(),"Stories/STORY2.LSN");
        lsnlistMap.put(lsnlistMap.size(),"Stories/STORY3.LSN");
        lsnlistMap.put(lsnlistMap.size(),"Stories/STORY4.LSN");
        lsnlistMap.put(lsnlistMap.size(),"Stories/STORY5.LSN");

    }
}
