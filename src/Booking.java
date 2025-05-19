import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Booking {
    private List<Guest> guests= new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;
    //private boolean isBusiness;
    private TypeOfVacation typeOfVacation;

    public Booking(LocalDate startDate, LocalDate endDate, Room room, TypeOfVacation typeOfVacation, List<Guest> guests) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.typeOfVacation = typeOfVacation;
        this.guests=guests;
        //Main.bookings.add(this);
    }

    public Booking(LocalDate startDate, Room room, TypeOfVacation typeOfVacation, List<Guest> guests) {
        this(startDate,startDate.plusDays(6),room,typeOfVacation,guests);
        this.startDate = startDate;



    }
    public Booking( Room room, TypeOfVacation typeOfVacation, List<Guest> guests) {
        this(LocalDate.now(),LocalDate.now().plusDays(6),room,typeOfVacation,guests);
        this.startDate = startDate;


    }

    public BigDecimal getBookingLength(){

        long countOfDays =  DAYS.between(startDate,endDate);

        return BigDecimal.valueOf(countOfDays);

    }
    public BigDecimal getTotalPrice(){


        BigDecimal total = room.getPricePerNight().multiply(getBookingLength());
        return total;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public int getGuestsCount(){
        return guests.size();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public TypeOfVacation getTypeOfVacation() {

        return typeOfVacation;
    }

    public String isBussinesTrip(){
        if (TypeOfVacation.BUSINESS.equals(getTypeOfVacation())){
            return "ano";
        } else {
            return "ne";
        }
    }

    public void setTypeOfVacation(TypeOfVacation typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }

    @Override
    public String toString() {

//        return "Rezervace: " +
//                "hosté=" + guests +
//                ",od " + startDate.format(Main.czDateFormatter) +
//                ",do " + endDate.format(Main.czDateFormatter) +
//                ",pokoj č. " + room.getNumber() +
//                ",typ pobytu " + typeOfVacation +
//                ",počet dní " + getBookingLength()  +
//                ",cena za pobyt " + getTotalPrice() + " Kč";
        return "Rezervace pro: " +
                guests +
                " na pokoj č.: " + getRoom().getNumber() +
                " termín " + startDate.format(Main.czDateFormatter) +
                "- " + endDate.format(Main.czDateFormatter) +
                " pracovní pobyt: " + isBussinesTrip()
                ;
    }
}
