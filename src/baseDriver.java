import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class baseDriver {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @BeforeClass(alwaysRun = true)
    public void baseDriver() {
//        User atlanta@gmail.com
//        Password: Asdf4321-
        String userName = "atlanta@gmail.com";
        String password = "Asdf4321-";

        System.setProperty("webdriver.chrome.driver", "D:\\BrowserDriver\\chromedriver.exe");


        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.className("login"));
        login.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(userName);

        WebElement passwd = driver.findElement(By.id("passwd"));
        passwd.sendKeys(password);

        WebElement submitLogin = driver.findElement(By.id("SubmitLogin"));
        submitLogin.click();
    }

}
