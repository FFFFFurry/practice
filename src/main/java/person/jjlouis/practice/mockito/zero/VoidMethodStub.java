package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 14:47
 * @Function: 为void方法打测试桩
 * doReturn()
 * doThrow()
 * doAnswer()
 * doNothing()
 * doCallRealMethod()
 */
public class VoidMethodStub {
    public static void main(String[] args) {
        List mockList = mock(List.class);
        doThrow(new RuntimeException()).when(mockList).clear();
        mockList.clear();

    }
}
