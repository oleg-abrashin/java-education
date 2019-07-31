package application;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.time.LocalTime;
import java.util.concurrent.*;

public class ExecutorsApp {

    private static final int NUM_TASK = 100;
    private static final long THREAD_DELAY = 1;
    private static int i;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(100);

//        executor.execute(()->{
//                    try {
//                        System.out.println("i= "+i);
//                        Thread.sleep(5000);
//                        i++;
//                    } catch (InterruptedException e) {
//                        //throw new RuntimeException("Unexpected interrupt =",e);
//                        System.out.println("InterruptedException ="+e);
//                    }
//
//                    System.out.println("THREAD");
//                });
//
//        executor.shutdownNow();

        //executor.execute(()->{});

//        for (int j = 0; j < NUM_TASK; j++) {
//                executor.execute(()-> {
//
//                    try {
//                        Thread.sleep(THREAD_DELAY);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println("InterruptedException ="+e);
//                    }
//
//                    System.out.println(Thread.currentThread().getId());
//
//
//                });
//
//        }
        //executor.shutdown();

//        Future<String> future = executor.submit(
//                () -> {
//                    try {
//                        Thread.sleep(THREAD_DELAY);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println("InterruptedException e=" + e);
//                    }
//                    return "future "+Thread.currentThread().getId();
//                }
//        );

        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
//        scheduled.schedule(()-> System.out.println("Sasha is great!"),1,TimeUnit.SECONDS);
//        scheduled.scheduleAtFixedRate(()->{
//            System.out.println(LocalTime.now());
//        },1L,1L,TimeUnit.SECONDS);
//        System.out.println(future.get());
//        scheduled.shutdown();

//        scheduled.scheduleAtFixedRate(()->{
//            System.out.println("74=" +LocalTime.now());
//        },1L,1L,TimeUnit.SECONDS);

        scheduled.scheduleWithFixedDelay(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("InterruptedException e=" + e);
            }
            System.out.println(LocalTime.now());
        },1L,1L,TimeUnit.SECONDS);

        System.out.println("main");


    }
}
