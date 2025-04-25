import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String birthName;
    private String surName;
    private LocalDate dateOfBirth;

    public Guest(String birthName, String surName, LocalDate dateOfBirth) {
        this.birthName = birthName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return  birthName + ' '  + surName  + " ("  +  dateOfBirth.format(Main.czDateFormatter) + ")";
    }
}
