import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Book> book = new ArrayList<>();
    static ArrayList<User> user = new ArrayList<>();
    static User loggedInUser = null;

    static final String BOOK_FILE = "book.txt";
    static final String USER_FILE = "User.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        loadUserFromFile();
        loadBooksFromFile();

        if(!login()) {
            return;
        }

        if(loggedInUser.getRole().equalsIgnoreCase("librarian")) {
            librarianMenu();
        } else {
            userMenu();
        }
    }
    static boolean login() {
        System.out.println("Welcome to Library Management System");
        System.out.println("User Name : ");
        String userName = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();

        for(User u : users) {
            if(u.getUsername().equals(userName) && u.getPassword().equals(password)) {
                loggedInUser = u;
                System.out.println("LoginSuccessful as " + u.getRole().toUpperCase());
                return true;
            }
        }

        System.out.println("Invalid Credentials.");
        return false;
    }
}
static void librarianMenu() {
    int choice;
    do {
        System.out.println("\n--- 📖 Librarian Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Display Books");
        System.out.println("3. Save and Exit");
        System.out.print("Enter choice: ");
        try {
            choice = Integer.parseInt(Main.scanner.nextLine());
            switch (choice) {
                case 1 :
                    addBook();
                    break;
                case 2 :
                    displayBooks();
                    break;
                case 3 :
                    saveBooksToFile();
                    break;
                default :
                    System.out.println("Invalid Choice");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            choice = 0;
        }
    } while (choice != 3);
}

static void userMenu() {
    int choice;

    do {
        System.out.println("User Menu");
        System.out.println("1. Display Books");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Save and Exit");
        System.out.print("Enter choice: ");
        try {
            choice = Integer.parseInt(Main.scanner.nextLine());
            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    saveBooksToFile();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
            choice = 0;
        }
    } while (choice != 4);
}

static void addBook() {
    System.out.println("Enter Book ID : ");
    String id = Main.scanner.nextLine();
    System.out.print("Enter Title: ");
    String title = Main.scanner.nextLine();
    System.out.print("Enter Author: ");
    String author = Main.scanner.nextLine();
    books.add(new Book(id, title, author));
    System.out.println("✅ Book added.");
}