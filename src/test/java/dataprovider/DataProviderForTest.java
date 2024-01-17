package dataprovider;

import org.example.Product;
import org.testng.annotations.DataProvider;

public class DataProviderForTest {

    @DataProvider(name = "UserDataProviderTest")
    public Object[] createUserData() {
        return new Object[]{
                new User("standard_user", "secret_sauce"),
                new User("locked_out_user", "secret_sauce"),
                new User("problem_user", "secret_sauce"),
                new User("performance_glitch_user", "secret_sauce")

        };
    }

    @DataProvider(name = "InvalidUserDataProviderTest")
    public Object[] createInvalidUserData() {
        return new Object[]{
                new InvalidUser("problem_user", "", "Please fill in the password!"),
                new InvalidUser("", "secret_sauce", "Please fill in the username!"),
                new InvalidUser("user", "", "Please fill in the password!"),
                new InvalidUser("locked", "12345", "Incorrect username or password!")

        };
    }

    @DataProvider(name = "ProductsDetailsDataProviderTest")
    public static Object[] createProductDetails() {
        return new Object[]{
                new Product("4", "Sauce Labs Backpack", "29.99"),
                new Product("0", "Sauce Labs Bike Light", "9.99"),
                new Product("1", "Sauce Labs Bolt T-Shirt", "15.99"),
                new Product("5", "Sauce Labs Fleece Jacket", "49.99"),
                new Product("2", "Sauce Labs Onesie", "7.99"),
                new Product("3", "Test.allTheThings() T-Shirt (Red)", "15.99"),
        };
    }
    @DataProvider(name = "UserDetails")
    public static Object[] createUserDetails(){
        return new Object[]{
                new User("standard_user", "secret_sauce"),
                new User("problem_user", "secret_sauce"),
                new User("performance_glitch_user", "secret_sauce"),
                new User("error_user", "secret_sauce"),
                new User("visual_user", "secret_sauce"),
        };
    }
    @DataProvider(name = "InvalidUserDetails")
    public static Object[] createInvalidUserDetails(){
        return new Object[]{
                new InvalidUser("standard_user", "secretsauce","Invalid password"),
                new InvalidUser("standarduser", "secret_sauce", "Invalid user"),
                new InvalidUser("","secret_sauce","Please insert username"),
                new InvalidUser("standard_user", " ", "Please insert password"),
        };
    }@DataProvider(name = "CheckoutDetails")
    public static Object[] createCheckoutDetails(){
        return new Object[]{
                new CheckoutDetails("Adam", "John","421098"),
                new CheckoutDetails("Joe", "Man", "92384"),
                new CheckoutDetails("","","xxxxqqw"),
                new CheckoutDetails("Andrew", " ", "131344"),
        };
    }
}
