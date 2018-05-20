package person.jjlouis.practice.multiththread.communicate.demo4;

import java.lang.annotation.Target;

/**
 * author : jjlouis
 * time : 2018/5/20 10:15
 * function :
 */
public class Demo4 {

    private volatile int singal;

    public synchronized void set(){
        System.out.println(Thread.currentThread().getName() + "开始执行set方法");
        this.singal = 1;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "开始执行set结束");
    }

    public synchronized int get(){
        System.out.println(Thread.currentThread().getName() + "开始执行get方法");
       if(singal != 1){
           try {
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       System.out.println(Thread.currentThread().getName() + "开始执行get方法结束");
       return this.singal;
    }


    public static void main(String[] args) {
        Demo4 demo = new Demo4();

        SetTarget set1 = new SetTarget(demo);
        new Thread(set1).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        GetTarget get1 = new GetTarget(demo);
        GetTarget get2 = new GetTarget(demo);
        GetTarget get3 = new GetTarget(demo);
        GetTarget get4 = new GetTarget(demo);

        new Thread(get1).start();
        new Thread(get2).start();
        new Thread(get3).start();
        new Thread(get4).start();


    }



}
