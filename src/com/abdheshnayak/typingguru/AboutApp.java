package com.abdheshnayak.typingguru;

import com.abdheshnayak.typingguru.JavaClasses.staticData;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class AboutApp {
    @FXML
    private WebView aboutUsPage;

    public void initialize() {


        WebEngine webEngine=aboutUsPage.getEngine();

        webEngine.isJavaScriptEnabled();

        webEngine.load("file://"+staticData.myDir+"/.src/Images/AboutUs/index.html");

    }
}
