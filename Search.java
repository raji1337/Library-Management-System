import java.io.*;
import java.util.*;
public class Search {
    private static Writer tempWriter = new Writer();
    // All Authors
    public void printAuthors(File library) throws IOException {
        List<String> authors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(tempWriter.getLibrary_file()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                authors.add(columns[2].trim());
            }
        }
        System.out.println("Authors found within the database:");
        for (String author : authors) {
            System.out.println(author);
        }
        System.out.println();
    }

    // Specific Author
    public void searchAuthors(File library, String authorName) throws LibraryException, IOException {
        StringBuilder result = new StringBuilder();
        boolean authorFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader(library))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[2].trim().contains(authorName)) {
                    result.append(columns[2].trim()).append("\n");
                    authorFound = true;
                }
            }
        }
        if (!authorFound) {
            throw new LibraryException(LibraryExceptionMessages.errors[4]);
        } else {
            System.out.println("Author found: " + result);
        }
    }

    // All Books
    public void printBooks(File library) throws IOException {
        List<String> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(tempWriter.getLibrary_file()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                books.add(columns[1].trim());
            }
        }
        System.out.println("Books found within the database:");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    // Specific Book
    public void searchBooks(File library, String bookName) throws LibraryException, IOException {
        StringBuilder result = new StringBuilder();
        boolean bookFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader(library))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[1].trim().contains(bookName)) {
                    result.append(columns[1].trim()).append(" | #").append(columns[0].trim()).append("\n"); // Book + Book ID
                    bookFound = true;
                }
            }
        }
        if (!bookFound) {
            throw new LibraryException(LibraryExceptionMessages.errors[3]);
        } else {
            System.out.println("Book found: " + result);
        }
    }
}