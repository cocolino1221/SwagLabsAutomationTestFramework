import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CompleteOrderPage {
    public final SelenideElement completeOrderMessage = $(".complete-header");

    public String getCompleteOrderMsg() {
        return completeOrderMessage.getText();
    }
}
