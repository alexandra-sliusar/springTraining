package chapter4.ex01.usingInit;

/**
 * Created by Oleksandra_Sliusar on 28-Sep-17.
 */
public class SimpleBean {
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean");
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You should set property age");
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + " age: " + age;
    }
}
