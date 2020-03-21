package Library.Model.IO.File;

import Library.Model.Model.*;
import Library.Model.Exception.DataExportException;
import Library.Model.Exception.DataImportException;
import Library.Model.Exception.InvalidDataException;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager implements FileManager {
    private static final String PUBLICATIONS_FILE_NAME = "Library.csv";
    private static final String USERS_FILE_NAME="Library_user.csv";

    @Override
    public void exportData(Library library) {
        exportPublications(library);
        exportUsers(library);
    }

    @Override
    public Library importData() {
        Library library = new Library();
        importPublications(library);
        importUsers(library);
        return library;
    }

    private void exportPublications(Library library){
        Collection<Publication> publications=library.getPublications().values();
        exportToCsv(publications,PUBLICATIONS_FILE_NAME);
    }

    private void exportUsers(Library library){
        Collection<LibraryUser> libraryUsers=library.getUsers().values();
        exportToCsv(libraryUsers,USERS_FILE_NAME);
    }

    private <T extends CsvConvertible> void exportToCsv(Collection<T> collection,String fileName){
        try(
                FileWriter fileWriter=new FileWriter(fileName);
                BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                ) {
            for (T t : collection) {
                bufferedWriter.write(t.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Bład zapisu danych do pliku "+fileName);
        }
    }

    private Publication createObjectFromString(String csvText) {
        String[] split = csvText.split(";");
        String type = split[0];
        if(Book.TYPE.equals(type)) {
            return createBook(split);
        } else if(Magazine.TYPE.equals(type)) {
            return createMagazine(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji: " + type);
    }

    private Book createBook(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String author = data[4];
        int pages = Integer.valueOf(data[5]);
        String isbn = data[6];
        return new Book(title, author, year, pages, publisher, isbn);
    }

    private Magazine createMagazine(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];
        return new Magazine(title, publisher, language, year, month, day);
    }

    private void importPublications(Library library){
        try( Scanner scanner=new Scanner(new File(PUBLICATIONS_FILE_NAME))) {
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                Publication publication=createObjectFromString(line);
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku "+PUBLICATIONS_FILE_NAME);
        }
    }

    private void importUsers(Library library){
        try(
                Scanner scanner=new Scanner(new File(USERS_FILE_NAME));
                ) {
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                LibraryUser libraryUser=createUserFromString(line);
                library.addUser(libraryUser);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku "+USERS_FILE_NAME);
        }
    }

    private LibraryUser createUserFromString(String csvText) {
        String[] split=csvText.split(";");
        String firstName=split[0];
        String secondName=split[1];
        String pesel=split[2];
        return new LibraryUser(firstName,secondName,pesel);
    }

}