package interseptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        System.out.println("Method: " + ic.getMethod().getName() + " in class " + ic.getTarget().getClass().toString() + " start");
        return ic.proceed();
    }
}