
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
    BookingManager bookingManager = new BookingManager();
    bookingManager.setBookings(fillBookings());

    System.out.println("Počet pracovních pobytů: " + bookingManager.getNumberOfWorkingBookings());
    System.out.println("Průměrný počet hostů na rezervaci: " + bookingManager.getAverageGuests());
    bookingManager.printGuestStatistics();

    bookingManager.getNumberOfWorkingBookings();
    bookingManager.getAverageGuests();
    bookingManager.getTopNHolidayBookings(8);
    bookingManager.getFormattedSummary();



//        System.out.println(guest1);
//        System.out.println(guest2);
//        guest2.setDateOfBirth(LocalDate.of(1995,4,5));
//        System.out.println(guest2);
//        System.out.println(guest3);
//        System.out.println(guest4);





//        Booking booking1 = new Booking(LocalDate.of(2021,7,19),LocalDate.of(2021,7,26),room1,TypeOfVacation.PRIVATE,guest1);
//        Booking booking2 = new Booking(LocalDate.of(2021,9,1),LocalDate.of(2021,9,14),room3,TypeOfVacation.BUSINESS,guest2);
////        Booking booking3 = new Booking(LocalDate.of(2021,10,1),room3,TypeOfVacation.PRIVATE,guest2);
//        Booking booking4 = new Booking(room2,TypeOfVacation.PRIVATE,guest3);
//        Booking booking5 = new Booking(room2,TypeOfVacation.STUDY,guest4);
//        booking2.addGuest(guest1);

        //printBookings();

    }

    private static List<Booking> fillBookings() {

        List<Booking> bookings = new ArrayList<>();

        Guest guest1 = new Guest("Karel", "Dvořák", LocalDate.of(1990,5,15));
        Guest guest2 = new Guest("Karel", "Dvořák", LocalDate.of(1979,1,3));
        Guest guest3 = new Guest("Karolína", "Tmavá", LocalDate.of(2020,11,12));

        Room room1 = new Room(1,1,true,true,BigDecimal.valueOf(1000));
        Room room2 = new Room(2,2,true,true,BigDecimal.valueOf(5000));
        Room room3 = new Room(3,3,false,true,BigDecimal.valueOf(2400));



        bookings.add(new Booking(LocalDate.of(2023,6,1),LocalDate.of(2023,6,7),room3,TypeOfVacation.BUSINESS,List.of(guest1)));
        bookings.add(new Booking(LocalDate.of(2023,7,18),LocalDate.of(2023,7,21),room2,TypeOfVacation.PRIVATE,List.of(guest1)));
        bookings.add(new Booking(LocalDate.of(2023,8,1),LocalDate.of(2023,8,31),room3,TypeOfVacation.BUSINESS,List.of(guest3,guest1)));

        for (int i = 0; i < 10; i++) {
            bookings.add(new Booking(LocalDate.of(2023,8,1 + i + 1),LocalDate.of(2023,8,2 + i + 1),room2,TypeOfVacation.PRIVATE,List.of(guest3)));
        }
        return bookings;


    }


}