package person.jjlouis.practice.multiththread.communicate.demo10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * author : jjlouis
 * time : 2018/5/23 23:38
 * function :
 */
public class CyclicBarrierTest {

    public void meeting(CyclicBarrier cyclicBarrier){
        System.out.println(Thread.currentThread() + "正在往会议室赶...");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "发言");
    }

    public static void main(String[] args) {
        final CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        System.out.println("开始");
        for(int i = 0 ;i< 20 ;i++){
            new Thread(new Runnable() {
                public void run() {
                    cyclicBarrierTest.meeting(cyclicBarrier);
                }
            }).start();
        }
    }
}
