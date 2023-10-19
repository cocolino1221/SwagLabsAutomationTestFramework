package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.HomePage;
import org.openqa.selenium.OutputType;


    public class TestConfig {



        public TestConfig() {

            Configuration.browser = "Firefox";
            Selenide.open(HomePage.HOMEPAGE_URL);


        }
        public byte[] screenshot (){
            return Selenide.screenshot(OutputType.BYTES);
        }

    }

