package chapter3.message;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 21-Sep-17.
 */
public class AppWithAnnotationsAndXml {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx1 = new GenericXmlApplicationContext();
        ctx1.load("chapter3/messageContext/app-context-xml.xml");
        ctx1.refresh();
        MessageRenderer messageRenderer = ctx1.getBean ("messageRenderer", MessageRenderer.class);
        messageRenderer.render();

        GenericXmlApplicationContext ctx2 = new GenericXmlApplicationContext();
        ctx2.load("chapter3/messageContext/app-context-annotation.xml");
        ctx2.refresh();
        messageRenderer = ctx2.getBean ("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
