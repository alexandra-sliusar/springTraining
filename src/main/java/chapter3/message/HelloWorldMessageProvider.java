package chapter3.message;

//@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "hello world!";
    }
}
