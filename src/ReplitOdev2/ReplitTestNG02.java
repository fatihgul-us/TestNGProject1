package ReplitOdev2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ReplitTestNG02 extends utilities {

    @Test
    public void changeCurrency() throws InterruptedException {

        WebElement currencyButton = driver.findElement(By.cssSelector("button[id='header-toggle-currency']"));
        currencyButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='widget-overlay-bd'] /ul[2] /li")));
        List<WebElement> currencyList = driver.findElements(By.xpath("//div[@class='widget-overlay-bd'] /ul[2] /li"));
        Random rand = new Random();
        int x = rand.nextInt(currencyList.size()) + 1;
        String currenyText = currencyList.get(x).getText();
        currencyList.get(x).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='header-toggle-currency']")));
        String currencyMenu = driver.findElement(By.cssSelector("button[id='header-toggle-currency']")).getText();

        System.out.println(currencyMenu + " " + currenyText);
        Assert.assertTrue(currenyText.contains(currencyMenu));


    }

//    public void cleanText(String text) {
//        text = text.replaceAll("[^0-9. ]", "");
//        text = text.trim();
//        String[] a = text.split("[ ]");
//
//        double d = Double.parseDouble(a[0]);
//        Assert.assertTrue(d <= 10.0);
//        System.out.println("To city center: "+a[0]);
//        d = Double.parseDouble(a[4]);
//        Assert.assertTrue(d <= 10.0);
//        System.out.println("To LAX: "+a[4]);
//        System.out.println("-------------------------------------------");
//    }
}

