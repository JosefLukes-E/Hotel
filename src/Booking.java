import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public Booking(LocalDate startDate, LocalDate endDate, Room room, TypeOfVacation typeOfVacation, Guest guest) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.typeOfVacation = typeOfVacation;
        this.guests.add(guest);
        //Main.bookings.add(this);
    }

    public Booking(LocalDate startDate, Room room, TypeOfVacation typeOfVacation, Guest guest) {
        this(startDate,startDate.plusDays(6),room,typeOfVacation,guest);
        this.startDate = startDate;



    }
    public Booking( Room room, TypeOfVacation typeOfVacation, Guest guest) {
        this(LocalDate.now(),LocalDate.now().plusDays(6),room,typeOfVacation,guest);
        this.startDate = startDate;


    }

    public BigDecimal totalDaysForStay(){

        long countOfDays =  DAYS.between(startDate,endDate);

        return BigDecimal.valueOf(countOfDays);

    }
    public BigDecimal totalPriceForStay(){


        BigDecimal total = room.getPricePerNight().multiply(totalDaysForStay());
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

    public void setTypeOfVacation(TypeOfVacation typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }

    @Override
    public String toString() {

        return "Rezervace: " +
                "hosté=" + guests +
                ",od " + startDate.format(Main.czDateFormatter) +
                ",do " + endDate.format(Main.czDateFormatter) +
                ",pokoj č. " + room.getNumber() +
                ",typ pobytu " + typeOfVacation +
                ",počet dní " + totalDaysForStay()  +
                ",cena za pobyt " + totalPriceForStay() + " Kč";
    }
}
