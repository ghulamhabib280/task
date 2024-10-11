package computerlauncher.window10.store.pkg2;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class BookViewModelFactory1 implements ViewModelProvider.Factory {
    private final AppDatabase1 database;

    public BookViewModelFactory1(AppDatabase1 database) {
        this.database = database;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BookViewModel1.class)) {
            return (T) new BookViewModel1(database);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

