package base.reflect;

import java.lang.reflect.Method;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/3
 * Description:
 * Modified:
 */
public class ReflectDemo {


    public static void main(String[] args) throws Exception {
//        Class<?> klass = int.class;
//        Class<?> classInt = Integer.TYPE;
//
//        //获取String所对应的Class对象
//        Class<?> c = String.class;
//        //获取String类带一个String参数的构造器
//        Constructor constructor = c.getConstructor(String.class);
//        //根据构造器创建实例
//        Object obj = constructor.newInstance("23333");
//        System.out.println(obj);

//        下面两个方法都可以
        Class<?> klass = Class.forName("base.reflect.methodClass");
//        Class<?> klass = methodClass.class

        //创建methodClass的实例
        Object obj = klass.newInstance();
        //获取methodClass类的add方法
        Method method = klass.getMethod("add",int.class,int.class);
        //调用method对应的方法 => add(1,4)
        Object result = method.invoke(obj,1,4);
        System.out.println(result);

    }
}

class methodClass {
    public final int fuck = 3;
    public int add(int a,int b) {
        return a+b;
    }
    public int sub(int a,int b) {
        return a+b;
    }
}


