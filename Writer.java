import java.io.*;
import java.util.*;
public class Writer {
    protected File library_file = new File("library.csv");
    protected File users_file = new File("users.csv");

    public File getLibrary_file() {
        return library_file;
    }

    public File getUsers_file() {
        return users_file;
    }

    public void writeToFileBooks(List<Book> books) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(this.library_file, true))) {
            for (Book book : books) {
                pw.printf("%s,%s,%s,%s,%s,%s%n",
                        book.getBookID(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getCategory(),
                        book.getStatus(),
                        book.getReservedByUserID()
                );
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void writeToFileUsers(List<User> users) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(this.users_file, true))) {
            for (User user : users) {
                pw.printf("%s,%s,%s%n", 
                    user.getUsername(), 
                    user.getPassword(),
                    user.getName());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}