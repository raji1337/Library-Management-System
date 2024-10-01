import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Circulation extends Writer {
    private Library library;

    public Circulation(Library library, String library_file, String users_file) {
        this.library = library;
        this.library_file = new File(library_file);
        this.users_file = new File(users_file);
    }

    public void saveUpdatedBooks(List<Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(library_file, false))) {
            for (Book book : books) {
                bw.write(book.getBookID() + "," +
                        book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.getCategory() + "," +
                        book.getStatus() + "," +
                        (book.getReservedByUserID() == null ? "" : book.getReservedByUserID()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public void borrowBook(Book book, User user) {
        if (book.getStatus().equals("Available")) {
            book.setStatus("Borrowed");
            book.setReservedByUserID(user.getUsername());
            saveUpdatedBooks(library.getBooks());
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (book.getStatus().equals("Borrowed")) {
            book.setStatus("Available");
            book.setReservedByUserID(null);
            System.out.println("Book returned successfully.");
            writeToFileBooks(library.getBooks());
        } else {
            System.out.println("Book is not borrowed.");
        }
    }

    public void reserveBook(Book book, User user) {
        if (book.getStatus().equals("Available")) {
            book.setStatus("Reserved");
            book.setReservedByUserID(user.getUsername());
            System.out.println("Book reserved successfully.");
            writeToFileBooks(library.getBooks());
        } else {
            System.out.println("Book is not available for reservation.");
        }
    }

    public void cancelReservation(Book book, User user) {
        if (book.getStatus().equals("Reserved") && book.getReservedByUserID().equals(user.getUsername())) {
            book.setStatus("Available");
            book.setReservedByUserID(null);
            System.out.println("Reservation cancelled successfully.");
            writeToFileBooks(library.getBooks());
        } else {
            System.out.println("Book is not reserved by this user.");
        }
    }

    public List<Book> getBorrowedBooks(User user) {
        List<Book> borrowedBooks = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getStatus().equals("Borrowed") && book.getReservedByUserID().equals(user.getUsername())) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    public List<Book> getReservedBooks(User user) {
        List<Book> reservedBooks = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getStatus().equals("Reserved") && book.getReservedByUserID().equals(user.getUsername())) {
                reservedBooks.add(book);
            }
        }
        return reservedBooks;
    }
}