import org.example.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
    HomePage page;
    Header header;
    Menu menu;
    Product product;
    Footer footer;


    @BeforeTest
    public void before() {
        page = new HomePage();
        header = new Header();
        menu = new Menu();


    }

    @AfterTest
    public void reset() {
        header.openMenuButton();
        menu.resetButton();
    }

    @Test
    public void openPage() {
        page.openPage();
        Assert.assertEquals(header.getTitle(), "Swag Labs");
    }

    @Test
    public void verifyIfProductAreDisplayed(){
        page.openPage();
        product.validateIfProductExist();
    }


}
