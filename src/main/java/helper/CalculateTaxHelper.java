package helper;

import model.CustomerType;
import model.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalculateTaxHelper {


    public static String getTheBestHotelName(CustomerType customerType, List<LocalDate> datesList) {
        List<Hotel> hotelTaxList = getHotelsConfigurations();
        Hotel bestHotel = null;
        double bestPrice = 0;

        for (Hotel actualHotel : hotelTaxList) {
            double actualHotelTotal = 0;

            for (LocalDate localDate : datesList) {
                boolean isWeekend = DateConverterHelper.isWeekend(localDate);
                boolean isReward = customerType.equals(CustomerType.REWARD);

                double tax = actualHotel.getTaxByConfiguration(isWeekend, isReward);
                actualHotelTotal += tax;
            }

            if (bestPrice == 0 || actualHotelTotal < bestPrice) {
                bestPrice = actualHotelTotal;
                bestHotel = actualHotel;
            } else if (actualHotelTotal == bestPrice) {
                if (actualHotel.getClassification() > bestHotel.getClassification()){
                    bestPrice = actualHotelTotal;
                    bestHotel = actualHotel;
                }
            }
        }

        return bestHotel.getName();

    }

    private static List<Hotel> getHotelsConfigurations() {

        List<Hotel> listHotel = new ArrayList<>();

        Hotel hotelLakewood = new Hotel("Lakewood", 3, 110,
                80, 90, 80);
        listHotel.add(hotelLakewood);

        Hotel hotelBridgewood = new Hotel("Bridgewood", 4, 160,
                110, 60, 50);
        listHotel.add(hotelBridgewood);

        Hotel hotelRidgewood = new Hotel("Ridgewood ", 5, 220,
                100, 150, 40);
        listHotel.add(hotelRidgewood);

        return listHotel;
    }
}
