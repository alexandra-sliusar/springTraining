package chapter4.ex02.usingDestroy;

import org.springframework.beans.factory.DisposableBean;

/**
 * Created by Oleksandra_Sliusar on 28-Sep-17.
 */
public class DestructiveBeanWithInterface implements DisposableBean {
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void destroy() {
        System.out.println("Destroying Bean with Interface in " + this.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Status: " + status;
    }

}
