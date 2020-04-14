import org.junit.Before;
import org.junit.Test;
import sample.Author;
import sample.Book;
import sample.Genres;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        Author author = new Author("Fred","Flintstone", LocalDate.of(1986,02,03));
        book = new Book("Rock Crushing","Non-Fiction","Diary",author,
                LocalDate.of(1983,02,03));
    }

    @Test
    public void setReleaseDate() {
        LocalDate expResult = LocalDate.of(1986,02,02);
        book.setReleaseDate(LocalDate.of(1986,02,02));
        assertEquals(expResult, book.getReleaseDate());
    }

    @Test
    public void setReleaseDateInvalidFuture() {
        try{
            book.setReleaseDate(LocalDate.now().plusYears(2));
            fail("release date in the future should fail");
        }catch (IllegalArgumentException e)
        {
            System.out.println("Correctly identified invalid date");
        } catch(Exception e)
        {
            fail("Wrong exception thrown for invalid release date");
        }
    }

    @Test
    public void setTitle() {
        book.setTitle("New title");
        String expResult = "New title";
        assertEquals(expResult, book.getTitle());
    }

    @Test
    public void setTitleInvalid() {
        try{
            book.setTitle("");
            fail("empty title should have triggered an exception");
        }catch (IllegalArgumentException e)
        {
            System.out.println("Correctly identified invalid title");
        } catch(Exception e)
        {
            fail("Wrong exception thrown for invalid title");
        }
    }

    @Test
    public void setTypeFiction() {
        book.setType("Fiction");
        String expResult = "fiction";
        assertEquals(expResult, book.getType());
    }

    @Test
    public void setTypeNonFiction() {
        book.setType("Non-Fiction");
        String expResult = "non-fiction";
        assertEquals(expResult, book.getType());
    }

    @Test
    public void setTypeNonFictionInvalid() {
        try{
            book.setType("happy");
            fail("invalid type should have triggered an exception");
        }catch (IllegalArgumentException e)
        {
            System.out.println("Correctly identified invalid type");
        } catch(Exception e)
        {
            fail("Wrong exception thrown for invalid type");
        }
    }

    @Test
    public void setGenreFiction() {
        book.setType("fiction");
        for (String genre: Genres.populateFictionGenres())
        {
            try {
                book.setGenre(genre);
            }catch(Exception e)
            {
                fail("Improperly triggered an exception for type fiction, genre: "+genre);
            }
        }
    }

    @Test
    public void setGenreFictionInvalid() {
        book.setType("fiction");
        for (String genre:Genres.populateNonFictionGenres())
        {
            try {
                book.setGenre(genre);
                fail(String.format("fiction should not allow %s as a genre",genre));
            }catch(Exception e)
            {
                System.out.printf("Correctly identified %s cannot add %s%n", book.getType(), genre);
            }
        }
    }

    @Test
    public void setGenreNonFictionInvalid() {
        book.setType("non-fiction");
        for (String genre:Genres.populateFictionGenres())
        {
            try {
                book.setGenre(genre);
                fail(String.format("non-fiction should not allow %s as a genre",genre));
            }catch(Exception e)
            {
                System.out.printf("Correctly identified %s cannot add %s%n", book.getType(), genre);
            }
        }
    }

    @Test
    public void setAuthor() {
        Author author2 = new Author("Kermit","The Frog",LocalDate.of(1987,02,3));
        book.setAuthor(author2);
        assertEquals(author2, book.getAuthor());
    }

    @Test
    public void setAuthorInvalid() {
        Author author2 = null;
        try {
            book.setAuthor(author2);
            fail("null author should trigger an exception");
        } catch(IllegalArgumentException e)
        {
            System.out.println("properly caught null author: " +e.getMessage());
        }
        catch (Exception e)
        {
            fail("wrong exception thrown will null author passed into setAuthor()");
        }
    }

    @Test
    public void testToString() {
        String expResult = "Rock Crushing, non-fiction-Diary, author: Fred Flintstone aged: 34";
        assertEquals(expResult, book.toString());
    }
}