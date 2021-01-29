package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateConverterHelper {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMMyyyy(E)");

    public static LocalDate toLocalDate(String stringDate) throws ParseException {
        Date date = simpleDateFormat.parse(stringDate);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    public static boolean isWeekend(LocalDate localDate) {
        return (localDate.getDayOfWeek().getValue() == 6 || localDate.getDayOfWeek().getValue() == 7);
    }

    public static List<LocalDate> toLocalDateList(String[] originalDates) throws ParseException {
        List<LocalDate> listDate = new ArrayList<>();

        for (int index = 0; index < originalDates.length; index++) {
            listDate.add(DateConverterHelper.toLocalDate(originalDates[index]));
        }
        return listDate;
    }
}
