package application;
import helper.CalculateTaxHelper;
import helper.DateConverterHelper;
import model.CustomerType;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

public class Syngenta {

    public static void main(String[] args) throws  ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] userInputSplited = input.split(":");

        CustomerType customerType = CustomerType.valueOf(userInputSplited[0].toUpperCase(Locale.ROOT));

        String[] originalDates = userInputSplited[1].split(",");

        List<LocalDate> localDates = DateConverterHelper.toLocalDateList(originalDates);

        String theBestHotelName = CalculateTaxHelper.getTheBestHotelName(customerType, localDates);

        System.out.println(theBestHotelName);

        scanner.close();
    }
}