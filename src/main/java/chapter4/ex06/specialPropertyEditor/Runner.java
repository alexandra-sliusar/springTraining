package chapter4.ex06.specialPropertyEditor;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 04-Oct-17.
 */
public class Runner {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("chapter4/ex06.specialPropertyEditor/name-property-editor.xml");
        ctx.refresh();
        CustomEditorExample bean =
                (CustomEditorExample) ctx.getBean("exampleBean");
        System.out.println(bean.getName());
    }
}
