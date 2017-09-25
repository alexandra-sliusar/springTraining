package chapter3.collectionsInjection;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */

@Service
public class CollectionAnnotationKeeper {

    @Resource
    private Map<String, Object> map;
    @Resource
    private Set set;
    @Resource
    private List list;
    @Resource
    private Properties properties;


    public void displayInfo() {
        System.out.println("Map contents:\n");
        for (Map.Entry<String, Object> entry : map.entrySet())
            System.out.println("Key: " + entry.getKey() + " - Value: "
                    + entry.getValue());

        System.out.println("\nProperties contents:\n");
        for (Map.Entry<Object, Object> entry : properties.entrySet())
            System.out.println("Key: " + entry.getKey() + " - Value: "
                    + entry.getValue());

        System.out.println("\nSet contents:\n");
        for (Object obj : set)
            System.out.println("Value: " + obj);


        System.out.println("\nList contents:\n");
        for (Object obj : list) {
            System.out.println("Value: " + obj);
        }
    }
}
