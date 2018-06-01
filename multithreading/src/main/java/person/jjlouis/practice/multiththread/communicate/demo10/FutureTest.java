package person.jjlouis.practice.multiththread.communicate.demo10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 作者：jjlouis
 * 时间：2018/5/24 10:55
 * 联系方式：
 * 功能：
 **/
public class FutureTest {

    public int a(){
        System.out.println("开始执行a方法...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行a方法结束...");
        return 1;
    }

    public static void main(String[] args) {
        final FutureTest test = new FutureTest();
        Callable call = new Callable() {
            public Integer call() throws Exception {
                return test.a();
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(call);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("干些别的东西...");
        try {
            Integer result = futureTask.get();
            Thread.sleep(5000);
            System.out.println("获取到数值" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
