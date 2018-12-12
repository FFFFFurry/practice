package person.jjlouis.practice.multiththread.communicate.demo4;

/**
 * author : jjlouis
 * time : 2018/5/20 10:18
 * function :
 */
public class SetTarget implements Runnable {
    private Demo4 demo;

    public SetTarget(Demo4 demo) {
        this.demo = demo;
    }

    public void run() {
        demo.set();
    }
}
