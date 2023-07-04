import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DateFormat {
    public static void main(String[] args) {
        // Hàm lấy thời gian hiện tại
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println("TEST");
        }
        long t2 = System.currentTimeMillis();

        System.out.println("Truoc khi chay for: " +t1);
        System.out.println("Sau khi chay for: " +t2);
        System.out.println("Thoi gian: " + ((t2-t1)) + "mls");
        System.out.println("Thoi gian: " + ((t2-t1)/1000) + "s");

        // Time Unit
        System.out.println("3000 năm = " + TimeUnit.DAYS.toSeconds(3000*365) + "s");
        System.out.println("25h = " + TimeUnit.HOURS.toSeconds(25) + "s");

        // Date
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900));

        // Calendar
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DATE)+ "-"+ (calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR));

        calendar.add(Calendar.HOUR, 10);
//        System.out.println(calendar);  // ra rat nhieu thu
        System.out.println(calendar.get(Calendar.DATE)+ "-"+ (calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DATE, -14);
        System.out.println(calendar.get(Calendar.DATE)+ "-"+ (calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR));

        // DateFormat
        java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));


    }
}
