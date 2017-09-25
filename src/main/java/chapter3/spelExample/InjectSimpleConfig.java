package chapter3.spelExample;

import org.springframework.stereotype.Component;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
@Component
public class InjectSimpleConfig {
    public String name = "John Smith";
    public int age = 35;
    public float height = 1.78f;
    public boolean programmer = true;
    public Long ageInSeconds = 11037600001L;
}
