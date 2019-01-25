package base.block;

/**
 * Created by 13722 on 2017/9/12.
 */
public class StaticBlock {

    {
        System.out.println("StaticBlock的构造块");
    }

    static{
        System.out.println("StaticBlock的静态代码块");
    }

    public StaticBlock(){
        System.out.println("StaticBlock的构造方法");
    }

    public static void main(String[] args) {
        new StaticBlock();
    }
}
