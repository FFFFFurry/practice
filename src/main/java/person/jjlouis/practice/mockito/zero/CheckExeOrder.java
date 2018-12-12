package person.jjlouis.practice.mockito.zero;

import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 13:57
 * @Function: 验证执行顺序
 */
public class CheckExeOrder {
    public static void main(String[] args) {
        List mockList = mock(List.class);

        mockList.add("1");
        mockList.add("2");

        /*验证单个实例调用顺序*/
        InOrder inOrder = inOrder(mockList);

        inOrder.verify(mockList).add("1");
        inOrder.verify(mockList).add("2");

        /*验证多个实例调用顺序*/
        List mockList1 = mock(List.class);
        List mockList2 = mock(List.class);

        mockList1.add("1");
        mockList2.add("2");

        inOrder = inOrder(mockList1,mockList2);
        inOrder.verify(mockList1).add("1");
        inOrder.verify(mockList2).add("2");




    }
}
