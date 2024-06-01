package Javabasics;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesEg {

    @Test
    public void dateEg(){

        Date date =new Date();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
       /* String adc =simpleDateFormat.format(date);
        System.out.println(date.toString());
        System.out.println(adc);*/

        //calendar

      Calendar calendar =  Calendar.getInstance();
      SimpleDateFormat format =new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
      System.out.println(format.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.AM_PM));
        System.out.println(calendar.get(Calendar.MINUTE));
    }
}
