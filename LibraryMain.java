import java.util.*;
import java.io.*;
public class LibraryMain {
    public static void main(String[] args) throws IOException {
        Book book = new Book();
        User user = new User();
        Library library = new Library();
        Loader loader = new Loader(library);
        Writer writer = new Writer();
        Circulation circulation = new Circulation(library, "library.csv", "users.csv");
        loader.loadBooks();
        loader.loadUsers();
    
        // System.out.println("----- CREATE OPERATIONS -----");
        // library.addBook(book);
        // library.registerUser(user);
        // writer.writeToFileBooks(library.getBooks());
        // writer.writeToFileUsers(library.getUsers());
        // System.out.println();
    
        // System.out.println("----- READ OPERATIONS -----");
        // library.displayBook(library.getBooks());
        // System.out.println();

        // System.out.println("----- UPDATE OPERATIONS -----");
        // Book tempBook = library.getBooks().get(0);
        // User tempUser = library.getUsers().get(0);
        // circulation.borrowBook(tempBook, tempUser);
    
        // System.out.println("----- DELETE OPERATIONS -----");
        // Book tempBook = library.getBooks().get(0);
        // library.deleteBook(tempBook.getBookID());
        // loader.saveBooks();
        
        // User tempUser = library.getUsers().get(0);
        // library.deleteUser(tempUser.getUsername());
        // loader.saveUsers();
    }
}