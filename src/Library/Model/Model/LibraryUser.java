package Library.Model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User {
    private List<Publication> publicationHistory=new ArrayList<>();
    private List<Publication> borrowedPublications=new ArrayList<>();

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    public LibraryUser(String firstName, String secondName, String pesel) {
        super(firstName, secondName, pesel);
    }

    private void addPublicationToHistory(Publication publication){
        publicationHistory.add(publication);
    }

    public void borrowPublication(Publication publication){
        borrowedPublications.add(publication);
    }

    public boolean returnPublication(Publication publication){
        boolean result=false;
        if (borrowedPublications.remove(publication)){
            result=true;
            addPublicationToHistory(publication);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryUser)) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(publicationHistory, that.publicationHistory) &&
                Objects.equals(borrowedPublications, that.borrowedPublications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationHistory, borrowedPublications);
    }

    @Override
    public String toCsv() {
        return getFirstName()+";"+getSecondName()+";"+getPesel();
    }


}
