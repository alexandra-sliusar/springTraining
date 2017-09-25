package chapter3.lookupMethodInjection;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public abstract class AbstractLookupDemoBean implements DemoBean {

    public void operate() {
        getMyHelper().doHelp();
    }
}
