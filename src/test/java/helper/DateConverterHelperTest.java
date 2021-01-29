package helper;

import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class DateConverterHelperTest {

    @Test
    public void givenADateInCorrectFormatThenShouldReturnSucess() throws ParseException {
        String actualDate = "29Jan2021(fri)";
        LocalDate expectedDate = DateConverterHelper.toLocalDate(actualDate);
    }

    @Test
    public void givenADateInCorrectFormatThenShouldReturnACorrectDate() throws ParseException {
        String actualDate = "29Jan2021(fri)";
        LocalDate localDate = DateConverterHelper.toLocalDate(actualDate);
        assertEquals(29, localDate.getDayOfMonth());
    }

    @Test
    public void givenAWeekDayThenIsWeekendShouldReturnFalse() {
        LocalDate localDate = LocalDate.of(2021, 01, 29);
        boolean isWeekend = DateConverterHelper.isWeekend(localDate);
        assertFalse(isWeekend);
    }

    @Test
    public void givenWeekendThenIsWeekendShouldReturnTrue() {
        LocalDate localDate = LocalDate.of(2021, 01, 30);
        boolean isWeekend = DateConverterHelper.isWeekend(localDate);
        assertTrue(isWeekend);
    }

    @Test
    public void givenThreeDatesThenShouldReturnALocalDateListsWithThreeDates() throws ParseException {
        String listDates = "26Jan2021(tue),27Jan2021(wed),28Jan2021(thu)";
        String[] splitDates = listDates.split(",");
        List<LocalDate> localDates = DateConverterHelper.toLocalDateList(splitDates);
        assertEquals(3,localDates.size());
    }

}