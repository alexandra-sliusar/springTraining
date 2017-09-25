package chapter3.lookupMethodInjection;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class StandardLookupDemoBean implements DemoBean {
    private MyHelper myHelper;

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    public MyHelper getMyHelper() {
        return this.myHelper;
    }

    public void operate() {
        myHelper.doHelp();
    }
}
