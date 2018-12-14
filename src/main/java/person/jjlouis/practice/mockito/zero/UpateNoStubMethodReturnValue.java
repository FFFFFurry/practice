package person.jjlouis.practice.mockito.zero;

import java.util.List;

import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/14 14:32
 * @Function: 修改没有测试桩的调用的默认返回值 ( 1.7版本之后 )
 */
public class UpateNoStubMethodReturnValue {
    public static void main(String[] args) {
        List mockList = mock(List.class,RETURNS_SMART_NULLS);
        System.out.println(mockList.get(0));
    }
}
