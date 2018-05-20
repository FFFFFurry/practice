package person.jjlouis.practice.multiththread;

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
    private int queueSize;
    private int addIndex;
    private int removeIndex;
    private int maxsize;
    private Lock lock = new ReentrantLock();
    private Condition addCondition = lock.newCondition();
    private Condition removeCondition = lock.newCondition();


    public Queue(int size) {
        if(size < 1){
            this.obj = new Object[DEFAULT_SIZE];
        }else {
            this.obj = new Object[size];
        }

    }

    public void add(E e){

    }

    public void remove() {

    }
}
