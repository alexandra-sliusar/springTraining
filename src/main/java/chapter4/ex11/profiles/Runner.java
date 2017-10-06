package chapter4.ex11.profiles;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by Oleksandra_Sliusar on 05-Oct-17.
 */
public class Runner {
    public static void main(String[] args) {

       // System.setProperty("spring.profiles.active", "kindergarten");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("school");
        context.load("chapter4/ex11.profiles/*.xml");
        context.refresh();
        FoodProviderService foodProviderService =
                (FoodProviderService) context.getBean("foodProviderService");
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }
    }
}
