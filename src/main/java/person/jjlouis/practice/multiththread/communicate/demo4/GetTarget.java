package person.jjlouis.practice.multiththread.communicate.demo4;

/**
 * author : jjlouis
 * time : 2018/5/20 10:19
 * function :
 */
public class GetTarget implements Runnable {
    private Demo4 demo;

    public GetTarget(Demo4 demo) {
        this.demo = demo;
    }

    public void run() {
        demo.get();
    }
}
