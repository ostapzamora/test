import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class RegistrtionTest {
    private String url="https://www.cheapdomains.com.au/register/member_register.php";
    private String firstNameXPath= "//input[@name='first_name']";
    private String lastNameXPath= "//input[@name='last_name']";
    private String adressXPath= "//input[@name='address']";
    private String passXPath= "//input[@name='password']";
    private String usernameXPath= "//input[@name='username']";
    private String orderButtonXpath ="//body/div[@class='wrapper']/div[@class='container']/div[@id='main']/div[@id='column_full']/div[@id='content_pad']/form/table[@class='innertable']/tbody/tr/td/input[1]";
    private String cityXPath = "//input[@name='city']";
    private String zipXPath = "//input[@name='post_code']";
    private String countryXPath = "//select[@id='country_name']";
    private String stateXpath = "//select[@id='state_field']";
    private String phoneXpath = "//input[@id='phone_number']";
    private String ABNXpath = "//input[@name='abn']";
    private String emailXpath = "//input[@name='email']";


//   test data  ---------------------------------------//


    private String typedCity = "Queensland";
    private String typedFirstName = "Sasha";
    private String typedLastName = "Zubrov";
    private String typedAdress = "Queensland krot 23";
    private String typedPass = "Sasha123";
    private String typedZip = "0333222";
    private String selectedCountry = "Australia";
    private String typedState = "Queensland";
    private String typedEmail = "ferdenant@gmail.com";
    private String typedPhone = "3806624656454";
    private String typedABN = "380662465645";
    private String typedUsername = "Serser";
//-----------------------------------------------------//
    private WebDriver driver;
    private WebElement orderButton;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement adressField;
    private WebElement passField;
    private WebElement usernameField;
    private WebElement cityField;
    private WebElement zipField;
    private Select selectCountry;
    private Select selectState;
    private WebElement phoneField;
    private WebElement emailField;
    private WebElement ABNField;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(url);
        firstNameField=initWebObject(firstNameXPath);
        lastNameField=initWebObject(lastNameXPath);
        adressField=initWebObject(adressXPath);
        cityField=initWebObject(cityXPath);
        zipField=initWebObject(zipXPath);
        selectCountry = new Select(driver.findElement(By.xpath(countryXPath)));
        selectState = new Select(driver.findElement(By.xpath(stateXpath)));
        passField=initWebObject(passXPath);
        orderButton=initWebObject(orderButtonXpath);
        phoneField=initWebObject(phoneXpath);
        emailField=initWebObject(emailXpath);
        ABNField=initWebObject(ABNXpath);
        usernameField=initWebObject(usernameXPath);
    }



    @Test
    public void RegistrtionTest(){
        firstNameField.sendKeys(typedFirstName);
        lastNameField.sendKeys(typedLastName);
        adressField.sendKeys(typedAdress);
        cityField.sendKeys(typedCity);
        zipField.sendKeys(typedZip);
        selectCountry.selectByVisibleText(selectedCountry);
        selectState.selectByVisibleText(typedState);
        phoneField.sendKeys(typedPhone);
        emailField.sendKeys(typedEmail);
        ABNField.sendKeys(typedABN);
        usernameField.sendKeys(typedUsername);
        passField.sendKeys(typedPass);
        orderButton.click();

        //driver.findElements(By.xpath("//input[@id='account_type_business']"));



        // just 2 types of income aller. 1 if wrong mail. 2 empty field. almost nothing to assert.





    }
    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }

    }

    private WebElement initWebObject(String XPath){
        return driver.findElement(By.xpath(XPath));
    }
}
