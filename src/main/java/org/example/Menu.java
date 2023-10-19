package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Menu {

   SelenideElement resetApp = $("#reset_sidebar_link");

   public void resetButton(){
       resetApp.click();
   }


}
