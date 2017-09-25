package chapter3.collectionsInjection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class CollectionKeeper {
    private Map<String, Object> map;
    private Set set;
    private List list;
    private Properties properties;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

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
