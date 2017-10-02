package chapter4.ex03.digestUsingFactoryBean;

import java.security.MessageDigest;

/**
 * Created by Oleksandra_Sliusar on 28-Sep-17.
 */
public class MessageDigester {
    private MessageDigest messageDigest1;
    private MessageDigest messageDigest2;

    public void setMessageDigest1(MessageDigest messageDigest1) {
        this.messageDigest1 = messageDigest1;
    }

    public void setMessageDigest2(MessageDigest messageDigest2) {
        this.messageDigest2 = messageDigest2;
    }

    public void digest(String msg) {
        System.out.println("Using digest 1");
        digest(msg, messageDigest1);
        System.out.println("Using digest 2");
        digest(msg, messageDigest2);

    }

    private void digest(String msg, MessageDigest messageDigest) {
        System.out.println("Using alogrithm: " + messageDigest.getAlgorithm());
        messageDigest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = messageDigest.digest(bytes);
        System.out.println(new String(out));
    }
}
