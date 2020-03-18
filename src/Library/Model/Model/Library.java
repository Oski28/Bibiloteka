package Library.Model.Model;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {
    private static final int INITIAL_CAPACITY = 1;
    private int publicationsNumber = 0;
    Publication[] publications = new Publication[INITIAL_CAPACITY];

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        System.arraycopy(publications,0,result,0,publicationsNumber);
        return result;
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    public void addPublication(Publication publication) {
        if (publicationsNumber == publications.length) {
            publications=Arrays.copyOf(publications,publications.length*2);
        }
            publications[publicationsNumber] = publication;
            publicationsNumber++;
    }

    public boolean removePublication(Publication publication){
        final int NOT_FOUND=-1;
        int found=NOT_FOUND;
        int i=0;
        while (i<publications.length && found==NOT_FOUND){
            if (publications[i].equals(publication)){
                found=i;
            } else {
                i++;
            }
        }
        if (found!=NOT_FOUND){
            System.arraycopy(publications,found+1,publications,found,publications.length-found-1);
            publicationsNumber--;
        }
        return found!=NOT_FOUND;
    }
}
