package base.dp;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/2/17
 * Description:
 *  静态内部类的单例模式的实现是我推荐的
 *  在加载Singleton类时，不会加载内部类SingletonHolder。
 *  直到调用getInstance()才会加载SingletonHolder
 *  Singleton 类被装载了，instance 不一定被初始化
 *
 *  双检查存在的问题，一是实现较为复杂
 *  二是
 *  在类的加载机制的步骤中，加载，链接（验证，准备，解析）（给对象设置默认值），初始化
 *  所以可能线程A在链接时给instance一个默认值（此时instance就不是null了），
 *  线程B优先准备的话，那么返回的对象是一个默认值的对象，显然是不对的
 *
 *  加载阶段：就是在硬盘上寻找java文件对应的class文件，
 *  并将class文件中的二进制数据加载到内存中，将其放在运行期数据区的方法区中去，
 *  然后在堆区创建一个java.lang.Class对象，用来封装在方法区内的数据结构；
 *  连接阶段：这个阶段分为三个步骤，
 *  步骤一：验证，验证什么呢？当然是验证这个class文件里面的二进制数据是否符合java规范咯；
 *  步骤二：准备，为该类的静态变量分配内存空间，并将变量赋一个默认值，比如int的默认值为0；
 *  步骤三：解析，这个阶段就不好解释了，将符号引用转化为直接引用，涉及到指针，这里不做多的解释；
 *  初始化阶段：当我们主动调用该类的时候，将该类的变量赋于正确的值(这里不要和第二阶段的准备混淆了)
 *  ，举个例子说明下两个区别，比如一个类里有private static int i = 5;
 *  这个静态变量在"准备"阶段会被分配一个内存空间并且被赋予一个默认值0，
 *  当道到初始化阶段的时候会将这个变量赋予正确的值即5，了解了吧！
 *  https://ranji13-163-com.iteye.com/blog/902155
 * Modified:
 */
public class Singleton {
    private static class SingletonHolder {
        private static Singleton INSTANCE = new Singleton();
    }
    private Singleton() {}
    public Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
