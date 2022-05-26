package writeText;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class WriteText extends TestBase {

    @Test
    public void excelTest() throws InterruptedException, IOException {

        //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
        //seçilir.

        driver.get("https://www.n11.com/");

        driver.findElement(By.xpath("//div[@class='btn btnBlack btnBlack-loc-info']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]")).click();

        Actions actions = new Actions(driver);
        WebElement magazalarElementi = driver.findElement(By.xpath("//span[@title='Mağazalar']"));
        WebElement magazalariGorElementi = driver.findElement(By.xpath("//a[@title='Mağazaları Gör']"));
        actions.moveToElement(magazalarElementi).perform();
        actions.click(magazalariGorElementi).perform();


        //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
        //txt dosyasına yazdırılır.
        WebElement tumMagazalarButon = driver.findElement(By.xpath("//h3[text()='Tüm Mağazalar']"));
        actions.click(tumMagazalarButon).perform();

        String dosyaYolu = "src/resources/magazalartext.txt";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        WebElement aMagazalar = driver.findElement(By.xpath("(//ul)[24]")); //magazlarin oldugu bolge secildi
        String aMagazalarListesi = aMagazalar.getText(); //secilen magazalar string'e atandi
        System.out.println(aMagazalarListesi); // yazdirdigini gormek icin denedim

        File file = new File("src/resources/magazalar2.txt"); //magazalar2 isminde bir txt dosyasi olusturur
        FileUtils.writeStringToFile(file, aMagazalarListesi, Charset.defaultCharset());
        //FileUtils.writeStringToFile(file name, yazilarin oldugu string ifade, Charset.defaultCharset());
        //defaultCharset()= which returns the charset object for the default charset.
    }
    }

