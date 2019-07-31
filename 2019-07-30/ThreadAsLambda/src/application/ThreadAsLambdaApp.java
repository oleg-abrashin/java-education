package application;

public class ThreadAsLambdaApp {

    public static void main(String[] args) {

       new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) { }
            System.out.println("thread");
        }).start();

        System.out.println("main");

    }
}
