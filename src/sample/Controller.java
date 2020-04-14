package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Controller {

    private String type;

    @FXML private TextField txt_title;
    @FXML private Label lbl_error;
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

    private boolean isEmpty(String input) {
        String regex = "^\\s*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
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
            books.getItems().add(new Book(txt_title.getText(), type, genres.getSelectionModel().getSelectedItem(), authors.getSelectionModel().getSelectedItem(), date.getValue()));
        } catch (IllegalArgumentException e) {
            StringBuilder err = new StringBuilder();
            if (isEmpty(txt_title.getText())) {
                err.append("title ");
            }
            if (!type.equalsIgnoreCase("fiction") && !type.equalsIgnoreCase("non-fiction")) {
                err.append("type ");
            }
            if (!(type.equalsIgnoreCase("fiction") && Genres.populateFictionGenres().contains(genres.getSelectionModel().getSelectedItem())) || !(type.equalsIgnoreCase("non-fiction") && Genres.populateFictionGenres().contains(genres.getSelectionModel().getSelectedItem()))) {
                err.append("genre ");
            }
            if (authors.getSelectionModel().getSelectedItem() == null) {
                err.append("author ");
            }
            if (date.getValue() == null || date.getValue().isAfter(LocalDate.now())) {
                err.append("date ");
            }
            err.append("are invalid.");
            lbl_error.setText(err.toString());
        }
    }
}
