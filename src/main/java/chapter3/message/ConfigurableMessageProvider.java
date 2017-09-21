package chapter3.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Oleksandra_Sliusar on 21-Sep-17.
 */
@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    @Autowired
    public ConfigurableMessageProvider(@Value("Hello from Annotation") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
