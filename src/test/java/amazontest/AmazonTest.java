package amazontest;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class  AmazonTest extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        //amazon anasayfaya gidip Faker ile
        driver.get("https://www.amazon.com.tr/");
        // hesap ve listeler kısmından uye olun kismina tiklayin
        WebElement hesapveListeButon=driver.findElement(By.xpath("//*[text()='Hesap ve Listeler']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hesapveListeButon).perform();
        driver.findElement(By.xpath("(//a[@rel='nofollow'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='ap_customer_name']")).click();
        WebElement amazonTik=driver.findElement(By.xpath("//input[@type='checkbox']"));
        Faker faker=new Faker();
        String fakePassword=faker.internet().password();
        actions
                .sendKeys(faker.name().firstName())
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .click(amazonTik)
                .sendKeys(Keys.ENTER)
                .perform();





        Thread.sleep(6000);
    }
}
