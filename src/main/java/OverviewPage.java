import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    public final SelenideElement overviewPageTitle = $(".title");
    public final SelenideElement finishOrderButton = $("#finish");
    public void clickFinishButton(){
        finishOrderButton.click();
    }
    public String getOverviewPageTitle(){
       return overviewPageTitle.getText();
    }
}
