import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class reusablePage extends baseDriver{

    private WebDriver driver;

    public reusablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

@FindBy(className = "icon-building")
public WebElement myAddress;

    @FindBy(css = "a[title='Add an address']")
    public WebElement addNewAddress;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement lastName;


    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement idState;

    @FindBy(id = "city")
    public WebElement cityfff;

    @FindBy(id = "city")
    public WebElement cityf;




}
