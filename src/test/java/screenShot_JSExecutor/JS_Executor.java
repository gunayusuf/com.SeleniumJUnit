package screenShot_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JS_Executor extends TestBase {

    @Test
    public void jsExecute() throws InterruptedException {

        driver.get("https://www.amazon.com.tr/");
        //Asagidaki sign in butonu gorununceye kadar scrool yapacagiz
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement signInButton = driver.findElement(By.xpath("(//span[text()='Giriş yap'])[1]"));
        Thread.sleep(2000);

        jse.executeScript("arguments[0].click();", signInButton);
        Thread.sleep(2000);
    }
}
