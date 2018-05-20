package person.jjlouis.practice.multiththread.communicate;

/**
 * author : jjlouis
 * time : 2018/5/19 20:42
 * function : 实现线程间通讯 通过wait/notify实现这套机制
 *
 */
public class Demo2 {

    private volatile int single;

    public void set(int value){
        this.single = value;
    }

    public int get(){
        return this.single;
    }

    public static void main(String[] args) {
        final Demo2 main = new Demo2();

        new Thread(new Runnable() {
            public void run() {
                synchronized (main){
                    System.out.println("开始执行模拟代码...");
                    while (main.get() != 1){
                        try {
                            main.wait(); //拿到main内置锁的线程挂起 释放内置锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("模拟代码 获取value成功...");
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {

                synchronized (main){
                    System.out.println("修改状态线程执行...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    main.set(1);
                    main.notify();//通知需要main内置锁被挂起的线程，竞争获得锁继续执行剩下的指令
                    System.out.println("修改状态线程执行完成...");
                }

            }
        }).start();



    }
}
