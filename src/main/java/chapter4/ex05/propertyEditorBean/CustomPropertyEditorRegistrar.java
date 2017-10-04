package chapter4.ex05.propertyEditorBean;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Oleksandra_Sliusar on 03-Oct-17.
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        System.out.println(registry);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        registry.registerCustomEditor(Date.class,
                new CustomDateEditor(dateFormatter, true));
        registry.registerCustomEditor(String.class,
                new StringTrimmerEditor(true));
    }
}
