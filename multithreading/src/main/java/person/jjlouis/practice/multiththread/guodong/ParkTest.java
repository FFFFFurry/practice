package person.jjlouis.practice.multiththread.guodong;

import java.util.concurrent.locks.LockSupport;

/**
 * author : jjlouis
 * time : 2018/6/2 12:43
 * function :
 * unpark有些像最大为1的信号量一样，不支持重入
 */
public class ParkTest {
    public static void main(String[] args)
    {
        Thread thread = Thread.currentThread();
        final boolean[] flag = {true};
        thread.interrupt();
        thread.interrupted();
        System.out.println("跳出循环");
        LockSupport.park();
        System.out.println("b");
        LockSupport.park();
        System.out.println("c");
    }
}
