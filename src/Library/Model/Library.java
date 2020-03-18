package Library.Model;

import java.io.Serializable;

public class Library implements Serializable {
    private static final int MAX_PUBLICATIONS = 2000;
    private int publicationsNumber = 0;
    Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public Publication[] getPublications() {
        Publication[] result = new Publication[MAX_PUBLICATIONS];
        for (int i = 0; i < MAX_PUBLICATIONS; i++) {
            result[i] = publications[i];
        }
        return result;
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    public void addPublication(Publication publication) {
        if (publicationsNumber >= MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("Max publications exceeded " + MAX_PUBLICATIONS);
        } else {
            publications[publicationsNumber] = publication;
            publicationsNumber++;
        }
    }
}
