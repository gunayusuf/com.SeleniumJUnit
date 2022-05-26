package screenShot_JSExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class IstenenScreenShot extends TestBase {

    @Test
    public void screenShoot() throws IOException {

        driver.get("https://github.com/gunayusuf");
        Actions actions=new Actions(driver);
        WebElement repo=driver.findElement(By.xpath("(//a[@class='UnderlineNav-item js-responsive-underlinenav-item'])[1]"));
        actions.click(repo).perform();
        WebElement seleniumRepoSS=driver.findElement(By.xpath("(//div[@class='col-10 col-lg-9 d-inline-block'])[1]"));
        File seleniumRepo=new File("target/screenShoot/seleniumRepoSS.jpeg");
        File temp=seleniumRepoSS.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp , seleniumRepo);



    }
}
