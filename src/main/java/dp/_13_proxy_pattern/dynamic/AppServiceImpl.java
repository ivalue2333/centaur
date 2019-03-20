package dp._13_proxy_pattern.dynamic;

public class AppServiceImpl implements AppService {
    public boolean createApp(String name) {  
        System.out.println("App["+name+"] has been created.");  
        return true;  
    }  
}