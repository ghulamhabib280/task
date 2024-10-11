package computerlauncher.window10.store.pkg2;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;



import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Book1.class, Author1.class, Genre1.class}, version = 5)
public abstract class AppDatabase1 extends RoomDatabase {
    public abstract BookDao1 bookDao();
    public abstract AuthorDao1 authorDao();
    public abstract GenreDao1 genreDao();

    private static AppDatabase1 instance;

    public static final Migration MIGRATION_1_5 = new Migration(1, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `authors` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `nationality` TEXT, `birthYear` INTEGER)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `genres` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `description` TEXT)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `books` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `authorId` INTEGER, `genreId` INTEGER, `publicationYear` INTEGER, FOREIGN KEY(`authorId`) REFERENCES `authors`(`id`), FOREIGN KEY(`genreId`) REFERENCES `genres`(`id`))");
        }
    };

    public static synchronized AppDatabase1 getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase1.class, "app_database")
                    .addMigrations(MIGRATION_1_5)
                    .build();
        }
        return instance;
    }
}


