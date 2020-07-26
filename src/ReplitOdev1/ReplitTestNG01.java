package ReplitOdev1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ReplitTestNG01 extends utilities {

    @Test
    public void countTheHotels() throws InterruptedException {

        WebElement distance = driver.findElement(By.cssSelector("a[data-menu='sort-submenu-distance']"));
        action.moveToElement(distance).perform();
        WebElement cityCenter = driver.findElement(By.xpath("//*[@id=\"sort-submenu-distance\"]/li[1]/ul/li[1]/a"));
        cityCenter.click();

        List<WebElement> elements = driver.findElements(By.cssSelector("section[class='hotel-wrap']"));
        do {
            js.executeScript("arguments[0].scrollIntoView();", elements.get(elements.size() - 1));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("section[class='hotel-wrap']"), elements.size()));
            System.out.println(elements.size());
            elements = driver.findElements(By.cssSelector("section[class='hotel-wrap']"));
        } while (elements.size() <= 50);

        List<WebElement> distances = driver.findElements(By.cssSelector("ul[class='property-landmarks']"));


        for (int i = 0; i <elements.size() ; i++) {
            cleanText(distances.get(i).getText());
        }

    }

    public void cleanText(String text) {
        text = text.replaceAll("[^0-9. ]", "");
        text = text.trim();
        String[] a = text.split("[ ]");

        double d = Double.parseDouble(a[0]);
        Assert.assertTrue(d <= 10.0);
        System.out.println("To city center: "+a[0]);
        d = Double.parseDouble(a[4]);
        Assert.assertTrue(d <= 10.0);
        System.out.println("To LAX: "+a[4]);
        System.out.println("-------------------------------------------");
    }
}

