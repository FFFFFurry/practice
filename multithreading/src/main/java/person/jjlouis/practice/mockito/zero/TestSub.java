package person.jjlouis.practice.mockito.zero;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/11 21:53
 * @Function: 如何做一些测试桩 (Stub)
 * 测试桩：固定方法的输入输出
 * mock函数默认返回的是null
 * verify 验证函数是否被调用(默认为1次)
 *
 *
 */
public class TestSub {

    public static void main(String[] args) {
        LinkedList mockList = mock(LinkedList.class);

        //测试桩
        when(mockList.get(0)).thenReturn("hello word");
        when(mockList.get(1)).thenThrow(new RuntimeException());
        System.out.println(mockList.isEmpty());
        System.out.println(mockList.get(0));
        when(mockList.get(0)).thenReturn("hello word2");
        System.out.println(mockList.get(0));

//        System.out.println(mockList.get(1));

        //get(999)没有打桩 输出null
        System.out.println(mockList.get(9999));

        verify(mockList).get(0);
    }
}
