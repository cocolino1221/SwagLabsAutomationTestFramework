import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public final SelenideElement cartTitle = $(".title");
    public final SelenideElement checkoutButton = $("#checkout");

    public String getCartTitle() {
        return cartTitle.getText();
    }
    public void clickCheckoutButton(){
        checkoutButton.click();
    }

}
