package person.jjlouis.practice.performance;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/19 19:55
 * @Function: 测试为共享的影响
 */
public class FalseShareCacheTest {

    public final static int MAX_THREAD_COUNT = 10;
    public final static long LOOP_COUNT = 500L * 1000L * 1000L;

    public static void main(String[] args) throws InterruptedException {
        final PaddingObject paddingObject = new PaddingObject();
        final NoPaddingObject noPaddingObject = new NoPaddingObject();
        //测试padding方式
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000000000; i++){
                    paddingObject.setTmp1(paddingObject.getTmp1() + 1);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000000000; i++) {
                    paddingObject.setTmp2(paddingObject.getTmp2() + 1);
                }
            }
        });
        long startTime = System.currentTimeMillis();
        thread.join();
        thread.start();
        thread2.start();
        while (thread.isAlive() || thread2.isAlive()){
            Thread.sleep(2);
        }
        System.out.println("padding costTime = " + (System.currentTimeMillis() - startTime));

        //测试No padding
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000000000; i++){
                    noPaddingObject.setTmp1(noPaddingObject.getTmp1() + 1);
                }
            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000000000; i++) {
                    noPaddingObject.setTmp2(noPaddingObject.getTmp2() + 1);
                }
            }
        });
        startTime = System.currentTimeMillis();
        thread.start();
        thread2.start();
        while (thread.isAlive() || thread2.isAlive()){
            Thread.sleep(2);
        }
        System.out.println("no padding costTime = " + (System.currentTimeMillis() - startTime));

    }

}

class PaddingObject implements Runnable{
    public static volatile long tmp1 = 0L;
    public static long p1,p2,p3,p4,p5,p6,p7,p8,p9 = 0L;
    public static volatile long tmp2 = 0L;

    @Override
    public void run() {
        for(int i = 0; i < 1000000000; i++){
            noPaddingObject.setTmp1(noPaddingObject.getTmp1() + 1);
        }
    }
}

final class NoPaddingObject{
    private static long tmp1 = 0L;
    private static long tmp2 = 0L;
}
