package filexist;

import org.junit.Test;

public class FileExist {

    @Test
    public void test01() {

        System.out.println("user.dir"+System.getProperty("user.dir"));
        // icerisinde bulundugum projenin dosya yolunu veriyor.
        //C:\Users\gunay\IdeaProjects\com_Selenium

        System.out.println("user.home : "+System.getProperty("user.home"));
        // C:\Users\gunay

        System.out.println("os.name : "+System.getProperty("os.name"));
        // işletim sistemini veriyor

        System.out.println("os.arch : "+System.getProperty("os.arch"));

        System.out.println("os.version :"+System.getProperty("os.version"));

        System.out.println("java.runtime.version : "+System.getProperty("java.runtime.version"));
        // 11.0.15+9-LTS java version


        System.out.println("Name : "+System.getProperty("name"));

        System.out.println("path.separator : "+System.getProperty("path.separator"));
        System.out.println("file.seperator : "+System.getProperty("file.separator"));

        System.out.println("Java.ext.drs :"+System.getProperty("java.ext.dirs"));

        System.out.println("Java.vm.name : " +System.getProperty("java.vm.name"));

        System.out.println("Java.vm.version : " +System.getProperty("java.vm.version"));

        System.out.println("Java.home : " +System.getProperty("java.home"));

        System.out.println("java.library.path : " +System.getProperty("java.library.path"));



    }
}
