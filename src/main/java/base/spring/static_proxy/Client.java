package base.spring.static_proxy;

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
     * 测试静态代理结果
     * @param args args
     */
    public static void main(String[] args) {
        Star realStar = new RealStar();
        Star proxy = new ProxyStar(realStar);

        proxy.sing();
    }
}