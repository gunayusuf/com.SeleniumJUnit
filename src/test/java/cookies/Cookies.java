package cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {


    @Test
    public void cookies() {
        // 1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com.tr/");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieListesi=driver.manage().getCookies();
        System.out.println(cookieListesi);
        int cookieSayi=0;
        for (Cookie each:cookieListesi
             ) {
            System.out.println("cookie name : " + each.getName());
            System.out.println("cookie value : " + each.getValue());
            System.out.println(cookieSayi+" .ci cookie :"+ each);
            cookieSayi++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi=cookieListesi.size();
        Assert.assertFalse(cookieSayisi>5);
        //4- ismi i18n-prefs olan cookie name degerinin TRY oldugunu test edin
        for (Cookie each:cookieListesi
             ) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("TRY",each.getValue());
            }

        }

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan
        // bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        cookieSayi=1;
        cookieListesi=driver.manage().getCookies();
        for (Cookie each:cookieListesi
        ) {
            System.out.println("cookie name : " + each.getName());

            cookieSayi++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookieListesi.contains(cookie));


        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieListesi.contains("skin"));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Assert.assertFalse(cookieListesi.isEmpty());
        Set<Cookie> yeniCookie=driver.manage().getCookies();
        for (Cookie each:yeniCookie
             ) {
            System.out.println(each);
        }

    }
}
