package chapter3.autowireConfig;

/**
 * Created by Oleksandra_Sliusar on 26-Sep-17.
 */
public class Target {
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {
    }

    public Target(Foo foo) {
        this.foo = foo;
        System.out.println("Target(Foo) called");
    }

    public Target(Foo foo, Bar bar) {
        this.foo = foo;
        this.bar = bar;
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo set");
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
        System.out.println("Property foo2 set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;

        System.out.println("Property bar set");
    }
}
