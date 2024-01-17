import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    public final SelenideElement checkoutPageTitle = $(".title");
    public final SelenideElement firstName = $("#first-name");
    public final SelenideElement lastName = $("#last-name");
    public final SelenideElement postalCode = $("#postal-code");
    public final SelenideElement continueButton = $("#continue");


    public String getCheckoutPageTitle() {
        return checkoutPageTitle.getText();
    }
    public void clickFirstName(){
        firstName.click();
    }
    public void clickLastName(){
        lastName.click();
    }
    public void clickPostalCode(){
        postalCode.click();
    }
    public void typeInFirstName(String wordToType){
        firstName.sendKeys(wordToType);
    }
    public void typeInLastName(String wordToType){
        lastName.sendKeys(wordToType);
    }
    public void typeInPostalCode(String wordToType){
        postalCode.sendKeys(wordToType);
    }
    public void clickContinue(){
        continueButton.click();
    }
    public String getTextFirstName(){
        return firstName.getText();
    }

}

