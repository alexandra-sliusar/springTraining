package chapter4.ex09.resourceLoader;

import org.springframework.core.io.Resource;

/**
 * Created by Oleksandra_Sliusar on 05-Oct-17.
 */
public class ResourceDemo {
    public static void displayinfo(Resource res) throws Exception {
        System.out.println(res.getClass());
        System.out.println(res.getDescription());
        System.out.println("");
    }
}
