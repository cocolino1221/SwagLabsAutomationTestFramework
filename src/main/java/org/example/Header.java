package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Header {
    SelenideElement buttonMenu = $("#react-burger-menu-btn");
    public final SelenideElement cartButton = $(".shopping_cart_link");
    public final SelenideElement cartBadge = $(".shopping_cart_badge");
    public String getTitle(){
        return Selenide.title();
    }
    public void openMenuButton(){
        buttonMenu.click();
    }
    public void cartButton(){
        cartButton.click();
    }
    public String getCartCounter(){
        return cartBadge.getText();
    }
}
