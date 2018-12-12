package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 13:52
 * @Function: 为返回void函数通过stub抛出异常
 */
public class VoidThrowException {
    public static void main(String[] args) {
        List mockList = mock(List.class);
        doThrow(new RuntimeException()).when(mockList).clear();
        mockList.clear();
    }
}
