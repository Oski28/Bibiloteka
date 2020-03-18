package Library.Model.IO;

import Library.Model.Book;
import Library.Model.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;
    public void close() {
        scanner.close();
    }

    public DataReader (ConsolePrinter printer){
        this.printer=printer;
    }

    public String getString(){
        return scanner.nextLine();
    }

    public int getInt() {
        try {
            return scanner.nextInt();
        }  catch (InputMismatchException e){
            throw e;
            }
        finally {
            scanner.nextLine();
        }
    }

    public Book readAndCreateBook() {
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj autora: ");
        String author = scanner.nextLine();
        System.out.println("Podaj rok wydania: ");
        int releaseDate = getInt();
        System.out.println("Podaj ilość stron: ");
        int pages = getInt();
        System.out.println("Podaj wydawnictwo: ");
        String publisher = scanner.nextLine();
        System.out.println("Podaj ISBN: ");
        String isbn = scanner.nextLine();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Podaj tytuł:");
        String title = scanner.nextLine();
        System.out.println("Podaj wydawnictwo:");
        String publisher = scanner.nextLine();
        System.out.println("Podaj język:");
        String language = scanner.nextLine();
        System.out.println("Podaj rok wydania:");
        int year = getInt();
        System.out.println("Podaj miesiąc wydania:");
        int month = getInt();
        System.out.println("Podaj dzień wydania:");
        int day = getInt();

        return new Magazine(title, publisher, language, year, month, day);
    }
}
