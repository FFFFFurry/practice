package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 14:06
 * @Function: 确保交互操作不会执行在mock对象上(就是没有相关调用)
 */
public class VerifyInteraction {
    public static void main(String[] args) {
        List mockList = mock(List.class);
        List mockList2 = mock(List.class);
        List mockList3 = mock(List.class);
        mockList.add("1");
        mockList2.add("2");
//        mockList3.add(mockList.get(0));
        verify(mockList).add("1");
        verify(mockList,never()).add("2");
        verifyZeroInteractions(mockList2,mockList3);
    }
}
