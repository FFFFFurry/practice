package person.jjlouis.practice.multiththread.communicate.demo5;

/**
 * author : jjlouis
 * time : 2018/5/20 10:44
 * function :多线程交替执行 1,2,3
 */
public class Demo5 {

    private volatile int signal = 1;

    public synchronized void a(){
        while (signal != 1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.signal);
        notifyAll();
        this.signal ++ ;
    }

    public synchronized void b(){
        while (signal != 2){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.signal);
        notifyAll();
        this.signal ++ ;
    }

    public synchronized void c(){
        while (signal != 3){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.signal);
        notifyAll();
        this.signal = 1 ;
    }

    public static void main(String[] args) {
        Demo5 demo = new Demo5();
        int count = 3;
        while (count > 0){
            new Thread(new A(demo)).start();
            new Thread(new B(demo)).start();
            new Thread(new C(demo)).start();
            count --;
        }

    }
}

class A implements Runnable{

    private Demo5 demo;

    public A(Demo5 demo) {
        this.demo = demo;
    }

    public void run() {
        demo.a();
    }
}

class B implements Runnable{

    private Demo5 demo;

    public B(Demo5 demo) {
        this.demo = demo;
    }

    public void run() {
        demo.b();
    }
}

class C implements Runnable{

    private Demo5 demo;

    public C(Demo5 demo) {
        this.demo = demo;
    }

    public void run() {
        demo.c();
    }
}


