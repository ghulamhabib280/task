package computerlauncher.window10.store.pkg2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao1 {
    @Insert
    void insert(Book1 book);
    @Query("SELECT b.title, a.name AS authorName, g.name AS genreName, b.publicationYear " +
            "FROM books b " +
            "JOIN authors a ON b.authorId = a.id " +
            "JOIN genres g ON b.genreId = g.id")
    LiveData<List<BookDetails>> getBookDetails(); // Ensure this returns LiveData<List<BookDetails>>

    @Query("SELECT * FROM books") // Ensure table name matches
    LiveData<List<Book1>> getAllBooks(); // Change return type to LiveData
    @Query("SELECT * FROM books WHERE authorId = :authorId")
    List<Book1> getBooksByAuthor(int authorId);

    @Query("SELECT * FROM books WHERE genreId = :genreId")
    List<Book1> getBooksByGenre(int genreId);

    @Query("SELECT * FROM books WHERE publicationYear = :year")
    List<Book1> getBooksByPublicationYear(int year);

    @Query("SELECT * FROM books WHERE authorId IN (SELECT id FROM authors WHERE nationality = :nationality)")
    List<Book1> getBooksByAuthorNationality(String nationality);

    // Add more complex queries as needed
}

