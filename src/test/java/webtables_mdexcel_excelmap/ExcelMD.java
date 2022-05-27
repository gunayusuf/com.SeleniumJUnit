package webtables_mdexcel_excelmap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelMD {


    @Test
    public void readExcelTest() throws IOException {

        //Soru: Ulkeler.xlsx dosyasını MD Array'e aktaralım.

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // 1. adim: satir sayisini bul
        int satirsayisi = workbook.getSheet("Sayfa1").getLastRowNum() + 1;

        //2. adim : sutun sayisini bul

        Row row = workbook.getSheet("Sayfa1").getRow(0);
        int sutunSayisi = row.getLastCellNum();

        System.out.println("satir sayisi : " + satirsayisi);
        System.out.println("sutun sayisi : " + sutunSayisi);

        //3. adim : md array oluştur ve excel'deki verileri teker teker at.

        String[][] ulkelerArrayMd = new String[satirsayisi][sutunSayisi];
        for (int i = 0; i < satirsayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                ulkelerArrayMd[i][j] = workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString();
            }
        }

        //4. adim: md array'i printf ile yazdir.

        for (int i = 0; i < satirsayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                System.out.printf("%-50s", ulkelerArrayMd[i][j]);
            }
            if (i == 0) {
                System.out.println();
                System.out.println("===============================================================" +
                        "===========================================================================");
            } else {
                System.out.println();
            }
        }

        //Soru: Afghanistan'ın türkçe başkent ismi nedir?
        for (int i = 0; i < satirsayisi; i++) {
            if (ulkelerArrayMd[i][0].equals("Afghanistan")) {
                System.out.println("Turkce baskent: " + ulkelerArrayMd[i][3]);
            }
        }


    }


}
