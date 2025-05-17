
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //static List<Booking> bookings= new ArrayList<>();
    static DateTimeFormatter czDateFormatter = DateTimeFormatter.ofPattern("d.M.yyyy");
    public static void main(String[] args) {

        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993,3,13));
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995,5,5));
        Guest guest3 = new Guest("Pavel", "Nový", LocalDate.of(1935,11,8));
        Guest guest4 = new Guest("John", "Doe", LocalDate.of(1945,11,8));

        System.out.println(guest1);
        System.out.println(guest2);
        guest2.setDateOfBirth(LocalDate.of(1995,4,5));
        System.out.println(guest2);
        System.out.println(guest3);
        System.out.println(guest4);

        Room room1 = new Room(1,1,true,true,BigDecimal.valueOf(1000));
        Room room2 = new Room(2,2,true,true,BigDecimal.valueOf(5000));
        Room room3 = new Room(3,3,false,true,BigDecimal.valueOf(2400));



        Booking booking1 = new Booking(LocalDate.of(2021,7,19),LocalDate.of(2021,7,26),room1,TypeOfVacation.PRIVATE,guest1);
        Booking booking2 = new Booking(LocalDate.of(2021,9,1),LocalDate.of(2021,9,14),room3,TypeOfVacation.BUSINESS,guest2);
        Booking booking3 = new Booking(LocalDate.of(2021,10,1),room3,TypeOfVacation.PRIVATE,guest2);
        Booking booking4 = new Booking(room2,TypeOfVacation.PRIVATE,guest3);
        Booking booking5 = new Booking(room2,TypeOfVacation.STUDY,guest4);
        booking2.addGuest(guest1);

        printBookings();

    }
    private static void printBookings(){

        /*
        for (Booking booking:bookings){
            System.out.println( (bookings.indexOf(booking)+1) + " " + booking);
        }
*/

    }

}