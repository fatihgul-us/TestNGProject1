package ReplitOdev2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class utilities {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;
    protected JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
//    @Parameters({"System","Driver"})
    public void baseDriver() {

        System.setProperty("webdriver.chrome.driver","D:\\BrowserDriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        js=(JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);

        driver.get("https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=\n" +
                "1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-09-15&q-check-\n" +
                "out=2020-09-17&q-rooms=1&q-room-0-adults=2&q-room-0-children=0");
        driver.manage().window().maximize();


    }

}
