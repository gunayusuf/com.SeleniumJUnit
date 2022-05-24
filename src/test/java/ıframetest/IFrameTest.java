package ıframetest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class IFrameTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        Thread.sleep(3000);
        // videoyu calistirdiginizi test edin

        WebElement isdisplayed=driver.findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']"));
        Assert.assertTrue(isdisplayed.isDisplayed());

        Thread.sleep(5000);

    }
}
