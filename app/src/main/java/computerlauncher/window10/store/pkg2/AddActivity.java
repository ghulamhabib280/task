package computerlauncher.window10.store.pkg2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import computerlauncher.window10.store.R;

public class AddActivity extends AppCompatActivity {

    private EditText authorName, authorNationality, authorBirthYear;
    private EditText genreName, genreDescription;
    private EditText bookTitle, bookYear;

    private AppDatabase1 database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Initialize Views
        authorName = findViewById(R.id.authorName);
        authorNationality = findViewById(R.id.authorNationality);
        authorBirthYear = findViewById(R.id.authorBirthYear);
        genreName = findViewById(R.id.genreName);
        genreDescription = findViewById(R.id.genreDescription);
        bookTitle = findViewById(R.id.bookTitle);
        bookYear = findViewById(R.id.bookYear);

        Button btnAddBook = findViewById(R.id.btnAddBook);

        // Get instance of the database
        database = AppDatabase1.getInstance(this);

        // Set click listener for Add Book button
        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
            }
        });
    }

    public void show(View v) {
        Intent intent = new Intent(AddActivity.this, ViewActivity.class);
        startActivity(intent);
    }

    private void addBook() {
        String authorNameText = authorName.getText().toString().trim();
        String nationality = authorNationality.getText().toString().trim();
        int birthYear = Integer.parseInt(authorBirthYear.getText().toString().trim());
        String genreNameText = genreName.getText().toString().trim();
        String genreDescriptionText = genreDescription.getText().toString().trim();
        String title = bookTitle.getText().toString().trim();
        int publicationYear = Integer.parseInt(bookYear.getText().toString().trim());

        // Create Author and Genre objects
        Author1 author = new Author1();
        author.setName(authorNameText);
        author.setNationality(nationality);
        author.setBirthYear(birthYear);

        Genre1 genre = new Genre1();
        genre.setName(genreNameText);
        genre.setDescription(genreDescriptionText);

        new Thread(() -> {
            // Insert Author and Genre
            long authorId = database.authorDao().insert(author); // Assuming insert returns the new row ID
            long genreId = database.genreDao().insert(genre); // Assuming insert returns the new row ID

            // Now create the Book object with the retrieved IDs
            Book1 book = new Book1();
            book.setTitle(title);
            book.setAuthorId((int) authorId); // Cast to int
            book.setGenreId((int) genreId); // Cast to int
            book.setPublicationYear(publicationYear);

            // Insert Book
            database.bookDao().insert(book);

            runOnUiThread(() -> Toast.makeText(AddActivity.this, "Book added", Toast.LENGTH_SHORT).show());
        }).start();
    }
}
