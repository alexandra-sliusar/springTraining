package chapter4.ex05.propertyEditorBean;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * Created by Oleksandra_Sliusar on 03-Oct-17.
 */
public class Runner {
    public static void main(String[] args) throws Exception {


        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("chapter4/ex05.propertyEditorBean/property-editor-bean.xml");
        ctx.refresh();

        ctx.getBean("builtInSample");
    }
}
