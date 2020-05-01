package com.abdheshnayak.typingguru;


import com.abdheshnayak.typingguru.JavaClasses.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class addUserClass {
    @FXML
    private Label headLabel;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password1;
    @FXML
    private TextField nameField;

    public usrData usrdata = new usrData();
    public langClass langclass = new langClass();
    public void initialize(){
//        System.out.println("Hello");
    }

    private String pname=new String(staticData.myDir+"/.src/UserData/userData.data");
    private String langListFileName=new String(staticData.myDir+"/.src/UserData/LanguageList.list");

    public void readUsers() throws IOException, ClassNotFoundException {

            String lsn= new String();
            FileInputStream is = new FileInputStream(pname);

            ObjectInputStream ois= new ObjectInputStream(is);
            Map<String ,String> obj = new HashMap<>();

            try {
                usrdata=(usrData) ois.readObject();
            }catch (Exception e){
                System.out.println(e);
            }finally {
                try {
                    is.close();
                    ois.close();
                }catch (Exception a){
                    System.out.println(a);
                }
            }
//            System.out.println(usrdata.users.entrySet().toString());
//            while ((c = inputStream.read()) != -1) {
//                    lsn=lsn+String.valueOf((char)c);
////                System.out.println(c);
//                    x++;
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            }
//        System.out.println(x);
//            return lsn;

    }
    public void readLanguages() throws IOException {
        FileInputStream is = new FileInputStream(langListFileName);

        ObjectInputStream ois= new ObjectInputStream(is);
        Map<String ,String> obj = new HashMap<>();

        try {
            langclass=(langClass) ois.readObject();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                is.close();
                ois.close();
            }catch (Exception a){
                System.out.println(a);
            }
        }
    }
    public void writeUsers() throws IOException {


        FileOutputStream outputStream = new FileOutputStream(pname);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        try {
            oos.writeObject(usrdata);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos != null){
                try {
                    oos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
//        System.out.println("Written User");
    }


    public void WriteLanguage() throws IOException {


        int n;
        String s;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Language");
        n= scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<n;i++){
            System.out.println("Enter:");
            langclass.languages.put(langclass.languages.size(),scanner.nextLine());
        }

        FileOutputStream outputStream = new FileOutputStream(langListFileName);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        try {
            oos.writeObject(langclass);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos != null){
                try {
                    oos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
//        System.out.println("Written User");
    }



    public int save() throws IOException, ClassNotFoundException {
        readUsers();
//        System.out.println("Readed Data: "+usrdata.users.entrySet().toString());
        if(usrdata.users.containsKey(nameField.getText().trim())){
            headLabel.setText("User Already Present \nTry with Another Name");
            return 1;
        }
        else if(password.getText().trim().equals(password1.getText().trim())){
            if(!usrdata.users.containsKey(nameField.getText().trim())) {
                usrdata.users.put(nameField.getText().trim(), password.getText().trim());
                usrdata.Score.put(nameField.getText().trim(), 0);
                usrdata.userNames.add(nameField.getText().trim());
                writeUsers();
            }
//            System.out.println("Tried To Write: "+usrdata.users.entrySet().toString());

            return 0;
        }else {
//            System.out.println("Password Not Matched");
            headLabel.setText("Password Not Matched");
            return 1;
//        }
        }


}
}
