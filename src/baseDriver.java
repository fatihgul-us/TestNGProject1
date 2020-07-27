import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;
    protected reusablePage elements;
    protected String alias;
    protected JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
    @Parameters({"System","Driver","userName", "passWord","aliasName"})
    public void baseDriver(String system, String drivers, String userName, String passWord,String aliasName) {
//        User atlanta@gmail.com
//        Password: Asdf4321-



        if(system.equalsIgnoreCase("webdriver.chrome.driver")){
            System.setProperty(system,drivers );
            driver = new ChromeDriver();
            this.alias=aliasName;
            }
        else if(system.equalsIgnoreCase("webdriver.gecko.driver")){
            System.setProperty(system,drivers );
            driver = new FirefoxDriver();
            this.alias=aliasName;
        }



        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        elements = new reusablePage(driver);
        js =(JavascriptExecutor)driver;

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.className("login"));
        login.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(userName);

        WebElement passwd = driver.findElement(By.id("passwd"));
        passwd.sendKeys(passWord);

        WebElement submitLogin = driver.findElement(By.id("SubmitLogin"));
        submitLogin.click();

    }
//    @AfterClass
//    public void closeBrowser(){
//
//        driver.quit();
//    }
}
