package Articles;

public class Articles {
    private String title;
    private String content;
    private String author;

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String newContent) {
        this.content = newContent;
    }

    public void changeAutor(String newAutor) {
        this.author = newAutor;
    }

    public void rename(String newTitle) {
        this.title = newTitle;
    }

    @Override
    public String toString() {
        String result = String.format("%s - %s: %s", this.title, this.content, this.author);
        return result;
    }
}
