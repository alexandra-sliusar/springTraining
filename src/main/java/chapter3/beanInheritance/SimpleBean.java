package chapter3.beanInheritance;

/**
 * Created by Oleksandra_Sliusar on 26-Sep-17.
 */
public class SimpleBean {
    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Age: " + age + " name: " + name;
    }
}
