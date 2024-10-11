package computerlauncher.window10.store.pkg2;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class BookViewModel1 extends ViewModel {
    private BookRepository1 repository;
    private LiveData<List<BookDetails>> allBookDetails;

    public BookViewModel1(AppDatabase1 database) {
        repository = new BookRepository1(database);
        allBookDetails = repository.getBookDetails(); // Fetch book details directly as LiveData
    }

    public LiveData<List<BookDetails>> getAllBookDetails() {
        return allBookDetails;
    }

    public void insert(Book1 book) {
        repository.insertBook(book);
    }
}

