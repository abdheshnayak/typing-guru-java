package com.abdheshnayak.typingguru.JavaClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileReaderClass {
    String pname;
    public fileReaderClass(String filename) {
        pname=filename;
    }

    public String run() throws IOException {
        String lsn= new String();
        FileReader inputStream = null;
        int x=0;
        try {
            inputStream = new FileReader(String.valueOf(pname));
            int c;
            while ((c = inputStream.read()) != -1) {
                lsn=lsn+String.valueOf((char)c);
//                System.out.println(c);
                x++;
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
//        System.out.println(x);
        return lsn;
    }
}
