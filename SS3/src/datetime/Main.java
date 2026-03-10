package datetime;

import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date);

        // DateTimeAPI
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(today);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(zonedDateTime);

        LocalDate bod = LocalDate.of(2006, 10, 29);
        Period age = Period.between(bod, today);
        System.out.println(age);
        LocalDate nextDate = bod.plusDays(100);
        System.out.println(nextDate);
    }
}
