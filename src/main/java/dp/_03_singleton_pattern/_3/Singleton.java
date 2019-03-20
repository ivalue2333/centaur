package dp._03_singleton_pattern._3;// 使用static的类加载时赋值的特性，即基于 classloader 机制避免了多线程的同步问题
// 这种方式比较常用，但容易产生垃圾对象

public class Singleton {  
    private static Singleton instance = new Singleton();  
    private Singleton (){}  
    public static Singleton getInstance() {  
        return instance;  
    }
}