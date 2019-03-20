package dp._03_singleton_pattern._4;

public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {};

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}