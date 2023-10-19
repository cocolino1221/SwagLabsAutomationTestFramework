import config.TestConfig;
import dataprovider.DataProviderForTest;
import dataprovider.User;
import org.checkerframework.checker.units.qual.A;
import org.example.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class EndToEndTest extends TestConfig {
    HomePage page;
    Menu menu;
    Header header;
    AuthenticationPage login;
    Product product;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;

    @BeforeTest
    public void setup(){
        page = new HomePage();
        menu = new Menu();
        header = new Header();
        login = new AuthenticationPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        overviewPage = new OverviewPage();
    }
    @AfterMethod
    public void reset(){
        header.openMenuButton();
        menu.resetButton();
    }
    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "UserDetails")
    public void endToEndTestWithDifferentUsers(User user){
        page.openPage();
        login.clickUsername();
        login.typeInUsername(user.getUserName());
        login.clickPassword();
        login.typeInPassword(user.getPassword());
        login.clickLogin();
        assertEquals(header.getTitle(), "Swag Labs",
                "When click login button swag labs title must be displayed");
        product = new Product("4", "Sauce Labs Backpack", "29.99");
        product.addToCart();
        assertEquals(header.getCartCounter(), "1",
                "When adding a product to cart, cart badge must increment by 1");
        header.cartButton();
        assertEquals(cartPage.getCartTitle(),"Your Cart","When cart page is open " +
                "Your cart title must be displayed");
        cartPage.clickCheckoutButton();
        assertEquals(checkoutPage.getCheckoutPageTitle(),"Checkout: Your Information","When checkout page is open " +
                "Checkout: Your Information title must be displayed");
        checkoutPage.clickFirstName();
        checkoutPage.typeInFirstname("John");
        checkoutPage.clickLastName();
        checkoutPage.typeInLastname("Wick");
        checkoutPage.clickPostalCode();
        checkoutPage.typeInPostalCode("25348");
        checkoutPage.clickContinue();
        assertEquals(overviewPage.getOverviewPageTitle(),"Checkout: Overview");
        overviewPage.clickFinishButton();
        CompleteOrderPage completeOrderPage = new CompleteOrderPage();
        assertEquals(completeOrderPage.getCompleteOrderMsg(),"Thank you for your order!");
    }
}
