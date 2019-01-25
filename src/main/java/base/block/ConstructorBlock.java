package base.block;

/**
 * Created by 13722 on 2017/9/12.
 */
class ConstructorBlock{

    {
        System.out.println("第一代码块");
    }

    public ConstructorBlock(){
        System.out.println("构造方法");
    }

    {
        System.out.println("第二构造块");
    }
    public static void main(String[] args){
        new ConstructorBlock();
    }
}

