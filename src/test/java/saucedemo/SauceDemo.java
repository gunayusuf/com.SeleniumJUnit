package saucedemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SauceDemo extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna "standard_user" yazdirin
        //3. Password kutusuna "secret_sauce" yazdirin
        //4. Login tusuna basin
        Actions actions = new Actions(driver);
        WebElement usernameKutusu = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement loginTusu = driver.findElement(By.xpath("//input[@type='submit']"));
        actions.click(usernameKutusu)
                .sendKeys("standard_user" + Keys.TAB)
                .sendKeys("secret_sauce")
                .click(loginTusu)
                .perform();
        Thread.sleep(2000);
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunİsmi=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        ilkUrunİsmi.click();
        String ilkUrununİsmi="SauceLabsBackPack";
        Thread.sleep(1000);
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_badge")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement eklendiMi=driver.findElement(By.xpath("//div[@class='cart_item_label']"));
        Assert.assertTrue(eklendiMi.isDisplayed());
        //9. Sayfayi kapatin
        Thread.sleep(2000);

        driver.close();

    }
}
