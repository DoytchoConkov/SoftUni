package Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> autors;

    public Book(String title, int year, String... autors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAutors(autors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAutors(String... autors) {
        if (autors.length == 0) {
            this.autors = new ArrayList<>();
        } else {
            this.autors = new ArrayList<>(Arrays.asList(autors));
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return autors;
    }
}
