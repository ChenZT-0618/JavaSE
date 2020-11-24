package CommonClass;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Set;

/**
 * @author ChenZT
 */
public class InstantTest {
    @Test
    public void test() {
        // 构造对象
        Instant now = Instant.now();// 本初子午线的时间，我们的时间减8小时

        System.out.println(now);// 2020-08-13T07:41:32.213Z

        System.out.println(Instant.ofEpochMilli(now.toEpochMilli()));
        // 偏移时间
        OffsetDateTime time = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(time);

        // 获取瞬时点的毫秒数
        System.out.println(now.toEpochMilli());
    }

    /**
     * 格式化日期格式
     */
    @Test
    public void test2() {
        // 方式一：预定义的标准格式。
        // 1. 生成格式对象
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 2. 格式化: 日期 -> 字符串
        String time = formatter.format(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(time);
        // 3. 解析：字符串 -> 日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);
        System.out.println("-------------------------------------");

        // 方式二：本地化相关的格式。
        /*
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format = formatter1.format(LocalDateTime.now());
        System.out.println(format);
        */
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(LocalDate.now()));// 2020年8月13日 星期四
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(LocalDate.now()));// 2020年8月13日 星期四
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(LocalDate.now()));// 2020年8月13日 星期四
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDate.now()));// 2020年8月13日 星期四

        System.out.println("-------------------------------------");


        // 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = formatter3.format(LocalDateTime.now());
        System.out.println(format);
        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);
    }

    /**
     * 时区测试
     */
    @Test
    public void test3() {
        //ZoneId:类中包含了所有的时区信息
        // ZoneId的getAvailableZoneIds():获取所有的ZoneId
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds.size());

        // ZoneId的of():获取指定时区的时间
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(localDateTime);

        //ZonedDateTime:带时区的日期时间
        // 获取本时区的ZonedDateTime对象
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        // 获取指定时区的ZonedDateTime对象
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime1);
    }

    @Test
    public void test4() {
        LocalTime localTime = LocalTime.of(17, 00, 00);
        LocalTime localTime1 = LocalTime.of(15, 00, 00);
        Duration duration = Duration.between(localTime1, localTime);
        System.out.println(duration);
        System.out.println(duration.getSeconds()); // 以秒为单位
        System.out.println(duration.toMinutes()); // 以分钟为单位
        System.out.println(duration.toHours()); // 以小时为单位
        System.out.println(duration.toDays()); // 以天为单位
    }

    @Test
    public void test5() {
        //Period:用于计算两个“日期”间隔，以年、月、日衡量
        LocalDate localDate = LocalDate.of(2020, 8, 13);
        LocalDate localDate1 = LocalDate.of(2028, 3, 12);
        Period period = Period.between(localDate, localDate1);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        Period period1 = period.withYears(2);
        System.out.println(period1);
    }
}
