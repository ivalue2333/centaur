package base;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/3
 * Description:
 * Modified:
 */
public class GeneticDemo<T> {
    private T t;
    public void set(T t) { this.t = t; }
    public T get() { return t; }

    public static void main(String[] args) {
        GeneticDemo<String> gd = new GeneticDemo<String >();
        gd.set("abc");
        System.out.println(gd.get());

        GeneticDemo<InterfaceDemo> gd2 = new GeneticDemo<InterfaceDemo>();

        System.out.println(gd.getClass() == gd2.getClass());

        System.out.println(gd.getClass());
        System.out.println(gd.getClass().getName());
    }
}
