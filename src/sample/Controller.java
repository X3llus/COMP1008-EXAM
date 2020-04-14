package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Arrays;

public class Controller {

    private String type;

    @FXML private TextField title;
    @FXML private DatePicker date;
    @FXML private RadioButton fiction;
    @FXML private RadioButton nonFiction;
    @FXML private ListView<Author> authors;
    @FXML private ListView<String> genres;
    @FXML private ListView<Book> books;
    @FXML private void initialize() {
        ToggleGroup group = new ToggleGroup();
        fiction.setToggleGroup(group);
        nonFiction.setToggleGroup(group);

        fiction.setSelected(true);
        setFiction();

        authors.getItems().addAll(Arrays.asList(new Author("Braden", "Coates", LocalDate.of(2001, 1, 1)),
                new Author("John", "Doe", LocalDate.of(1989, 4, 17)),
                new Author ("Randy", "Linx", LocalDate.of(1567, 11, 26))));
    }

    public void setFiction() {
        type = "fiction";
        genres.getItems().clear();
        genres.getItems().addAll(Genres.populateFictionGenres());
    }

    public void setNonFiction() {
        type = "non-fiction";
        genres.getItems().clear();
        genres.getItems().addAll(Genres.populateNonFictionGenres());
    }

    public void makeBook() {
        try {
            books.getItems().add(new Book(title.getText(), type, genres.getSelectionModel().getSelectedItem(), authors.getSelectionModel().getSelectedItem(), date.getValue()));
        } catch (IllegalArgumentException e) {

        }
    }
}
