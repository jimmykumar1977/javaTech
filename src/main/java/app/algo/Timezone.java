package app.algo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Timezone {
    public static void main(String[] args) {
        ZonedDateTime zone = ZonedDateTime.parse("2016-10-05T08:20:10+05:30[Asia/Jakarta]");
        System.out.println(zone);

        LocalDateTime ldt = LocalDateTime.parse("2018-07-01T00:00");
        ZonedDateTime one = ldt.atZone(ZoneId.of("Asia/Jakarta"));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss x").format(one));
    }
}
