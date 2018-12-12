package person.jjlouis.practice.mockito.zero;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/12 14:18
 * @Function: 简化mock
 * MockitoAnnotations.initMocks(testClass); 需要在测试函数之前调用
 * todo 注解的一些写法
 */
public class SimpleMock {

    static {
        MockitoAnnotations.initMocks(SimpleMock.class);
    }

    @Mock
    private List mockList;

    public static void main(String[] args) {
        SimpleMock mock = new SimpleMock();
        mock.getMockList().add("1");
        verify( mock.getMockList()).add("1");
    }

    public List getMockList() {
        return mockList;
    }
}
