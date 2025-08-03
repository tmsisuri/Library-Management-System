public class Book extends Item {

    private String author;
    private boolean isBorrowed;

    public Book(String id, String title , String author) {
        super(id, title);
        this.author = author;
        this.isBorrowed = false;
    }

    public void returnBook() {
        if(!isBorrowed) {
            System.out.println("Book was not borrowed");
        } else {
            isBorrowed = false;
            System.out.println("Book returned successfully");
        }
    }

    public void borrowBook() {
        if (isBorrowed) {
            System.out.println("Book is already borrowed");
        } else {
            isBorrowed = true;
            System.out.println("Book borrowed successfully");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("ID : " + id + "Title : " + title + "Status : " + (isBorrowed? "Borrowed" : "Available"));
    }

    public String toFileString() {
        return id + "," + title + "," + author + "," + isBorrowed;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",");
        Book book = new Book(parts[0], parts[1], parts[2]);
        book.isBorrowed = Boolean.parseBoolean(parts[3]);
        return book;
    }
}
