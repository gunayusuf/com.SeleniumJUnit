package webtables_mdexcel_excelmap;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExcelMap {
    @Test
    public void readExcelTest() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum() + 1;

        //kullanilan sutun sayisini bulmak icin ilk satiri hucre hucre gezip " " boş hucre bulunca sutun sayisi elde ederiz.
        int sutunSayisi = 0;
        try {
            while (true) {
                if (workbook.getSheet("Sayfa1").getRow(0).getCell(sutunSayisi).toString().equals(" ")) {
                    break;
                } else {
                    sutunSayisi++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("satır sonuna gelindi."); // null pointer exception firlatmasini onlemek icin
        }

        System.out.println("Satir sayisi : " + satirSayisi); //satir sayisi
        System.out.println("Sutun sayisi : " + sutunSayisi); //sutun sayisi

        Map<Integer, String> ulkelerMap = new HashMap<>();

        String values;
        for (int i = 0; i < satirSayisi; i++) {
            values = "";
            for (int j = 0; j < sutunSayisi; j++) {
                values += workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString() + ",";
            }
            ulkelerMap.put(i, values);
        }

        for (Integer each:ulkelerMap.keySet()) {
            String[] valuesArray = ulkelerMap.get(each).split(",");
            System.out.print(each + " : ");
            System.out.print(Arrays.deepToString(valuesArray));
            System.out.println();
        }

        //Afganistan'ın Türkçe başkent ismi nedir ?

        for (String each:ulkelerMap.values()) {
            String[] valuesArray = each.split(",");
            if (valuesArray[0].equals("Afghanistan")) {
                System.out.println("Türkçe Başkenti: " + valuesArray[3]);
            }
        }
    }




}
