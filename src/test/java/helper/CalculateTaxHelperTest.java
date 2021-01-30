package helper;

import model.CustomerType;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculateTaxHelperTest {

    @Test
    public void givenACustomerRegularWhenIsWeekDayThenShouldReturnLakewood() {
        List<LocalDate> localDateList = new ArrayList<>();
        localDateList.add(LocalDate.of(2021, 1, 4));
        localDateList.add(LocalDate.of(2021, 1, 5));
        localDateList.add(LocalDate.of(2021, 1, 6));
        String theBestHotelName = CalculateTaxHelper.getTheBestHotelName(CustomerType.REGULAR, localDateList);
        assertEquals(theBestHotelName, "Lakewood");

    }

    @Test
    public void givenACustomerRegularWhenIHaveOneWeekDayAndTwoWeekendDaysThenShouldReturnBridgewood() {
        List<LocalDate> localDateList = new ArrayList<>();
        localDateList.add(LocalDate.of(2021, 1, 8));
        localDateList.add(LocalDate.of(2021, 1, 9));
        localDateList.add(LocalDate.of(2021, 1, 10));
        String theBestHotelName = CalculateTaxHelper.getTheBestHotelName(CustomerType.REGULAR, localDateList);
        assertEquals(theBestHotelName, "Bridgewood");

    }

    @Test
    public void givenACustomerRewardWhenIsTwoWeekDaysAndOneWeekendDayThenShouldReturnRidgewood() {
        List<LocalDate> localDateList = new ArrayList<>();
        localDateList.add(LocalDate.of(2021, 1, 7));
        localDateList.add(LocalDate.of(2021, 1, 8));
        localDateList.add(LocalDate.of(2021, 1, 9));
        String theBestHotelName = CalculateTaxHelper.getTheBestHotelName(CustomerType.REWARD, localDateList);
        assertEquals(theBestHotelName, "Ridgewood ");
    }
}