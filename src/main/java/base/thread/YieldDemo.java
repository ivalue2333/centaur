package base.thread;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/2/17
 * Description:
 *  A hint to the scheduler that the current thread is willing to yield
 *  its current use of a processor. The scheduler is free to ignore this hint.
 * Modified:
 */
public class YieldDemo extends Thread{

    private String name;

    public YieldDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//        不会死循环哈，因为scheduler 可以无视这个暗示，所以A线程还是可以继续执行
        if (this.name.equals("A")) {
            Thread.yield();
        }
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        YieldDemo yd1 = new YieldDemo("A");
        YieldDemo yd2 = new YieldDemo("B");
        yd1.start();

        yd2.start();
    }
}
