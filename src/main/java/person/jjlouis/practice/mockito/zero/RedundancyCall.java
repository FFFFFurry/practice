package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 14:14
 * @Function: 查找冗余调用
 */
public class RedundancyCall {
    public static void main(String[] args) {
        List mockList = mock(List.class);
        mockList.add("1");
        mockList.add("2");

        verify(mockList).add("1");
        verifyNoMoreInteractions(mockList);
    }
}
