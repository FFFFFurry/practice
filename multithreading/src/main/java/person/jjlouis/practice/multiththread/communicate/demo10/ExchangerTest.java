package person.jjlouis.practice.multiththread.communicate.demo10;

import java.util.concurrent.Exchanger;

/**
 * author : jjlouis
 * time : 2018/5/24 0:19
 * function :
 */
public class ExchangerTest {

    public void a(Exchanger<String> exchanger){
        System.out.println(Thread.currentThread().getName() + "开始执行方法");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String a ="123";
        System.out.println("已经传值");
        try {
            exchanger.exchange(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void b(Exchanger<String> exchanger){
        System.out.println(Thread.currentThread().getName() + "开始执行方法");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("等待比对");
        try {
            String a = exchanger.exchange("");
            System.out.println("123".equals(a));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Exchanger<String> demo = new Exchanger<String>();
        final ExchangerTest test = new ExchangerTest();
        new Thread(new Runnable() {
            public void run() {
                test.a(demo);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                test.b(demo);
            }
        }).start();
    }
}
