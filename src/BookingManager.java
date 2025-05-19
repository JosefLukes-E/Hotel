import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking>  bookings= new ArrayList<>();

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    public Booking getBooking(int index){
        return bookings.get(index);
    }

    public List<Booking> getBookings() {
        return bookings;
    }
    public void clearBookings() {
        bookings.clear();
    }

    public int getNumberOfWorkingBookings(){
        int count = 0;
        for (Booking b: bookings){
            if (TypeOfVacation.BUSINESS.equals(b.getTypeOfVacation())){
                count++;
            }
        }

        return count;

    }

    public double getAverageGuests(){
        double average = -1;
        double guestCount = 0;
        for (Booking b : bookings){

            guestCount += b.getGuestsCount();
        }
        if (!bookings.isEmpty()){
            average = guestCount/bookings.size();
        }

        return average;
    }

    public void getTopNHolidayBookings(int topN){

        int topNfound = 0;

        System.out.println("Prvních " + topN + " rekreačních rezervací:");

        for (Booking b: bookings){
            if (TypeOfVacation.PRIVATE.equals(b.getTypeOfVacation())){
                System.out.println(b);
                topNfound++;
                if (topN==topNfound) break;
            }
        }
    }

    public void printGuestStatistics(){
        int countOfOneGuest = 0;
        int countOfTwoGuest = 0;
        int countOfMoreGuest = 0;

        for (Booking b:bookings) {

            if (b.getGuestsCount()==1){
                countOfOneGuest++;
            } else if (b.getGuestsCount()==2) {
                countOfTwoGuest++;

            }
            else if (b.getGuestsCount()>2) {
                countOfMoreGuest++;

            } else {
                 countOfOneGuest = -1;
                countOfTwoGuest = -1;
                countOfMoreGuest = -1;
            }
        }
        System.out.println("celkový počet rezervací s jedním hostem: " +countOfOneGuest);
        System.out.println("celkový počet rezervací se dvěma hosty: " +countOfTwoGuest);
        System.out.println("celkový počet rezervací s s více než dvěma hosty: " +countOfMoreGuest);
    }

    public void getFormattedSummary(){

        System.out.println("Formátovaný výpis všech rezervací v systému:");
        for (Booking booking:bookings){

            System.out.println(booking.getStartDate().format(Main.czDateFormatter) + " až "
                           + booking.getEndDate().format(Main.czDateFormatter) + ": "
                            + booking.getGuests().get(0) + "[hostů: "
                          + booking.getGuests().size() + ", výhled na moře: "
                           + booking.getRoom().isSeaView() + "] za "
                            + booking.getTotalPrice() + " Kč"
            );

        }
    }

}
