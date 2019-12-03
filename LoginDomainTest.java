import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginDomainTest {

    private String url="https://www.cheapdomains.com.au/register/member_register.php";
    private String nameXPath= "//input[@name='username_login']";
    private String passXPath= "//input[@name='password_login']";
    private String loginButtonXpath ="//table[@class='innertable']//div//input[@name='Submit']";
    private String typedName = "Sasha";
    private String typedPass = "Sasha123";

    private WebDriver driver;
    private WebElement loginButton;
    private WebElement nameField;
    private WebElement passField;



    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        // driver = new SafariDriver();
        driver.get(url);
        loginButton=initWebObject(loginButtonXpath);
        nameField=initWebObject(nameXPath);
        passField=initWebObject(passXPath);


    }

    @Test
    public void LoginTest(){
        nameField.sendKeys(typedName);
        passField.sendKeys(typedPass);
        loginButton.click();

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
