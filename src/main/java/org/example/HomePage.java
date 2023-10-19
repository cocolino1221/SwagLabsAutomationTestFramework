package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.devtools.v85.page.Page;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {


    public static final String HOMEPAGE_URL = "https://www.saucedemo.com/";



    public void openPage(){
        Selenide.open("https://www.saucedemo.com/");
    }





}