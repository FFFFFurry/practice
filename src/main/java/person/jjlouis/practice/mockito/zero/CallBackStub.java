package person.jjlouis.practice.mockito.zero;


import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 14:43
 * @Function: 为回调做测试桩（不建议使用）
 */
public class CallBackStub {
    public static void main(String[] args) {
        List mock = mock(List.class);
        when(mock.get(0))
                .thenAnswer(new Answer() {
                    @Override
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                        Object[] args = invocation.getArguments();
                        Object mock = invocation.getMock();
                        return "called with arguments: " + args;
                    }
                });
        System.out.println(mock.get(0));
    }
}
