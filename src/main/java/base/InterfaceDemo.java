package base;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2018/11/17
 * Description:
 * Modified:
 */
public interface InterfaceDemo {

    //接口的成员（字段 + 方法）默认都是 public 的，并且不允许定义为 private 或者 protected。
    //接口的字段默认都是 static 和 final 的。

    void func1();

// default 字段只能在interface 中使用，也就意味着他和public, private这些修饰符根本就是两个东西
    public default void func2(){
        System.out.println("func2");
    }

//    以下public被省略了
    default void func3() {
        System.out.println("func3");
    }

    int x = 123;
    // int y;               // Variable 'y' might not have been initialized
    public  int z = 0;       // Modifier 'public' is redundant for interface fields

    public static void main(String[] args) {
        System.out.println(1);
    }
}
