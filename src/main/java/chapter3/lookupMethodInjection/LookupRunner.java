package chapter3.lookupMethodInjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class LookupRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("chapter3/lookupMethodInjection/lookup-method-context.xml");
        ctx.refresh();
        DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean");
        System.out.println("For standard bean:");
        displayInfo(standardBean);
        System.out.println("For abstract bean:");
        displayInfo(abstractBean);
    }

    private static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();
        System.out.println("Helper Instances the Same?: "
                + (helper1 == helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int х = 0; х < 100000; х++) {
            MyHelper helper = bean.getMyHelper();
            helper.doHelp();
        }
        stopWatch.stop();
        System.out.println("100000 gets took "
                + stopWatch.getTotalTimeMillis() + " ms");

    }
}
