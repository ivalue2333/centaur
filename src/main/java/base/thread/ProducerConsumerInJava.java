package base.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/2/17
 * Description:
 *  wait就是在获得了锁的线程上，释放掉锁，直到有人notify才会去尝试获得锁
 *  notify只会通知一个正在等待的线程，notifyall会通知所有的线程，然后这些线程去竞争
 *  在notify()方法调用之后和等待线程醒来之前这段时间它可能会改变。这就是在循环中使用wait()方法效果更好的原因
 *  给共享的对象上锁,在这里是pc_queue
 * Modified:
 */
public class ProducerConsumerInJava {

    private Queue<String> pc_queue = new LinkedList<String>();

    private int max_size = 10;

    private String[] elements = {"abc", "bcd", "cde", "def"};

    private Random random = new Random();

    public ProducerConsumerInJava() {
        this.random.setSeed(1);
    }

    public static void main(String[] args) {
        ProducerConsumerInJava pc = new ProducerConsumerInJava();
        pc.run_demo();
    }

    public void run_demo() {
        Thread p = new Producer();
        Thread c = new Consumer();
        p.start();
        c.start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (pc_queue) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (pc_queue.size() == max_size) {
                        try {
                            pc_queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String c = elements[random.nextInt(4)];
                    pc_queue.add(c);
                    System.out.printf("Producer size-%d, producer-%s\n", pc_queue.size(), c);
//                    System.out.println(Thread.holdsLock(pc_queue));
                    pc_queue.notifyAll();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (pc_queue) {
                    while (pc_queue.isEmpty()) {
                        try {
                            pc_queue.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String c = pc_queue.remove();
                    System.out.printf("Consumer size-%d, consumer-%s\n", pc_queue.size(), c);
                    if (pc_queue.size() < max_size / 2) {
                        pc_queue.notifyAll();
                    }
                }
            }
        }
    }
}
