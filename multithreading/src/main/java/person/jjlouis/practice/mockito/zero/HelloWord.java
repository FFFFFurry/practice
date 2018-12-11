package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/11 21:48
 * @Function: 验证某些行为
 * 一旦mock对象被创建了，mock对象会记住所有的交互。然后你就可能选择性的验证你感兴趣的交互。
 * 文档：https://github.com/hehonghui/mockito-doc-zh
 */
public class HelloWord {

    public static void main(String[] args) {
        List mockList = mock(List.class);

        mockList.add("hello word");
        mockList.clear();

        verify(mockList).add("hello word");
        verify(mockList).clear();
    }
}
