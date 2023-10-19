package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

public class AuthenticationPage {
    public SelenideElement username = $("#user-name");
    public SelenideElement password = $("#password");
    public SelenideElement loginButton = $("#login-button");

    public void clickUsername() {
        username.click();
    }

    public void clickPassword() {
        password.click();
    }

    public void typeInUsername(String userName) {
        username.setValue(userName);

    }

    public void typeInPassword(String password) {
        this.password.setValue(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
