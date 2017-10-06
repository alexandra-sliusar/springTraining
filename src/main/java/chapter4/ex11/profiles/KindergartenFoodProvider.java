package chapter4.ex11.profiles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandra_Sliusar on 05-Oct-17.
 */
public class KindergartenFoodProvider implements FoodProviderService{
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));
        return lunchSet;
    }
}
