package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 11:33
 * @Function:参数匹配器
 */
public class Matchers {
    public static void main(String[] args) {
        List mockList = mock(List.class);
        //anyInt()内置参数匹配器

        when(mockList.get(anyInt())).thenReturn("hello word");
        //自定义参数匹配器 在isValid()返回自己的匹配器实现
//        when(mockList.contains(argThat(isValid()))).thenReturn("hello word2");
        System.out.println(mockList.get(9999));
        verify(mockList).get(anyInt());
        /*
        * 其他参数匹配器
        * verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));
          如果使用了参数匹配器，则所有的参数也必须是参数匹配器
        * */

    }

}
