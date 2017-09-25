package chapter3.constructorConfusion;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 22-Sep-17.
 */
public class ConstructorConfusion {
    private String value;

    public ConstructorConfusion(String value){
        System.out.println("ConstructorConfusion (String) called");
        this.value = value;
    }
    public  ConstructorConfusion(int value){
        System.out.println("ConstructorConfusion (int) called");
        this.value = "Number: " + Integer.toString(value);
    }

    @Override
    public String toString() {
        return value;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("chapter3/constructor-confusion-context.xml");
        ctx.refresh();
        ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
        System.out.println(cc);
    }
}
