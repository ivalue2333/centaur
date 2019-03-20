package base.thread;

import java.util.concurrent.*;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2018/10/29
 * Description:
 * Modified:
 */
public class RunnableDemo implements Runnable {



    public void run() {
        System.out.println(Thread.currentThread().getName() + "运行开始");
        for(int i = 0; i < 1; i++)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + "正在运行");
                Thread.sleep(200);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

//    ScheduledThreadPool示例
    private static void scheduledThreadPoolTest() {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        RunnableDemo runner = new RunnableDemo();

        final ScheduledFuture<?> handler1 = scheduler.scheduleAtFixedRate(runner, 1, 10, TimeUnit.SECONDS);
        final ScheduledFuture<?> handler2 = scheduler.scheduleWithFixedDelay(runner, 2, 10, TimeUnit.SECONDS);

        scheduler.schedule(new Runnable()
                           {
                               public void run()
                               {
                                   handler1.cancel(true);
                                   handler2.cancel(true);
                                   scheduler.shutdown();
                               }
                           }, 30, TimeUnit.SECONDS
        );
    }

    private static void scheduledThreadPoolTest1(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new RunnableDemo(), 2, 3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();
    }

//    cache pool 示例
    private static void cachedThreadPoolTest() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 50; i++)
        {
            RunnableDemo runner = new RunnableDemo();
            exec.execute(runner);
        }
        exec.shutdown();
    }

    private static void newSingleThreadExecutorTest() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++) {
            RunnableDemo runner = new RunnableDemo();
            exec.execute(runner);
        }
        exec.shutdown();
    }

    private static void newFixedThreadPoolTest() {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 5; i++)
        {
            RunnableDemo runner = new RunnableDemo();
            exec.execute(runner);
        }
        exec.shutdown();
    }


    public static void main(String[] args) {
//        RunnableDemo.scheduledThreadPoolTest();
        RunnableDemo.scheduledThreadPoolTest1();
//        RunnableDemo.cachedThreadPoolTest();
//        RunnableDemo.newSingleThreadExecutorTest();
    }
}
