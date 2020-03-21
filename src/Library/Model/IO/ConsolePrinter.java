package Library.Model.IO;

import Library.Model.Model.Book;
import Library.Model.Model.LibraryUser;
import Library.Model.Model.Magazine;
import Library.Model.Model.Publication;

import java.util.Collection;

public class ConsolePrinter {
    public void printBooks(Collection<Publication> publications){
        int counter=0;
        for (Publication publication:publications){
            if (publication instanceof Book){
                printLine(publication.toString());
                counter++;
            }
        }
        if (counter==0)
            System.out.println("Brak książek w bibliotece.");
    }

    public void printMagazines(Collection<Publication> publications){
        int counter=0;
        for (Publication publication:publications){
            if (publication instanceof Magazine){
                printLine(publication.toString());
                counter++;
            }
        }
        if (counter==0)
            System.out.println("Brak magazynów w bibliotece.");
    }

    public void printUsers(Collection<LibraryUser > libraryUsers){
        for (LibraryUser libraryUser : libraryUsers) {
            printLine(libraryUser.toString());
        }
    }

    public void printLine(String text){
        System.out.println(text);
    }
}
