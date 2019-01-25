package base.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2018/10/31
 * Description:
 * Modified:
 */
public class ThreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo());
        System.out.println("thread run()");
        thread.run();
        System.out.println("thread start()");
        thread.start();
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
