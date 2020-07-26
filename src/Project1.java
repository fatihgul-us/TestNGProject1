import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Project1 extends baseDriver {

    @Test(priority = 0)
    public void myAddress() {

        String name = "Sinan";
        String surName = "Genc";
        String addressLine1 = "North Main Street";
        String City = "Alpharetta";
        String PostCode = "30009";
        String phoneNumber = "1235432345";




        //  driver.findElement(By.cssSelector("a[href='http://automationpractice.com/index.php?controller=addresses']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.myAddress)).click();
        //   elements.myAddress.click();
        elements.addNewAddress.click();
        elements.firstName.clear();
        elements.firstName.sendKeys(name);
        elements.lastName.clear();
        elements.lastName.sendKeys(surName);
        elements.address1.sendKeys(addressLine1);
        elements.city.sendKeys(City);
        Select state = new Select(elements.idState);
        Random rand = new Random();
        List<WebElement> a = driver.findElements(By.cssSelector("#id_state option"));
        state.selectByIndex(rand.nextInt(a.size() - 1) + 1);
        elements.postCode.sendKeys(PostCode);
        elements.phoneMobile.sendKeys(phoneNumber);
        elements.alias.clear();
        elements.alias.sendKeys(alias);
        elements.submitAddress.click();

        Assert.assertEquals(alias.toLowerCase(), elements.addressTitle.getText().toLowerCase());
        Assert.assertEquals(name + " " + surName, elements.nameSurname.getText());
        Assert.assertEquals(addressLine1, elements.adressLine1.getText());
    }

    @Test(dependsOnMethods = "myAddress")
    public void updateAddress() {
        String nameUpdate = "Merve";
        String surNameUpdate = "Eksilioglu";

        elements.ubdateButton.click();
        elements.firstName.clear();
        elements.firstName.sendKeys(nameUpdate);
        elements.lastName.clear();
        elements.lastName.sendKeys(surNameUpdate);
        elements.submitAddress.click();
        Assert.assertEquals(nameUpdate+" "+surNameUpdate, elements.nameSurname.getText());
    }

    @Test(dependsOnMethods = "updateAddress")
    public void deleteAddress() throws InterruptedException {
  //  List<WebElement> a =driver.findElements(By.cssSelector("div[class='col-xs-12 col-sm-6 address']"));
        elements.deleteButton.click();
        driver.switchTo().alert().accept();
//        a =driver.findElements(By.cssSelector("div[class='col-xs-12 col-sm-6 address']"));
//        Assert.assertEquals(1,a.size());
        boolean x;
        Thread.sleep(3000);
        try{
          //  elements.addressTitle.getText();
            System.out.println(elements.addressTitle.getText());
            x= true;
        }catch(Exception e){
             x= false;
        }
        Assert.assertFalse(x);
    }

}
