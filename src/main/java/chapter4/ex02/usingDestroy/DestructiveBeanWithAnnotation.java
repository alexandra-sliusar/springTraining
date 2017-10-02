package chapter4.ex02.usingDestroy;

import javax.annotation.PreDestroy;

/**
 * Created by Oleksandra_Sliusar on 28-Sep-17.
 */
public class DestructiveBeanWithAnnotation{
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean in " + this.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Status: " + status;
    }

}
