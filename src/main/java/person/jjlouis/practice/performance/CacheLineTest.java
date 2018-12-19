package person.jjlouis.practice.performance;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/18 16:06
 * @Function: 缓存行测试
 * 见文章链接：https://tech.meituan.com/disruptor.html
 * 关于缓存行的概念：https://blog.csdn.net/hxg117/article/details/78064632
 */
public class CacheLineTest {

    public static void main(String[] args) {
        testArrayCacheLine();
    }

    public static void testArrayCacheLine(){
        long[][] array = new long[1024 * 1024][];
        for(int i = 0;i < 1024 * 1024;i++){
            array[i] = new long[8];
            for(int j = 0;j < 8;j++){
                array[i][j] = 0L;
            }
        }
        long sum = 0L;
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 1024 * 1024;i++){
            for(int j = 0;j < 8;j++){
                sum += array[i][j];
            }
        }
        System.out.println("Array for cache line cost time = " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 1024 * 1024;j++){
                sum += array[j][i];
            }
        }
        System.out.println("Array for no cache line cost time = " + (System.currentTimeMillis() - startTime));
    }
}
