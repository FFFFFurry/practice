package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 13:47
 * @Function: 验证函数的确切、最少、从未调用次数
 */
public class CheckCount {

    public static void main(String[] args) {
        List mockList = mock(List.class);
        mockList.add("1");

        mockList.add("2");
        mockList.add("2");

        mockList.add("3");
        mockList.add("3");
        mockList.add("3");

        verify(mockList).add("1");
        verify(mockList,times(1)).add("1");

        verify(mockList,times(2)).add("2");

        verify(mockList,times(3)).add("3");

        verify(mockList,never()).add("4");

        verify(mockList,atLeastOnce()).add("3");

        verify(mockList,atLeast(2)).add("2");

        verify(mockList,atMost(5)).add("3");

    }
}
