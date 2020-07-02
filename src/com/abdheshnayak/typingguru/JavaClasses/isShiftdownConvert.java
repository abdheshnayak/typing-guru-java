package com.abdheshnayak.typingguru.JavaClasses;

public class isShiftdownConvert {
    private String tempStr;
    public String convert(String str){
        tempStr=str;
        switch (str){
            case "`":
                tempStr="~";
                break;
            case "1":
                tempStr="!";
                break;
            case "2":
                tempStr="@";
                break;
            case "3":
                tempStr="#";
                break;
            case "4":
                tempStr="$";
                break;
            case "5":
                tempStr="%";
                break;
            case "6":
                tempStr="^";
                break;
            case "7":
                tempStr="&";
                break;
            case "8":
                tempStr="*";
                break;
            case "9":
                tempStr="(";
                break;
            case "0":
                tempStr=")";
                break;
            case "-":
                tempStr="_";
                break;
            case "=":
                tempStr="+";
                break;
            case "q":
                tempStr="Q";
                break;
            case "w":
                tempStr="W";
                break;
            case "e":
                tempStr="E";
                break;
            case "r":
                tempStr="R";
                break;
            case "t":
                tempStr="T";
                break;
            case "y":
                tempStr="Y";
                break;
            case "u":
                tempStr="U";
                break;
            case "i":
                tempStr="I";
                break;
            case "o":
                tempStr="O";
                break;
            case "p":
                tempStr="P";
                break;
            case "[":
                tempStr="{";
                break;
            case "]":
                tempStr="}";
                break;
            case "\\":
                tempStr="|";
                break;
            case "a":
                tempStr="A";
                break;
            case "s":
                tempStr="S";
                break;
            case "d":
                tempStr="D";
                break;
            case "f":
                tempStr="F";
                break;
            case "g":
                tempStr="G";
                break;
            case "h":
                tempStr="H";
                break;
            case "j":
                tempStr="J";
                break;
            case "k":
                tempStr="K";
                break;
            case "l":
                tempStr="L";
                break;
            case ";":
                tempStr=":";
                break;
            case "'":
                tempStr="\"";
                break;
            case "z":
                tempStr="Z";
                break;
            case "x":
                tempStr="X";
                break;
            case "c":
                tempStr="C";
                break;
            case "v":
                tempStr="V";
                break;
            case "b":
                tempStr="B";
                break;
            case "n":
                tempStr="N";
                break;
            case "m":
                tempStr="M";
                break;
            case ",":
                tempStr="<";
                break;
            case ".":
                tempStr=">";
                break;
            case "/":
                tempStr="?";
                break;
        }
        return tempStr;
    }
}
