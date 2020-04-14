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
            this.type = type;
        } else {
            throw new IllegalArgumentException("");
        }

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
        return "Book{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", genre='" + genre + '\'' +
                ", author=" + author +
                ", releaseDate=" + releaseDate +
                '}';
    }

    private boolean isEmpty(String input) {
        String regex = "^\\s*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }
}
