package screenShot_JSExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TumSayfaScreenShot extends TestBase {


    @Test
    public void screenShotTest() throws IOException {

        driver.get("https://github.com/gunayusuf");

        TakesScreenshot screenshot= (TakesScreenshot) driver;

        LocalDateTime date=LocalDateTime.now();
        System.out.println(date);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);
        System.out.println(tarih);

        File tumsayfaResim=new File("target/screenShoot/tumSayfa"+tarih+".jpeg");

        File geciciDosya=screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,tumsayfaResim);

    }
}
