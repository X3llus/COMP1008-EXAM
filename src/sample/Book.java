package sample;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Book {
    private String title;
    private String type;
    private String genre;
    private Author author;
    private LocalDate releaseDate;

    public Book(String title, String type, String genre, Author author, LocalDate releaseDate) {
        setTitle(title);
        setType(type);
        setGenre(genre);
        setAuthor(author);
        setReleaseDate(releaseDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!isEmpty(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equalsIgnoreCase("fiction") || type.equalsIgnoreCase("non-fiction")) {
            this.type = type.toLowerCase();
        } else {
            throw new IllegalArgumentException("Type must be either fiction or non-fiction");
        }

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (getType().equals("fiction") && Genres.populateFictionGenres().contains(genre)) {
            this.genre = genre;
        } else if (getType().equals("non-fiction") && Genres.populateNonFictionGenres().contains(genre)) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("Genre is not in list of " + getType() + " genre's");
        }
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if (author != null) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Author was not entered");
        }
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) throws IllegalArgumentException {
        if (releaseDate.isBefore(LocalDate.now())) {
            this.releaseDate = releaseDate;
        } else {
            throw new IllegalArgumentException("Date must be in the past");
        }
    }

    @Override
    public String toString() {
        return getTitle() + ", " + getType() + "-" + getGenre() + ", author: " + getAuthor();
    }

    private boolean isEmpty(String input) {
        String regex = "^\\s*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }
}
