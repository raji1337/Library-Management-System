import java.util.*;
public class Library {
    private static Scanner input = new Scanner(System.in);
    private List<Book> books = new ArrayList<Book>();
    private List<User> users = new ArrayList<User>();

    public List<Book> getBooks() {
        return books;
    }
    public List<User> getUsers() {
        return users;
    }

    public void addBook(Book book) {
        Book tempBook = new Book();
        char choice;
        System.out.println("----- BOOK INPUT -----");
        System.out.print("Enter book ID >> "); tempBook.setBookID(input.nextInt()); input.nextLine();
        System.out.print("Enter book title >> "); tempBook.setTitle(input.nextLine());
        System.out.print("Enter book author >> "); tempBook.setAuthor(input.nextLine());
        tempBook.displayCategory();
        System.out.print("Enter book category >> "); int index = input.nextInt() - 1;
        tempBook.setCategory(index);
        System.out.println("[A] Available || [B] Unavailable"); 
        do {
            System.out.print("Enter book status >> "); choice = input.next().toUpperCase().charAt(0);
        } while (choice != 'A' && choice != 'B');
        if (choice == 'A') {tempBook.setStatus("Available");} else {tempBook.setStatus("Unavailable");}
        books.add(tempBook);
    }

    public void displayBook(List<Book> books) {
        System.out.println();
        for (Book book : books) {
            System.out.println("----- BOOK DISPLAY -----");
            System.out.println("Book ID: " + book.getBookID());
            System.out.println("Book title: " + book.getTitle());
            System.out.println("Book author: " + book.getAuthor());
            System.out.println("Book category: " + book.getCategory());
            System.out.println("Book status: " + book.getStatus());
        }
    }

    public void registerUser(User user) {
        User tempUser = new User();
        input.nextLine();
        System.out.println();
        System.out.println("----- REGISTER USER -----");
        System.out.print("Enter username >> "); tempUser.setUsername(input.nextLine());
        System.out.print("Enter password >> "); tempUser.setPassword(input.nextLine());
        System.out.print("Enter name >> "); tempUser.setName(input.nextLine());
        users.add(tempUser);
    }

    // ----- UPDATE -----
    public void updateBookID(Book book, int newID) {
        book.setBookID(newID);
    }

    public void updateBookTitle(Book book, String newTitle) {
        if (newTitle == null || newTitle.isEmpty()) {
            System.out.println("Error: New title cannot be empty.");
            return;
        }
        book.setTitle(newTitle);
    }

    public void updateBookAuthor(Book book, String newAuthor) {
        book.setAuthor(newAuthor);
    }

    public void updateBookCategory(Book book, String newCategory) {
        book.setCategory(newCategory);
    }

    public void updateBookStatus(Book book, String newStatus) {
        book.setStatus(newStatus);
    }

    public void updateBookReservedByUserID(Book book, String newReservedByUserID) {
        book.setReservedByUserID(newReservedByUserID);
    }

    public void updateUsername(User user, String newUsername) {
        user.setUsername(newUsername);
    }

    public void updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
    }

    public void updateName(User user, String newName) {
        user.setName(newName);
    }


    // ----- DELETE -----
    public void deleteBook(Book book) {
        books.remove(book);
    }

    public void deleteBook(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                books.remove(book);
                System.out.println("Book successfully deleted.");
                return;
            }
        }
        System.out.println("Error: Book not found.");
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void deleteUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                System.out.println("User successfully deleted.");
                return;
            }
        }
        System.out.println("Error: User not found.");
    }
}