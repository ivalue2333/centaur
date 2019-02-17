package base.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/2/17
 * Description:
 * Modified:
 */
public class CountDownLatchDemo {
    private static void runDAfterABC() {
        int worker = 3;
//        countDownLatch.countDown();使得计数减一
//        countDownLatch.await();等待直到countDownLatch 减为0
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("All done, D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (char threadName='A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + "is working");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + "finished");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        CountDownLatchDemo.runDAfterABC();
    }
}
