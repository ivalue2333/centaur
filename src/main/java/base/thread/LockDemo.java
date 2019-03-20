package base.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/3
 * Description:
 * Modified:
 */
public class LockDemo {

    public void test1() {
        Lock lock = new ReentrantLock();
    }

    public void test2() {
        ReadWriteLock rwl = new ReentrantReadWriteLock();
        rwl.readLock().lock();
        try {
            System.out.println(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            rwl.readLock().unlock();
        }
    }

    public static void main(String[] args) {

    }
}
