package chapter4.ex07.messageSource;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Oleksandra_Sliusar on 04-Oct-17.
 */
public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("chapter4/ex07_messageSource/message-source.xml");
        ctx.refresh();
        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");
        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, czech));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"Anne",
                "Hall"}, english));
    }
}
