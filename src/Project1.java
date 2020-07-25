import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Project1 extends baseDriver {

    reusablePage elements = new reusablePage(driver);

    @Test
    public void myAddress() {

        String name = "Sinan";
        String surName = "Genc";
        String addressLine1 = "North Main Street";
        String City = "Alpharetta";
        String PostCode = "30009";
        String phoneNumber = "1235432345";
        String alias = "Home Addres";
        wait.until(ExpectedConditions.visibilityOf(elements.myAddress));
    elements.myAddress.click();
        elements.addNewAddress.click();
        elements.firstName.sendKeys(name);
        elements.lastName.sendKeys(surName);
        elements.address1.sendKeys(addressLine1);
        elements.city.sendKeys(City);
        Select state = new Select(elements.idState);
        Random rand = new Random();
        List<WebElement> a = driver.findElements(By.cssSelector("#id_state option"));
        state.selectByIndex(rand.nextInt(a.size() - 1) + 1);
        elements.postCode.sendKeys(PostCode);
        elements.phoneMobile.sendKeys(phoneNumber);
        elements.alias.sendKeys(alias);
        elements.submitAddress.click();
    }
}
