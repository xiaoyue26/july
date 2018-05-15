package redis.utils;

/**
 * Created by xiaoyue26 on 17/11/17.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhoufeiyu
 */
public class DayKey implements Comparable<DayKey> {
    private static final ThreadLocal<SimpleDateFormat> FORMATTER = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    private int year;
    private int month;
    private int day;

    public DayKey() {
    }

    public DayKey(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public DayKey lastDay() {
        Calendar c = toCalendar();
        c.add(Calendar.DAY_OF_YEAR, -1);
        return fromTimestamp(c.getTimeInMillis());
    }

    public DayKey nextDay() {
        Calendar c = toCalendar();
        c.add(Calendar.DAY_OF_YEAR, 1);
        return fromTimestamp(c.getTimeInMillis());
    }

    public Calendar toCalendar() {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c;
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }


    public long toTimeInMillis() {
        return toCalendar().getTimeInMillis();
    }

    public static DayKey today() {
        return fromTimestamp(System.currentTimeMillis());
    }

    public static DayKey yesterday() {
        return today().lastDay();
    }

    public static DayKey tomorrow() {
        return today().nextDay();
    }

    public static DayKey fromString(String str) throws ParseException {
        Date date = FORMATTER.get().parse(str);
        return fromTimestamp(date.getTime());
    }

    public static DayKey fromInt(int date) {
        int year = date / 10000;
        int month = (date / 100) % 100;
        int day = date % 100;
        return new DayKey(year, month, day);
    }

    public static DayKey fromTimestamp(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DayKey(year, month, day);
    }

    public static DayKey fromLocalDate(LocalDate localDate) {
        return new DayKey(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }

    public DayKey plusDays(long daystoAdd) {
        if (daystoAdd == 0) {
            return this;
        }
        LocalDate localDate = toLocalDate().plusDays(daystoAdd);
        return fromLocalDate(localDate);
    }

    public DayKey minusDays(long daystoSubstract) {
        if (daystoSubstract == 0) {
            return this;
        }
        LocalDate localDate = toLocalDate().minusDays(daystoSubstract);
        return fromLocalDate(localDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayKey)) return false;

        DayKey dayKey = (DayKey) o;

        if (day != dayKey.day) return false;
        if (month != dayKey.month) return false;
        if (year != dayKey.year) return false;

        return true;
    }

    /**
     * 序列化成int
     *
     * @return
     */
    public int toInt() {
        return year * 10000 + month * 100 + day;
    }

    @Override
    public int hashCode() {
        return toInt();
    }

    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }

    /**
     * 输出格式: yyyy-MM-dd
     * toString()方法中,month和day没有补零
     */
    public String toFormatString() {
        return FORMATTER.get().format(toCalendar().getTime());
    }

    @Override
    public int compareTo(DayKey o) {
        if (year != o.year) {
            return year - o.year;
        }
        if (month != o.month) {
            return month - o.month;
        }
        return day - o.day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}