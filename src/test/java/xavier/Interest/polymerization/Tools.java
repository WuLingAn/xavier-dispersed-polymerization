package xavier.Interest.polymerization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 测试用工具类
 */
public class Tools {
    public static LocalDateTime strToLocalDate(String str){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime= LocalDateTime.parse(str,dateTimeFormatter);

        return  dateTime;
    }

    public static String localDateFormat(LocalDateTime ldt){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return dateTimeFormatter.format(ldt);
    }
}
