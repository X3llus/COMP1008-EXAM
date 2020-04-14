package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.time.LocalDate;
import java.util.Arrays;

public class Controller {

    @FXML private RadioButton fiction;
    @FXML private RadioButton nonFiction;
    @FXML private ListView<Author> authors;
    @FXML private ListView<String> genres;
    @FXML private ListView<Book> books;
    @FXML private void initialize() {
        ToggleGroup group = new ToggleGroup();
        fiction.setToggleGroup(group);
        nonFiction.setToggleGroup(group);

        authors.getItems().addAll(Arrays.asList(new Author("Braden", "Coates", LocalDate.of(2001, 1, 1)),
                new Author("John", "Doe", LocalDate.of(1989, 4, 17)),
                new Author ("Randy", "Linx", LocalDate.of(1567, 11, 26))));
    }
}
