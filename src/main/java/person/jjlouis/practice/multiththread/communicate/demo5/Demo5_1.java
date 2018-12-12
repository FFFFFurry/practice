package person.jjlouis.practice.multiththread.communicate.demo5;

import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author : jjlouis
 * time : 2018/5/20 10:44
 * function :多线程交替执行 1,2,3
 */
public class Demo5_1 {

    private volatile int signal = 1;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public  void a(){
        lock.lock();
        while (signal != 1){
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.signal);
        this.signal ++ ;
        b.signal();
        lock.unlock();
    }

    public synchronized void b(){
        lock.lock();
        while (signal != 2){
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.signal);
        this.signal ++ ;
        c.signal();
        lock.unlock();
    }

    public synchronized void c(){
        lock.lock();
        while (signal != 3){
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.signal);
        this.signal = 1 ;
        a.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo5 demo = new Demo5();
        int count = 10;
        while (count > 0){
            new Thread(new A(demo)).start();
            new Thread(new B(demo)).start();
            new Thread(new C(demo)).start();
            count --;
        }

    }
}

