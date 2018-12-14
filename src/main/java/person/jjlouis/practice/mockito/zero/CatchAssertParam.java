package person.jjlouis.practice.mockito.zero;

import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.verify;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/14 14:37
 * @Function: 为下一步的断言捕获参数
 */
public class CatchAssertParam {
    public static void main(String[] args) {
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(mock).doSomething(argument.capture());
    }
}
