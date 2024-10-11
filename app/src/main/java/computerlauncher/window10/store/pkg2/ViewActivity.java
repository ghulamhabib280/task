package computerlauncher.window10.store.pkg2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import computerlauncher.window10.store.R;

public class ViewActivity extends AppCompatActivity {
    private EditText editTextAuthorName, editTextGenre, editTextPublicationYear;

    private RecyclerView recyclerViewBooks;
    private BookAdapter1 bookAdapter;
    private BookViewModel1 bookViewModel;
    List<BookDetails> search;
    List<BookDetails> bookDetailss;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerViewBooks = findViewById(R.id.recyclerViewBooks);
        recyclerViewBooks.setLayoutManager(new LinearLayoutManager(this));
        editTextAuthorName = findViewById(R.id.editTextAuthorName);
        editTextGenre = findViewById(R.id.editTextGenre);
        editTextPublicationYear = findViewById(R.id.editTextPublicationYear);

        // Initialize ViewModel with Factory
        AppDatabase1 database = AppDatabase1.getInstance(this);
        bookViewModel = new ViewModelProvider(this, new BookViewModelFactory1(database)).get(BookViewModel1.class);

        // Observe the LiveData from ViewModel
        bookViewModel.getAllBookDetails().observe(this, new Observer<List<BookDetails>>() {
            @Override
            public void onChanged(List<BookDetails> bookDetails) {
                bookDetailss=bookDetails;
                bookAdapter = new BookAdapter1(bookDetails);
                recyclerViewBooks.setAdapter(bookAdapter);
            }
        });
        editTextAuthorName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence query, int start, int before, int count) {
                String name;
                search=new ArrayList<BookDetails>();
                for (int i = 0; i < bookDetailss.size(); i++) {
                    Toast.makeText(ViewActivity.this, ""+bookDetailss.get(i).authorName, Toast.LENGTH_SHORT).show();
                    name = bookDetailss.get(i).authorName.toLowerCase();
                    if (query != null && name.contains(query.toString().toLowerCase())) {
                        search.add(bookDetailss.get(i));
                    }
                }
                bookAdapter = new BookAdapter1(search);
                recyclerViewBooks.setAdapter(bookAdapter);
                }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        editTextGenre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence query, int start, int before, int count) {
                String name;
                search=new ArrayList<BookDetails>();
                for (int i = 0; i < bookDetailss.size(); i++) {
                     name = bookDetailss.get(i).genreName.toLowerCase();
                    if (query != null && name.contains(query.toString().toLowerCase())) {
                        search.add(bookDetailss.get(i));
                    }
                }
                bookAdapter = new BookAdapter1(search);
                recyclerViewBooks.setAdapter(bookAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        editTextPublicationYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence query, int start, int before, int count) {
                String name;
                search=new ArrayList<BookDetails>();
                for (int i = 0; i < bookDetailss.size(); i++) {
                     name = String.valueOf(bookDetailss.get(i).publicationYear);
                    if (query != null && name.contains(query.toString().toLowerCase())) {
                        search.add(bookDetailss.get(i));
                    }
                }
                bookAdapter = new BookAdapter1(search);
                recyclerViewBooks.setAdapter(bookAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
     }
}
