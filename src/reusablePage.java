import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class reusablePage {

    public WebDriver driver;

    public reusablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "a[href='http://automationpractice.com/index.php?controller=addresses']")
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

    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[4]")
    public WebElement adressLine1;
    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[5]")
    public WebElement adressLine2;
    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[6]")
    public WebElement country;
    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[8]")
    public WebElement phoneNumber;

    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[9] /a[1]")
    public WebElement ubdateButton;

    @FindBy(xpath = "//ul[@class='last_item alternate_item box']  //li[9] /a[2]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    public WebElement dressesButton;


    @FindBy(css = "h5 a[title='Printed Chiffon Dress']")
    public WebElement chiffonDress;

    @FindBy(id = "wishlist_button")
    public WebElement addToWishList;

    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/a")
    public WebElement closeComfirmation;

    @FindBy(xpath = "//a[@class='account'] /span")
    public WebElement accountName;



    @FindBy(css = "a[title='My wishlists']")
    public WebElement wishListButton;

    @FindBy(css = "i[class='icon-remove']")
    public WebElement removeIcon;

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td[5]/a")
    public WebElement viewButton;

    @FindBy(id = "s_title")
    public WebElement productName;

    @FindBy(css= "h1[itemprop='name']")
    public WebElement selectedProduct;













}
