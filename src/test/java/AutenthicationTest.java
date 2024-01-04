import com.codeborne.selenide.Selenide;
import config.TestConfig;
import dataprovider.DataProviderForTest;
import dataprovider.User;
import org.example.AuthenticationPage;
import org.example.Header;
import org.example.HomePage;
import org.example.Menu;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AutenthicationTest extends TestConfig {

    HomePage page;
    Menu menu;
    Header header;
    AuthenticationPage login;


    @BeforeTest
    public void setup(){
        page = new HomePage();
        page.openPage();
        menu = new Menu();
        header = new Header();
        login = new AuthenticationPage();

    }
    @AfterMethod
    public void reset(){
        Selenide.refresh();
        header.openMenuButton();
        menu.resetButton();
    }

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "UserDataProviderTest")
    public void loginWithDifferentCredentials(User user){
        page.openPage();
        login.clickUsername();
        login.typeInUsername(user.getUserName());
        login.clickPassword();
        login.typeInPassword(user.getPassword());
        login.clickLogin();
        assertEquals(header.getTitle(), "Swag Labs",
                "When click login button swag labs title must be displayed");

    }
}
