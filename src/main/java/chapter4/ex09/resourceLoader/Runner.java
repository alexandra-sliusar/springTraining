package chapter4.ex09.resourceLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;

import static chapter4.ex09.resourceLoader.ResourceDemo.displayinfo;

/**
 * Created by Oleksandra_Sliusar on 05-Oct-17.
 */
public class Runner {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();
        System.out.println(file.getPath());
        Resource res1 = ctx.getResource("file:///" + file.getPath());
        System.out.println("Res1: ");
        displayinfo(res1);
       Resource res2 = ctx.getResource("classpath:test.txt");
        System.out.println("Res2: ");
        displayinfo(res2);
        Resource res3 = ctx.getResource("http://www.google.com");
        System.out.println("Res3: ");
        displayinfo(res3);
    }
}
