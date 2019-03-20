package dp._13_proxy_pattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 注意需实现Handler接口  
 */
public class LoggerInterceptor implements InvocationHandler {
  //目标对象的引用，这里设计成Object类型，更具通用性  
    private Object target;
    public LoggerInterceptor(Object target){  
        this.target = target;  
    }
    
    public Object invoke(Object proxy, Method method, Object[] arg)  throws Throwable {  
        System.out.println("Entered class is "+target.getClass().getName()+" - "+method.getName()+",with arguments{"+arg[0]+"}");
        // 调用目标对象的方法  
        Object result = method.invoke(target, arg);
        System.out.println("Before return:"+result);  
        return result;  
    }  
}  