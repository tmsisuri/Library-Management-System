public class Book extends Item {

    private String author;
    private boolean isBorrowed;

    public Book(String author,String id, String title) {
        super(id, title);
        this.author = author;
        this.isBorrowed = false;
    }
    public void returnBook() {
        if(isBorrowed) {
            isBorrowed = false;
            System.out.println("Book returned Successfully");
        } else {
            System.out.println("This Book was not borrowed.");
        }
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getId() {
        return id;
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
        return book;
    }
}
