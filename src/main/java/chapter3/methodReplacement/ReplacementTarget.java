package chapter3.methodReplacement;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class ReplacementTarget {

    public String formatMessage(String msg)
    {
        return "<h1>" +msg + "</msg>";
    }
    public String formatMessage(Object msg)
    {
        return "<h1>" +msg + "</msg>";
    }
}
