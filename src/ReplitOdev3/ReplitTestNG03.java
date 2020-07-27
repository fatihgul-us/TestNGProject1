package ReplitOdev3;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class ReplitTestNG03 extends utilities {

    @Test
    public void clickStar() throws InterruptedException {

        WebElement fiveStar = driver.findElement(By.id("f-label-star-rating-5"));
        fiveStar.click();

        WebElement fourStar = driver.findElement(By.id("f-label-star-rating-4"));
        fourStar.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class='hotel-wrap']")));
        List<WebElement> hotelList = driver.findElements(By.cssSelector("section[class='hotel-wrap']"));
        List<WebElement> starList = driver.findElements(By.cssSelector("span[class='star-rating-text star-rating-text-strong']"));

        while (true) {
            try {
                hotelList = driver.findElements(By.cssSelector("section[class='hotel-wrap']"));
                starList = driver.findElements(By.cssSelector("span[class='star-rating-text star-rating-text-strong']"));
                js.executeScript("arguments[0].scrollIntoView();", hotelList.get(hotelList.size() - 1));
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("section[class='hotel-wrap']"), hotelList.size()));
            } catch (TimeoutException e) {
                break;
            }
        }
        System.out.println("Number of hotels on the page: " + hotelList.size());
        System.out.println("Number of 4&5 star hotels: " + starList.size());
        SoftAssert soft = new SoftAssert();

        soft.assertEquals(hotelList.size(), starList.size(), "There are non-star hotels exist in page");

        for (int i = 0; i < starList.size(); i++) {
            System.out.println(starList.get(i).getText());
            if (starList.get(i).getText().contains("4-star"))
                Assert.assertEquals("4-star", starList.get(i).getText());
            else if (starList.get(i).getText().contains("4.5-star"))
                Assert.assertEquals("4.5-star", starList.get(i).getText());
            else if (starList.get(i).getText().contains("5-star"))
                Assert.assertEquals("5-star", starList.get(i).getText());
        }

        soft.assertAll();

    }

}

