 package person.jjlouis.practice.multiththread.communicate;

/**
 * author : jjlouis
 * time : 2018/5/19 20:42
 * function : 实现线程间通讯 通过共享主线程变量的方式
 */
public class Demo3 {

    private volatile int single;

    public void set(int value){
        this.single = value;
    }

    public int get(){
        return this.single;
    }

    public static void main(String[] args) {
        final Demo3 main = new Demo3();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("修改状态线程执行...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.set(1);
                System.out.println("修改状态线程执行完成...");
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (main.get() != 1){
                    try {
                        Thread.sleep(1000);
                        System.out.println("检查了下值是否为1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("模拟代码执行...");
            }
        }).start();

    }
}
