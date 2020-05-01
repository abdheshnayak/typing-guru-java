package com.abdheshnayak.typingguru.JavaClasses;

public class staticData {
    public static String unvLanguage="English";
    public static String usrname= new String();
    public static int order=0;
    public staticData(String str){
        usrname=str;
    }
    public String getSrt(){
        return usrname;
    }
    public static int timerSeconds;
    public static boolean tempSwitch=false;
    public static String myDir;
    public static boolean keyBoardType=true;

}
