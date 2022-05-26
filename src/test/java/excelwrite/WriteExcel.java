package excelwrite;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class WriteExcel extends TestBase {

    @Test
    public void excelTest() throws InterruptedException, IOException {

        //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
        //seçilir.

        driver.get("https://www.n11.com/");
        //Cookieler ciktigi icin handle ettim
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
        List<WebElement> aMagazalarListesi = driver.findElements(By.xpath("(//div[@class='sellerListHolder'])[4]"));
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.createSheet("Magazalar").createRow(0).createCell(0).setCellValue("Mağazalar");

        for (int i = 0; i < aMagazalarListesi.size(); i++) {

            workbook.
                    getSheet("Magazalar").
                    createRow(i + 1).
                    createCell(0).
                    setCellValue(aMagazalarListesi.get(i).toString());
        }

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        workbook.close();
        fos.close();
        fis.close();


    }
}
