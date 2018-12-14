package person.jjlouis.practice.mockito.zero;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author : xiongyijie
 * @Time : 2018/12/13 15:24
 * @Function: 监控真实对象
 * 当你使用这个spy对象时真实的对象也会也调用，
 * 除非它的函数被stub了。尽量少使用spy对象
 * 有时，在监控对象上使用when(Object)来进行打桩是不可能或者不切实际的。
 * 因此，当使用监控对象时请考虑doReturn|Answer|Throw()函数族来进行打桩。
 *
 * 使用@Mock生成的类，所有方法都不是真实的方法，而且返回值都是NULL。
 * 使用@Spy生成的类，所有方法都是真实方法，返回值都是和真实方法一样的。
 * 所以，你用when去设置模拟返回值时，它里面的方法（dao.getOrder()）会先执行一次。
 * 使用doReturn去设置的话，就不会产生上面的问题，因为有when来进行控制要模拟的方法，所以不会执行原来的方法
 *
 */
public class SpyRealObject {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        List spy = spy(list);
        //应该用doReturn去监控真实对象
        doReturn("foo").when(spy).get(100);
        spy.add("1");
        spy.add("2");
        System.out.println(spy.get(0));
        System.out.println(spy.get(1));
        System.out.println(spy.get(100));
        System.out.println(spy.size());
        System.out.println(spy.get(3));

        verify(spy).add("1");
        verify(spy).add("2");
    }
}
