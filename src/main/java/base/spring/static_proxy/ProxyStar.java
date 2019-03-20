package base.spring.static_proxy;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/20
 * Description:
 * Modified:
 */
public class ProxyStar implements Star {

    /**
     * 接收真实的明星对象
     */
    private Star star;

    /**
     * 通过构造方法传进来真实的明星对象
     * @param star star
     */
    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("代理先进行谈判……");
        // 唱歌只能明星自己唱
        this.star.sing();
        System.out.println("演出完代理去收钱……");
    }

}
