package CommonClass;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author ChenZT
 */
public class DateTimeTest {
    @Test
    public void test() {
       /*
        System.out.println(LocalDate.now()); // 2020-08-12
        System.out.println(LocalTime.now()); // 20:13:23.444
        System.out.println(LocalDateTime.now()); //2020-08-12T20:13:23.444
       */

        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 18, 19, 01, 01);
        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //withXxx():设置相关的属性
        LocalDateTime localDateTime1 = localDateTime.withHour(5);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
    }
}
