package base.spring.dynamic_proxy;

import base.spring.dynamic_proxy.Star;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/20
 * Description:
 * Modified:
 */
public class RealStar implements Star {

    @Override
    public void sing() {
        System.out.println("明星本人开始唱歌……");
    }
}
