package lt.vu.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@IMethodProgressLogger
public class MethodProgressLogger implements Serializable{
    @AroundInvoke
    public Object logMethodProgress(InvocationContext context) throws Exception {
        System.out.println("Method started: " + context.getMethod().getName());
        Object result = context.proceed();
        System.out.println("Method completed: " + context.getMethod().getName());
        return result;
    }
}
