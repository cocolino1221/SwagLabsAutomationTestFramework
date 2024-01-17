import com.codeborne.selenide.Selenide;
import dataprovider.CheckoutDetails;
import dataprovider.DataProviderForTest;
import org.example.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutFunctionTest {
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
    public void setupForCheckout() {
        page.openPage();
        login.clickUsername();
        login.typeInUsername("standard_user");
        login.clickPassword();
        login.typeInPassword("secret_sauce");
        login.clickLogin();
        assertEquals(header.getTitle(), "Swag Labs",
                "When click login button swag labs title must be displayed");
        product = new Product("4", "Sauce Labs Backpack", "29.99");
        product.addToCart();
        assertEquals(header.getCartCounter(), "1",
                "When adding a product to cart, cart badge must increment by 1");
        header.cartButton();
        assertEquals(cartPage.getCartTitle(), "Your Cart", "When cart page is open " +
                "Your cart title must be displayed");
        cartPage.clickCheckoutButton();
        assertEquals(checkoutPage.getCheckoutPageTitle(), "Checkout: Your Information", "When checkout page is open " +
                "Checkout: Your Information title must be displayed");
    }
    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "CheckoutDetails")
    public void checkOutTest(CheckoutDetails checkoutDetails){
        setupForCheckout();
        checkoutPage.clickFirstName();
        checkoutPage.typeInFirstName(checkoutDetails.getFirstName());
        assertEquals(checkoutPage.getTextFirstName(),checkoutDetails.this.getFirstName(),"First name must be the same");



    }
}
