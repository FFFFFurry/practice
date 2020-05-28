package person.jjlouis.practice.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : xiongyijie
 * @date : 2020/5/28 10:40
 * @function:
 */
public class TestThreadPool {

    public static void main(String[] args) {
        ExecutorService  pool_1 =  Executors.newFixedThreadPool(10);
        ExecutorService  pool_2 =  Executors.newFixedThreadPool(10);
        ExecutorService  pool_3 =  Executors.newFixedThreadPool(10);
        ExecutorService  pool_4 =  Executors.newFixedThreadPool(10);
        for(int i = 0;i < 10;i++){
            pool_1.submit(() -> System.out.println("Thread id = " + Thread.currentThread().getId()));
            pool_2.submit(() -> System.out.println("Thread id = " + Thread.currentThread().getId()));
            pool_3.submit(() -> System.out.println("Thread id = " + Thread.currentThread().getId()));
            pool_4.submit(() -> System.out.println("Thread id = " + Thread.currentThread().getId()));
        }
        pool_1.shutdown();
        pool_2.shutdown();
        pool_3.shutdown();
        pool_4.shutdown();
    }
}
