package person.jjlouis.practice.multiththread.communicate.demo6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author : jjlouis
 * time : 2018/5/19 20:17
 * function : 使用condition重写一个有界队列 相当于实现一个简单的消费者模式
 */
public class Queue<E> {

    private final static int DEFAULT_SIZE = 16;

    private Object[] obj;
    private volatile int count;
    private volatile int addIndex;
    private volatile int removeIndex;
    private Lock lock = new ReentrantLock();
    private Condition addCondition = lock.newCondition();
    private Condition removeCondition = lock.newCondition();


    public Queue(int size) {
        if(size < 1){
            this.obj = new Object[DEFAULT_SIZE];
        }else {
            this.obj = new Object[size];
        }
        this.count = 0;
        this.addIndex = 0;
        this.removeIndex = 0;

    }

    public void add(E e){
        lock.lock();
        System.out.println(String.format(Thread.currentThread().getName() + "目前队列 add length = %s addIndex = %s ,removeIndex = %s",this.count,this.addIndex,this.removeIndex));
        while (this.count == obj.length) {
            try {
                addCondition.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        if(++ this.addIndex == this.obj.length){
            this.addIndex = 0;
        }
        this.count ++;
        removeCondition.signal();
        System.out.println(String.format(Thread.currentThread().getName() + "目前队列 add(over) length = %s addIndex = %s ,removeIndex = %s",this.count,this.addIndex,this.removeIndex));
        lock.unlock();
    }

   public void remove(){
        lock.lock();
       System.out.println(String.format(Thread.currentThread().getName() + "目前队列 remove length = %s addIndex = %s ,removeIndex = %s",this.count,this.addIndex,this.removeIndex));
        if(this.count == 0){
            try {
                removeCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count --;
        if(++this.removeIndex == this.obj.length){
            this.removeIndex = 0;
        }
        addCondition.signal();
       System.out.println(String.format(Thread.currentThread().getName() + "目前队列 remove(over) length = %s addIndex = %s ,removeIndex = %s",this.count,this.addIndex,this.removeIndex));
        lock.unlock();
   }

    public static void main(String[] args) {
        final Queue queue = new Queue(5);

        for (int j = 0; j < 6; j++) {
            new Thread(new Runnable() {
                public void run() {
                    queue.remove();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    queue.add(1);
                }
            }).start();
        }

    }
}
