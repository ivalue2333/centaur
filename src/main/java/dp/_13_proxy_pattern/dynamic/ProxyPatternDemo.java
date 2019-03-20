package dp._13_proxy_pattern.dynamic;

import java.lang.reflect.Proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {  
        AppService target = new AppServiceImpl();//生成目标对象  
        //接下来创建代理对象  
        AppService proxy = (AppService) Proxy.newProxyInstance(  
                target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), new LoggerInterceptor(target));  
        proxy.createApp("percy app");  
    }  
}