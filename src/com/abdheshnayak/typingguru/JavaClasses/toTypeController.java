package com.abdheshnayak.typingguru.JavaClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class toTypeController implements Runnable{
    private Map<String, Integer> capital = new HashMap<String, Integer>();
    private Map<String, Integer> All = new HashMap<String, Integer>();
    private ArrayList<String> datas = new ArrayList<String>();
    private class Datas{
        String strFirst;
        String strWord;
        String strLast;
    }
    private Datas strings=new Datas();
    private String pname=staticData.myDir+"/.src/Images/keyboard/temptoTypehtmlfile.html";

    public toTypeController() {


        datas.add("<strong >");
        All.put("green", 0);

        datas.add("<strong style=\"box-shadow: 0px 0px 5px 1px grey;padding: 2px; background: rgba(255,255,255,0.2); margin:2px; border-radius:4px;\">");
        All.put("float",All.size());
        datas.add("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"https://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "\n" +
                "    <title>Online Keyboard</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"styleoftoTypehtml.css\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"keyboard\" >\n" +
                "    <p style=\"Font-size:22px;\">");
        All.put("htmlStart", All.size());
        datas.add("</strong>");
        All.put("strongClose", All.size());
        datas.add("</p>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n");
        All.put("endHtml", All.size());

    }

    String lsn = new String();

    public String read(String pname) throws IOException {
        lsn = "";
        FileReader inputStream = null;
        int x = 0;
        try {
            inputStream = new FileReader(String.valueOf(pname));
            int c;
            while ((c = inputStream.read()) != -1) {
                lsn = lsn + String.valueOf((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
//        System.out.println(lsn);
//        System.out.println("Read");
        return lsn;
    }

    private Map<String,Integer> keys;


    public void write(String strWord){
        String tempst= "";

        if(strWord.length()>400){
            strWord=strWord.substring(strWord.length()-400);;

        }

        if(staticData.unvLanguage.equals("English")){
            tempst="";
        }else {
            tempst="font-size:30px;";
        }
        strings.strFirst="<span style=\"font-family: "+staticData.unvLanguage+";"+tempst+"\">"+strWord;
        strings.strLast="</span>";
        strings.strWord="";
    }

    public void write(String strFirst,String strSecond,String strThird) throws IOException {
//        System.out.println(strFirst+" : "+strSecond+" : "+strThird);
        try {
            String temp = "";
            for (int i = 0; i < strFirst.length(); i++) {
                if (strFirst.charAt(i) == ' ') {
                    temp = temp + " &nbsp;";
                } else {
                    temp += strFirst.charAt(i);
                }
            }
            strings.strFirst = temp;
//            System.out.println(temp);

            temp = "";
            for (int i = 0; i < strSecond.length(); i++) {
                if (strSecond.charAt(i) == ' ') {
                    temp = temp + " &nbsp;";
                } else {
                    temp += strSecond.charAt(i);
                }
            }
            strings.strWord = strSecond;
//            System.out.println(temp);

            temp = "";
            for (int i = 0; i < strThird.length(); i++) {
                if (strThird.charAt(i) == ' ') {
                    temp = temp + " &nbsp;";
                } else {
                    temp += strThird.charAt(i);
                }
            }
            strings.strLast = temp;
//            System.out.println(temp);

        }catch (Exception e){
            System.out.println(e);
        }
    }


    @Override
    public void run() {
        FileWriter outputStream = null;
        lsn = "";
        lsn = datas.get(All.get("htmlStart")) + strings.strFirst + datas.get(All.get("green")) + strings.strWord + datas.get(All.get("strongClose")) + strings.strLast + datas.get(All.get("endHtml"));

//        System.out.println(lsn);
        try {
            outputStream = new FileWriter(String.valueOf(pname));
            outputStream.write(lsn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("Written");
    }

    }


