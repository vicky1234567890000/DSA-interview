package core_java.multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample {

    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    public static void main(String[] args) {

        for(int i=0; i<3; i++){

            Thread t = new Thread(() -> {
                String format = dateFormatHolder.get().format(new Date());
                System.out.println(Thread.currentThread().getName() + " : " + format);
            });
             t.start();
        }
    }
}
