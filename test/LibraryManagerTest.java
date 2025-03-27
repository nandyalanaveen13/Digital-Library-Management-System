
import org.junit.jupiter.api.Test;
import services.LibraryManager;
import static org.junit.jupiter.api.Assertions.*;
public class LibraryManagerTest {
    @Test
    void testAddBook() {
        LibraryManager library = new LibraryManager();
        library.addBook("10", "Java Programming", "Naveen", "Education", true);
        assertTrue(library.findBookById("10").isPresent());
    }

    @Test
    void testDeleteBook() {
        LibraryManager library = new LibraryManager();
        library.addBook("12", "Python Basics", "Srikanth", "Education", true);
        library.deleteBook("12");
        assertFalse(library.findBookById("12").isPresent());
    }
}
