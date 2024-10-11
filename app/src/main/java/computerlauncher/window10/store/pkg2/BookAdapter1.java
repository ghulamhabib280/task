package computerlauncher.window10.store.pkg2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter1 extends RecyclerView.Adapter<BookAdapter1.BookViewHolder> {
    private final List<BookDetails> bookDetailsList;

    public BookAdapter1(List<BookDetails> bookDetailsList) {
        this.bookDetailsList = bookDetailsList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        BookDetails bookDetails = bookDetailsList.get(position);
        holder.title.setText(bookDetails.title);
        holder.details.setText("Author: " + bookDetails.authorName + ", Genre: " + bookDetails.genreName + ", Year: " + bookDetails.publicationYear);
    }

    @Override
    public int getItemCount() {
        return bookDetailsList.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView details;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
            details = itemView.findViewById(android.R.id.text2);
        }
    }
}
