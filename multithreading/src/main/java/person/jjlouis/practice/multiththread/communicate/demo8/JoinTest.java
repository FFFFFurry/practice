package person.jjlouis.practice.multiththread.communicate.demo8;

/**
 * author : jjlouis
 * time : 2018/5/21 22:46
 * function :
 */
public class JoinTest {

    public void a(Thread thread){
        System.out.println(Thread.currentThread().getName() + "调用加塞的线程开始...");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "调用加塞的线程结束...");
    }

    public void b(){
        System.out.println(Thread.currentThread().getName() + "加塞的线程开始...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "加塞的线程结束...");
    }


    public static void main(String[] args) {
        final JoinTest tmp = new JoinTest();
        final Thread joinThread = new Thread(new Runnable() {
           public void run() {
               tmp.b();
           }
       });
        new Thread(new Runnable() {
            public void run() {
                tmp.a(joinThread);
            }
        }).start();

    }
}
