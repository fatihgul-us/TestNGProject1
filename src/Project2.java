import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Project2 extends baseDriver{

    @Test
    public void selectWishList() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(elements.dressesButton));
        elements.dressesButton.click();
        elements.chiffonDress.click();
        String selectedProduct = elements.selectedProduct.getText();
        elements.addToWishList.click();
        wait.until(ExpectedConditions.visibilityOf(elements.closeComfirmation));
        elements.closeComfirmation.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, -500)");
        action.moveToElement(elements.accountName).click().perform();
        wait.until(ExpectedConditions.visibilityOf(elements.wishListButton));
        elements.wishListButton.click();
        wait.until(ExpectedConditions.visibilityOf(elements.viewButton));
        elements.viewButton.click();
        wait.until(ExpectedConditions.visibilityOf(elements.productName));
       String productName = elements.productName.getText();

        Assert.assertTrue(productName.contains(selectedProduct));


    }

    @Test(dependsOnMethods = "selectWishList")
    public void removeItem() throws InterruptedException {

        elements.removeIcon.click();
        driver.switchTo().alert().accept();

        boolean x;
        Thread.sleep(3000);
        try{
            //  elements.addressTitle.getText();
            System.out.println(elements.viewButton.getText());
            x= true;
        }catch(Exception e){
            x= false;
        }
        Assert.assertFalse(x);
    }
}
