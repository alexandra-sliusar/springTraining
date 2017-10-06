package chapter5.ex01.dynamic_pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Oleksandra_Sliusar on 06-Oct-17.
 */
public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(">> Invoking " + invocation.getMethod().getName());
        Object result = invocation.proceed();
        System.out.println(">> Done");
        return result;
    }
}
