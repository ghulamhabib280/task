package computerlauncher.window10.store.pkg2;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookRepository1 {
    private BookDao1 bookDao;
    private AuthorDao1 authorDao;
    private GenreDao1 genreDao;

    public BookRepository1(AppDatabase1 database) {
        this.bookDao = database.bookDao();
        this.authorDao = database.authorDao();
        this.genreDao = database.genreDao();
    }

    public void insertBook(Book1 book) {
        bookDao.insert(book);
    }
    public LiveData<List<BookDetails>> getBookDetails() {
        // Use the DAO method to fetch book details
        return bookDao.getBookDetails();
    }
    public LiveData<List<Book1>> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public List<Book1> getBooksByAuthor(int authorId) {
        return bookDao.getBooksByAuthor(authorId);
    }

    public List<Book1> getBooksByGenre(int genreId) {
        return bookDao.getBooksByGenre(genreId);
    }

    public List<Book1> getBooksByPublicationYear(int year) {
        return bookDao.getBooksByPublicationYear(year);
    }

    public List<Book1> getBooksByAuthorNationality(String nationality) {
        return bookDao.getBooksByAuthorNationality(nationality);
    }
}
