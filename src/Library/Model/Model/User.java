package Library.Model.Model;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable,CsvConvertible {
    private String firstName;
    private String secondName;
    private String pesel;

    public User(String firstName, String secondName, String pesel) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(pesel, user.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, pesel);
    }

    @Override
    public String toString() {
        return firstName+"-"+secondName+"-"+pesel;
    }

}
