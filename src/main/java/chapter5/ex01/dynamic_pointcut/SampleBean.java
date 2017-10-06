package chapter5.ex01.dynamic_pointcut;

/**
 * Created by Oleksandra_Sliusar on 06-Oct-17.
 */
public class SampleBean {
    public void foo(int x) {
        System.out.println("Invoked foo() with: " + x);
    }

    public void bar() {
        System.out.println("Invoked bar()");
    }
}

