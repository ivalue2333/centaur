package base.spring.dynamic_proxy;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/20
 * Description:
 * Modified:
 */
public class Client {

    /**
     * 测试JDK动态代理结果
     * @param args args
     */
    public static void main(String[] args) {
        Star realStar = new MagicStar();
        // 创建一个代理对象实例
        Star proxy = (Star) new JdkProxyHandler(realStar).getProxyInstance();

        proxy.sing();
    }
}