package filexist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // dummy.txt dosyasını indirelim
        WebElement dummyDosya=driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        dummyDosya.click();
        Thread.sleep(5000);
        // dosyanın başarıyla indirilip indirilmediğini test edelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="C:\\Users\\gunay\\OneDrive\\Downloads\\dummy.txt";

        String ArananDosyaPath=farkliKisim+ortakKisim;

        // dosya download'a indirilecektir, bize downloads'in dosya yolu(path) lazim
        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim

        Assert.assertTrue(Files.exists(Paths.get(ArananDosyaPath)));


    }
}
