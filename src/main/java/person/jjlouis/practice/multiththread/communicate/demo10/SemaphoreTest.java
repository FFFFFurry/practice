package person.jjlouis.practice.multiththread.communicate.demo10;

import java.util.concurrent.Semaphore;

/**
 * author : jjlouis
 * time : 2018/5/23 23:48
 * function :
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(10);
        while (true){
            /*try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            new Thread(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "执行");
                    semaphore.release();
                }
            }).start();
        }
    }
}
