package sample;

import java.util.Arrays;
import java.util.List;

public class Genres {

    public static List<String> populateFictionGenres()
    {
        return Arrays.asList("Action and Adventure",
                "Alternate History", "Anthology", "Children's",
                "Comic Book","Coming-of-age", "Crime",
                "Drama","FairyTale","Fantasy","Graphic Novel",
                "Historical fiction","Horror","Mystery",
                "Paranormal Romance","Picture Book","Poetry",
                "Political Thriller","Satire","Science Fiction",
                "Short Story","Suspense","Thriller","Young Adult");
    }

    public static List<String> populateNonFictionGenres()
    {
        return Arrays.asList("Art","Autobiography",
                "Biography","Book Review","Cookbook","Diary",
                "Dictionary","Encyclopedia","Guide","Health",
                "History","Journal","Math","Memoir","Prayer",
                "Religion, spirituality, and new age","Textbook",
                "Review","Science","Self help","Travel","True Crime");
    }
}
