package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 14:30
 * @Function:为连续调用做测试桩
 */
public class ContinuousTestStub {
    public static void main(String[] args) {
        List mockList = mock(List.class);
        /*连续调用*/
        when(mockList.get(0))
                .thenReturn("2")//第1次
                .thenReturn("3");
//                .thenThrow(new RuntimeException());
        System.out.println(mockList.get(0));
        System.out.println(mockList.get(0));
        System.out.println(mockList.get(0));
        System.out.println(mockList.get(0));


        /*简洁版*/
        when(mockList.get(0)).thenReturn("1","2","3");
        System.out.println(mockList.get(0));
        System.out.println(mockList.get(0));
        System.out.println(mockList.get(0));
        System.out.println(mockList.get(0));


    }
}
