package base.spring.dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/20
 * Description:
 * Proxy.newProxyInstance() 方法，该方法接收三个参数：
 *     第一个参数指定当前目标对象使用的类加载器,获取加载器的方法是固定的；
 *     第二个参数指定目标对象实现的接口的类型；
 *     第三个参数指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法。
 * Modified:
 */
public class JdkProxyHandler {

    /**
     * 用来接收真实明星对象
     */
    private Object realStar;

    /**
     * 通过构造方法传进来真实的明星对象
     *
     * @param star star
     */
    public JdkProxyHandler(Star star) {
        super();
        this.realStar = star;
    }

    /**
     * 给真实对象生成一个代理对象实例
     *
     * @return Object
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(realStar.getClass().getClassLoader(),
                realStar.getClass().getInterfaces(), (proxy, method, args) -> {

                    System.out.println("代理先进行谈判……");
                    // 唱歌需要明星自己来唱
                    Object object = method.invoke(realStar, args);
                    System.out.println("演出完代理去收钱……");

                    return object;
                });
    }
}
