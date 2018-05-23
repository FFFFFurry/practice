package person.jjlouis.practice.multiththread.communicate.demo10;

import java.util.concurrent.CountDownLatch;

/**
 * author : jjlouis
 * time : 2018/5/23 22:57
 * function :
 */
public class CountDownLatchTest {
    private final static int[][] numbers = {
        {1,2,3,4,5,90},
        {2,3,4,5,2,5},
        {3,4,5,23,23},
    };


    private int[] result = new int[3];

    public void cal(int index){
        int total = 0;
        for(int n : numbers[index]){
            total +=n;
        }
        System.out.println(Thread.currentThread() + "计算结果：" + total);
        result[index] = total;
    }

    public int sum(){
        int total = 0;
        for(int n : result){
            total +=n;
        }
        return total;
    }

    public static void main(String[] args) {
        final CountDownLatchTest demo = new CountDownLatchTest();
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        for(int i = 0;i < 3;i++){
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    demo.cal(finalI);
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo.sum());
    }
}
