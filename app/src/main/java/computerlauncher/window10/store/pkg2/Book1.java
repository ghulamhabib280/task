package computerlauncher.window10.store.pkg2;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "books",
        foreignKeys = {
                @ForeignKey(entity = Author1.class,
                        parentColumns = "id",
                        childColumns = "authorId",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Genre1.class,
                        parentColumns = "id",
                        childColumns = "genreId",
                        onDelete = ForeignKey.CASCADE)
        })
public class Book1 {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private int authorId; // Foreign key
    private int genreId;  // Foreign key
    private int publicationYear;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }
    public int getGenreId() { return genreId; }
    public void setGenreId(int genreId) { this.genreId = genreId; }
    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
}
