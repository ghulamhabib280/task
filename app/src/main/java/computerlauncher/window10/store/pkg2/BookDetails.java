package computerlauncher.window10.store.pkg2;

public class BookDetails {
    public String title;
    public String authorName;
    public String genreName;
    public int publicationYear;

    public BookDetails(String title, String authorName, String genreName, int publicationYear) {
        this.title = title;
        this.authorName = authorName;
        this.genreName = genreName;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getGenreName() {
        return genreName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

