package person.jjlouis.practice.multiththread.communicate.demo9;

/**
 * author : jjlouis
 * time : 2018/5/21 23:44
 * function : Thread local 原理
 */
public class ThreadLocalTest {

    private ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNext(){
        Integer value = count.get();
        value += 1;
        count.set(value);
        return value;

    }

    public static void main(String[] args) {
        final ThreadLocalTest demo = new ThreadLocalTest();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0;i < 3;i++){
            new Thread(new Runnable() {
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " value = " + demo.getNext());
                    }
                }
            }).start();
        }
    }
}
