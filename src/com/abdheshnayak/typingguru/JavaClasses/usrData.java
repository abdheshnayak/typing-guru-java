package com.abdheshnayak.typingguru.JavaClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class usrData implements Serializable {
    public static final long serialVersionUID = 1L;

    public Map<String ,Integer> Score= new HashMap<>();
    public Map<String ,String> users= new HashMap<>();

    public ArrayList<String> userNames = new ArrayList<String>();

    @Override
    public String toString() {
        return "usrData{" +
                "Score=" + Score +
                ", users=" + users +
                '}';
    }
}
