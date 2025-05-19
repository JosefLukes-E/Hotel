import java.math.BigDecimal;

public class Room {
    private int number;
    private int bed;
    private boolean balcony;
    private boolean seaView;
    private BigDecimal pricePerNight;

    public Room(int number, int bed, boolean hasBalcony, boolean seaView, BigDecimal pricePerNight) {
        this.number = number;
        this.bed = bed;
        this.balcony = hasBalcony;
        this.seaView = seaView;
        this.pricePerNight = pricePerNight;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public String isSeaView() {
        if (seaView) {
            return "Ano";
        } else {
            return "Ne";
        }

    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return
                "Číslo pokoje " + number +
                        ", počet postelí" + bed +
                        ", má balkón " + balcony +
                        ", má výhled na moře " + seaView +
                        ", cena za noc " + pricePerNight
                ;
    }
}
