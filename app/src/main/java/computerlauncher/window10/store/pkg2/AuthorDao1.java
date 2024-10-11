package computerlauncher.window10.store.pkg2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AuthorDao1 {
    @Insert
    long  insert(Author1 author);

    @Query("SELECT * FROM authors")
    List<Author1> getAllAuthors();
}
