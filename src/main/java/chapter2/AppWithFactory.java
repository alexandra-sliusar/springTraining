package chapter2;

public class AppWithFactory {
    public static void main(String[] args) {
        MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
        MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
