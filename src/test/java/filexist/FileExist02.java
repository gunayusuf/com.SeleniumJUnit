package filexist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExist02 {


    @Test
    public void test01() {
        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmemiz icin once o dosyaya
        Ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna(path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan masaustu dosya yolu da
        birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DİNAMİK yapmak zorundayiz!!!

        Bunun icin
        Her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        */
        String farkliKisim= System.getProperty("user.home");
        System.out.println(farkliKisim);
        //Herkesin bilgisayarinda ortak olan kisim ise soyledir;
        String ortakKisim="\\OneDrive\\Masaüstü\\text.txt";
        System.out.println(ortakKisim);

        String masaustuDosyaYolu=farkliKisim+ortakKisim ;
        System.out.println(masaustuDosyaYolu);
        //C:\Users\gunay\OneDrive\Masaüstü\text.txt

        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu)));
        // true veya false dondurur, unutulmamasi gereken Files class'i ve Paths classi

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

    }
}
