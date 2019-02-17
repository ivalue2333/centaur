package base.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/2/17
 * Description:
 * Modified:
 */
public class CyclicBarrierDemo {
    private static void runABCWhenAllReady() {
        int runner = 3;
//        cyclicBarrier.await()，减 1 并等待，直到为0
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runnerName='A'; runnerName <= 'C'; runnerName++) {
            final String rN = String.valueOf(runnerName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(rN + "is preparing for time:" + prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(rN + "is prepared, waiting for others");
                        cyclicBarrier.await(); // The current runner is ready, waiting for others to be ready
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN + "starts running"); // All the runners are ready to start running together
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        CyclicBarrierDemo.runABCWhenAllReady();
    }
}
