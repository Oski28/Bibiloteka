package Library.Model.Model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Publication implements Serializable,Comparable<Publication> {
    private int year;
    private String title;
    private String publisher;

    public Publication(String title, String publisher, int year) {
        this.year = year;
        this.title = title;
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getPublisher() {
        return publisher;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication that = (Publication) o;
        return year == that.year &&
                Objects.equals(title, that.title) &&
                Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, title, publisher);
    }

    @Override
    public String toString() {
        return title + ";" + publisher + ";" + year+";";
    }

    public abstract String toCsv();

    @Override
    public int compareTo(Publication o) {
        return title.compareToIgnoreCase(o.title);
    }
}