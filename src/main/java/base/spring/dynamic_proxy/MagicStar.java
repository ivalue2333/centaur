package base.spring.dynamic_proxy;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/20
 * Description:
 * Modified:
 */
public class MagicStar implements Star{
    @Override
    public void sing() {
        System.out.println("Magic star 明星本人开始唱歌……");
    }
}
