import org.openqa.selenium.Alert;
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

    @FindBy(id = "postcode")
    public WebElement postCode;

    @FindBy(id = "id_country")
    public WebElement idCountry;

    @FindBy(id = "phone_mobile")
    public WebElement phoneMobile;

    @FindBy(id = "alias")
    public WebElement alias;

    @FindBy(id = "submitAddress")
    public WebElement submitAddress;

    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[1]")
    public WebElement addressTitle;

    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[2]")
    public WebElement nameSurname;

    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[3]")
    public WebElement adressLine1;
    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[4]")
    public WebElement adressLine2;
    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[5]")
    public WebElement country;
    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[6]")
    public WebElement phoneNumber;

    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[9] /a[1]")
    public WebElement ubdateButton;

    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[9] /a[2]")
    public WebElement deleteButton;




}
