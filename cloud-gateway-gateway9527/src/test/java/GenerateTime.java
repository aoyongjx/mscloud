import java.time.ZonedDateTime;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: alen.ao
 * @date: $
 */
public class GenerateTime {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(); // 默认时区
        System.out.println(zonedDateTime);

        // 2020-06-29T11:58:06.005+08:00[Asia/Shanghai]
    }
}
