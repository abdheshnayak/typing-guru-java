package com.abdheshnayak.typingguru.keyboardController;

import com.abdheshnayak.typingguru.JavaClasses.staticData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class htmlWriter implements Runnable {


    private Map<String, Integer> capital = new HashMap<String, Integer>();
    private Map<String, Integer> All = new HashMap<String, Integer>();
    private ArrayList<String> datas = new ArrayList<String>();
    private String pname= staticData.myDir+"/.src/Images/keyboard/tempKeyboard.html";

    public void ChangeLanguage(String language){
            datas.set(All.get("Language"),"\""+language+".css\"");
    }

    public htmlWriter() {


        datas.add("style=\"background-color:green;box-shadow:0px 0px 10px green;\"");
        All.put("green", 0);
        datas.add("style=\"background-color:red;box-shadow:0px 0px 10px pink;\"");
        All.put("red", All.size());
        datas.add("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"https://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\n" +
                "    <title>Online Keyboard</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=");
        All.put("htmlStart",All.size());
        if(staticData.keyBoardType){
            datas.add("\"English.css\"");
            All.put("Language",All.size());
        }else {
            datas.add("\"Nepali.css\"");
            All.put("Language",All.size());
        }
        datas.add("/>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div style=\"display: flex; flex-direction: column; align-items: center;\">\n" +
                "  <div class=\"FontSize\";>\n" +
                "    <div style=\"padding: 0px; color:blue;\">");

        All.put("htmlStart1",All.size());
        datas.add("As sa asd dsa asdf fdsa sdf lk");
        All.put("ToType",All.size());
        datas.add("</div>\n" +
                "    <div style=\"padding: 0px; height: 5px; padding-bottom:30px;\">\n");
        All.put("htmlStart2",All.size());
        datas.add("      <!-- react-text: 306 -->A<!-- /react-text --><!-- react-text: 310 -->s\n" +
                "      <!-- /react-text --><!-- react-text: 311 -->\n" +
                "      <!-- /react-text --><!-- react-text: 312 -->s\n" +
                "      <!-- /react-text -->\n" );

        All.put("UserTyping",All.size());
        datas.add("    </div>\n" +
                "  </div>\n"+
                "<div class=\"keyboard\" >\n" +
                "\n" +
                "    <div class=\"section-a\">\n" +
                "        <div class=\"key num dual\"");
        All.put("htmlStart3", All.size());
//        datas.add(">\n" +
//                "            Esc\n" +
//                "        </div>\n" +
//                "\n" +
//                "        <div class=\"key function\"");
//        All.put("ESCAPE", All.size());
//        datas.add(">\n" +
//                "            F1\n" +
//                "        </div>\n" +
//                "        <div class=\"key function\"");
//        All.put("F1", All.size());
//        datas.add(">\n" +
//                "            F2\n" +
//                "        </div>\n" +
//                "        <div class=\"key function\"");
//        All.put("F2", All.size());
//        datas.add(">\n" +
//                "            F3\n" +
//                "        </div>\n" +
//                "\n" +
//                "        <div class=\"key function space2\"");
//        All.put("F3", All.size());
//        datas.add(">\n" +
//                "            F4\n" +
//                "        </div>\n" +
//                "        <div class=\"key function\"");
//        All.put("F4", All.size());
//        datas.add(">\n" +
//                "            F5\n" +
//                "        </div>\n" +
//                "        <div class=\"key function\"");
//        All.put("F5", All.size());
//        datas.add(">\n" +
//                "            F6\n" +
//                "        </div>\n" +
//                "        <div class=\"key function\"");
//        All.put("F6", All.size());
//        datas.add(">\n" +
//                "            F7\n" +
//                "        </div>\n" +
//                "        <div class=\"key function space2\"");
//        All.put("F7", All.size());
//        datas.add(">\n" +
//                "            F8\n" +
//                "        </div>\n" +
//                "\n" +
//                "        <div class=\"key function\"");
//        All.put("F8", All.size());
//        datas.add(">\n" +
//                "            F9\n" +
//                "        </div>\n" +
//                "        <div class=\"key function\"");
//        All.put("F9", All.size());
//        datas.add(">\n" +
//                "            F10\n" +
//                "        </div>\n" +
//                "        <div class=\"key function\"");
//        All.put("F10", All.size());
//        datas.add(">\n" +
//                "            F11\n" +
//                "        </div>\n" +
//                "        <div class=\"key function\"");
//        All.put("F11", All.size());
//        datas.add(">\n" +
//                "            F12\n" +
//                "        </div>\n" +
//                "        <!--END FUNCTION KEYS -->\n" +
//                "\n" +
//                "        <div class=\"key num dual\"");
//        All.put("F12", All.size());
        datas.add(">\n" +
                "            ~<br>&nbsp;`\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"key num dual\"");

        capital.put("~",All.size());
        All.put("`", All.size());
        datas.add(">\n" +
                "            !<br>&nbsp;1\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");

        capital.put("!",All.size());
        All.put("1", All.size());
        datas.add(">\n" +
                "            @<br>&nbsp;2\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");

        capital.put("@",All.size());
        All.put("2", All.size());
        datas.add(">\n" +
                "            #<br>&nbsp;3\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put("#",All.size());
        All.put("3", All.size());
        datas.add(">\n" +
                "            $<br>&nbsp;4\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put("$",All.size());
        All.put("4", All.size());
        datas.add(">\n" +
                "            %<br>&nbsp;5\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put("%",All.size());
        All.put("5", All.size());
        datas.add(">\n" +
                "            ^<br>&nbsp;6\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put("^",All.size());
        All.put("6", All.size());
        datas.add(">\n" +
                "            &<br>&nbsp;7\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put("&",All.size());
        All.put("7", All.size());
        datas.add(">\n" +
                "            *<br>&nbsp;8\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put("*",All.size());
        All.put("8", All.size());
        datas.add(">\n" +
                "            (<br>&nbsp;9\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put("(",All.size());
        All.put("9", All.size());
        datas.add(">\n" +
                "            )<br>&nbsp;0\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put(")",All.size());
        All.put("0", All.size());
        datas.add(">\n" +
                "            _<br>&nbsp;-\n" +
                "        </div>\n" +
                "        <div class=\"key num dual\"");
        capital.put("_",All.size());
        All.put("-", All.size());
        datas.add(">\n" +
                "            +<br>&nbsp;=\n" +
                "        </div>\n" +
                "        <div class=\"key backspace\"");
        capital.put("+",All.size());
        All.put("=", All.size());
        datas.add(">\n" +
                "            Backspace\n" +
                "        </div>\n" +
                "        <!--END NUMBER KEYS -->\n" +
                "\n" +
                "        <div class=\"key tab\"");
        All.put("BACK_SPACE", All.size());
        datas.add(">\n" +
                "            Tab\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"key dual\"");
        All.put("TAB", All.size());
        datas.add(">\n" +
                "            Q\n<br> &nbsp;q" +
                "        </div>\n" +
                "        <div class=\"key dual\"");

        capital.put("Q", All.size());
        All.put("q", All.size());
        datas.add(">\n" +
                "            W\n<br> &nbsp;w" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("W", All.size());
        All.put("w", All.size());
        datas.add(">\n" +
                "            E\n<br> &nbsp;e" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("E", All.size());
        All.put("e", All.size());
        datas.add(">\n" +
                "            R<br> &nbsp;r\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("R", All.size());
        All.put("r", All.size());
        datas.add(">\n" +
                "            T<br> &nbsp;t\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("T", All.size());
        All.put("t", All.size());
        datas.add(">\n" +
                "            Y<br> &nbsp;y\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("Y", All.size());
        All.put("y", All.size());
        datas.add(">\n" +
                "            U<br> &nbsp;u\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("U", All.size());
        All.put("u", All.size());
        datas.add(">\n" +
                "            I<br> &nbsp;i\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("I", All.size());
        All.put("i", All.size());
        datas.add(">\n" +
                "            O<br> &nbsp;o\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("O", All.size());
        All.put("o", All.size());
        datas.add(">\n" +
                "            P<br> &nbsp;p\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("P", All.size());
        All.put("p", All.size());
        datas.add(">\n" +
                "            {<Br>&nbsp;[\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("{", All.size());
        All.put("[", All.size());
        datas.add(">\n" +
                "            }<br>&nbsp;]\n" +
                "        </div>\n" +
                "        <div class=\"key dual dual slash\"");
        capital.put("}", All.size());
        All.put("]", All.size());
        datas.add(">\n" +
                "            |<br>&nbsp;\\\n" +
                "        </div>\n" +
                "        <div class=\"key caps\"");
        capital.put("|", All.size());
        All.put("\\", All.size());
        datas.add(">\n" +
                "            Caps<br>Lock\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        All.put("CAPS", All.size());
        datas.add(">\n" +
                "            A<br> &nbsp;a\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("A", All.size());
        All.put("a", All.size());
        datas.add(">\n" +
                "            S<br> &nbsp;s\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("S", All.size());
        All.put("s", All.size());
        datas.add(">\n" +
                "            D<br> &nbsp;d\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("D", All.size());
        All.put("d", All.size());
        datas.add(">\n" +
                "            F<br> &nbsp;f\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("F", All.size());
        All.put("f", All.size());
        datas.add(">\n" +
                "            G<br> &nbsp;g\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("G", All.size());
        All.put("g", All.size());
        datas.add(">\n" +
                "            H<br> &nbsp;h\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("H", All.size());
        All.put("h", All.size());
        datas.add(">\n" +
                "            J<br> &nbsp;j\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("J", All.size());
        All.put("j", All.size());
        datas.add(">\n" +
                "            K<br> &nbsp;k\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("K", All.size());
        All.put("k", All.size());
        datas.add(">\n" +
                "            L<br> &nbsp;l\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("L", All.size());
        All.put("l", All.size());
        datas.add(">\n" +
                "            :<br>&nbsp;;\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put(":", All.size());
        All.put(";", All.size());
        datas.add(">\n" +
                "            \"<br>&nbsp;'\n" +
                "        </div>\n" +
                "        <div class=\"key enter\"");
        capital.put("\"", All.size());
        All.put("'", All.size());
        datas.add(">\n" +
                "            Enter\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"key shift left\"");
        All.put("ENTER", All.size());
        datas.add(">\n" +
                "            Shift\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        All.put("SHIFT", All.size());
        datas.add(">\n" +
                "            Z<br> &nbsp;z\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("Z", All.size());
        All.put("z", All.size());
        datas.add(">\n" +
                "            X<br> &nbsp;x\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("X", All.size());
        All.put("x", All.size());
        datas.add(">\n" +
                "            C<br> &nbsp;c\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("C", All.size());
        All.put("c", All.size());
        datas.add(">\n" +
                "            V<br> &nbsp;v\n" +
                "        </div><div class=\"key dual\"");
        capital.put("V", All.size());
        All.put("v", All.size());
        datas.add(">\n" +
                "        B<br> &nbsp;b\n" +
                "    </div><div class=\"key dual\"");
        capital.put("B", All.size());
        All.put("b", All.size());
        datas.add(">\n" +
                "        N<br> &nbsp;n\n" +
                "    </div><div class=\"key dual\"");
        capital.put("N", All.size());
        All.put("n", All.size());
        datas.add(">\n" +
                "        M<br> &nbsp;m\n" +
                "    </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("M", All.size());
        All.put("m", All.size());
        datas.add(">\n" +
                "            < <br>&nbsp;,\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put("<", All.size());
        All.put(",", All.size());
        datas.add(">\n" +
                "            ><br>&nbsp;.\n" +
                "        </div>\n" +
                "        <div class=\"key dual\"");
        capital.put(">", All.size());
        All.put(".", All.size());
        datas.add(">\n" +
                "            ?<br>&nbsp;/\n" +
                "        </div>\n" +
                "        <div class=\"key shift right\"");
        capital.put("?", All.size());
        All.put("/", All.size());
        datas.add(">\n" +
                "            Shift\n" +
                "        </div>\n" +
                "        <div class=\"key ctrl\"");
        All.put("SHIFT1", All.size());
        datas.add(">\n" +
                "            Ctrl\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"key\"");
        All.put("CONTROL", All.size());
        datas.add(">\n" +
                "            Win\n" +
                "        </div>\n" +
                "        <div class=\"key\"");
        All.put("WIN", All.size());
        datas.add(">\n" +
                "            Alt\n" +
                "        </div>\n" +
                "        <div class=\"key space\"");
        All.put("ALT", All.size());
        datas.add(">\n" +
                "\n" +
                "\n" +
                "\n" +
                "        </div>\n" +
                "        <div class=\"key\"");
        All.put("SPACE", All.size());
        datas.add(">\n" +
                "            Alt\n" +
                "        </div>\n" +
                "        <div class=\"key\"");
        All.put("ALT1", All.size());
        datas.add(">\n" +
                "            Win\n" +
                "        </div>\n" +
                "        <div class=\"key\"");
        All.put("WIN1", All.size());
        datas.add(">\n" +
                "            Fn\n" +
                "        </div>\n" +
                "\n" +
                "\n" +
                "        <div class=\"key ctrl\"");
        All.put("FN", All.size());
        datas.add(">\n" +
                "            Ctrl\n" +
                "        </div>\n");
        All.put("CONTROL1", All.size());
        datas.add("\n" +
                "    </div><!-- end section-a-->\n" +
                "\n" +
                "</div><!-- end sec-func -->\n" +
                "\n" +
                "\n" +
                "</div><!-- end section-b-->\n" +
                "\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
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


    public String write(Map<String, Integer> KeysList,String ToType, String UserTyping) throws IOException {
        keys=KeysList;
        String temp="";
        for (int i=0;i<ToType.length();i++){
            if(ToType.charAt(i)==' ') {
                temp=temp+"&nbsp;";
            }else {
                temp+=ToType.charAt(i);
            }
        }
        datas.set(All.get("ToType"),temp);
        temp="";
        for (int i=0;i<UserTyping.length();i++){
            if(UserTyping.charAt(i)==' ') {
                temp=temp+"&nbsp;";

            }else if(UserTyping.charAt(i)=='_'){
                temp+="<span style=\"font-family:arial;\">_</span>";
            }else {
                temp+=UserTyping.charAt(i);
            }
        }
//        System.out.println(temp);
        datas.set(All.get("UserTyping"),temp);
            return lsn;
    }

    public String write(Map<String, Integer> KeysList, String UserTyping) throws IOException {
        keys=KeysList;
        datas.set(All.get("ToType")," ");

        String temp="";
        for (int i=0;i<UserTyping.length();i++){
            if(UserTyping.charAt(i)==' ') {
                temp=temp+"&nbsp;";
            }else {
                temp+=UserTyping.charAt(i);
            }
        }
        datas.set(All.get("UserTyping"),temp);
        datas.set(All.get("UserTyping"),UserTyping);
        return lsn;
    }

    public String write(Map<String, Integer> KeysList) throws IOException {
        keys=KeysList;
        return lsn;
    }

    public void setToNull(){
        datas.set(All.get("ToType")," ");
        datas.set(All.get("UserTyping")," ");
    }


    @Override
    public void run(){
        FileWriter outputStream = null;
        int x = 0;
        lsn = "";
        if(keys.containsKey("ALT_GRAPH")){
            keys.put("ALT",keys.get("ALT_GRAPH"));
            keys.remove("ALT_GRAPH");
        }
        if(keys.containsKey(" ")){
            keys.put("SPACE",keys.get((" ")));
            keys.remove(" ");
        }
        String[] keysName = keys.keySet().toArray(new String[0]);
//        System.out.println(keys.entrySet());
        for (int i = (int) All.get("htmlStart"); i < All.size(); i++) {
            for (String s : keysName) {

                if (All.containsKey(s)) {
                    if ((i == All.get(s)) && (keys.get(s) == 1)) {
                        lsn = lsn + datas.get(All.get("green"));

                        if (s == "CONTROL") {
                            keys.put("CONTROL1",1);
                        } else if (s == "SHIFT") {
                            keys.put("SHIFT1",1);
                        } else if (s == "ALT") {
                            keys.put("ALT1",1);
                        } else if (s == "WIN") {
                            keys.put("WIN1",1);
                        } else {
                        }
                    } else if ((i == All.get(s)) && (keys.get(s) == 2)) {
                        lsn = lsn + datas.get(All.get("red"));

                        if (s == "CONTROL") {
                            keys.put("CONTROL1",2);
                        } else if (s == "SHIFT") {
                            keys.put("SHIFT1",2);
                        } else if (s == "ALT") {
                            keys.put("ALT1",2);
                        } else if (s == "WIN") {
                            keys.put("WIN1",2);
                        } else {
                        }
                    }
                }else if(capital.containsKey(s)&&keys.get(s)!=0){
                  //  System.out.println("Found");
                    keys.put("SHIFT",keys.get(s));
                    if ((i == capital.get(s)) && (keys.get(s) == 1)) {
                        lsn = lsn + datas.get(All.get("green"));
                    } else if ((i == capital.get(s)) && (keys.get(s) == 2)) {
                        lsn = lsn + datas.get(All.get("red"));

                    }
                }

                keysName = keys.keySet().toArray(new String[0]);
//                System.out.println(keys.entrySet());
            }
            lsn = lsn + datas.get(i);

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
        }
//        System.out.println(lsn);
//        System.out.println("Written");


     }
}
