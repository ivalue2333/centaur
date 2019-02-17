package base.thread;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/2/17
 * Description:
 *  join 让调用 线程 t 的线程（在这里是主线程啦）wait，直到t调用自己的notifyall，
 *  然后主线程又可以开始运行了
 *  将线程t看做是主线程的一个object，然后主线程调用了自己的 t.wait()
 * Modified:
 */
public class JoinDemo implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " end");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new JoinDemo());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " end");
    }
}
