package computerlauncher.window10.store.pkg2;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GenreDao1 {
    @Insert
    long  insert(Genre1 genre);

    @Query("SELECT * FROM genres")
    List<Genre1> getAllGenres();
}
