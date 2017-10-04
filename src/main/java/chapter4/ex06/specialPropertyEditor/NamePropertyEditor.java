package chapter4.ex06.specialPropertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * Created by Oleksandra_Sliusar on 04-Oct-17.
 */
public class NamePropertyEditor extends PropertyEditorSupport {
    public void setAsText(String text) throws IllegalArgumentException {

        String[] name = text.split("\\s");
        setValue(new Name(name[0], name[1]));
    }
}
