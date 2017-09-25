package chapter3.methodReplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class ReplacementRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter3/method-replacement-context.xml");
        context.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) context.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) context.getBean("standardTarget");
        System.out.println("Replaced method:");
        displayInfo(replacementTarget);
        System.out.println("Standard method:");
        displayInfo(standardTarget);
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("test");
        for (int х = 0; х < 1000000; х++) {
            target.formatMessage("foo");
        }
        stopWatch.stop();
        System.out.println("l000000 invocations took: "
                + stopWatch.getTotalTimeMillis() + " ms");
    }
}
