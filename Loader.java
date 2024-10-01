import java.io.*;
import java.util.*;
public class Loader extends Writer {
    private Library library;
    public Loader(Library library) {
        this.library = library;
    }

    public void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(getLibrary_file()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 6) {
                    Book book = new Book();
                    book.setBookID(Integer.parseInt(columns[0].trim()));
                    book.setTitle(columns[1].trim());
                    book.setAuthor(columns[2].trim());
                    book.setCategory(columns[3].trim());
                    book.setStatus(columns[4].trim());
                    book.setReservedByUserID(columns[5].trim());
                    library.getBooks().add(book);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }

    public void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(getUsers_file()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 3) {
                    User user = new User();
                    user.setUsername(columns[0].trim());
                    user.setPassword(columns[1].trim());
                    user.setName(columns[2].trim());
                    library.getUsers().add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    public void saveBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(getLibrary_file()));
            BufferedWriter bw = new BufferedWriter(new FileWriter(getLibrary_file(), false))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                boolean found = false;
                for (Book book : library.getBooks()) {
                    if (columns[0].equals(String.valueOf(book.getBookID()))) {
                        lines.add(book.getBookID() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getCategory() + "," + book.getStatus() + "," + book.getReservedByUserID());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    lines.add(line);
                }
            }
            for (Book book : library.getBooks()) {
                boolean found = false;
                for (String l : lines) {
                    String[] columns = l.split(",");
                    if (columns[0].equals(String.valueOf(book.getBookID()))) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    lines.add(book.getBookID() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getCategory() + "," + book.getStatus() + "," + book.getReservedByUserID());
                }
            }
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public void saveUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(getUsers_file()));
            BufferedWriter bw = new BufferedWriter(new FileWriter(getUsers_file(), false))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                boolean found = false;
                for (User user : library.getUsers()) {
                    if (columns[0].equals(user.getUsername())) {
                        lines.add(user.getUsername() + "," + user.getPassword() + "," + user.getName());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    lines.add(line);
                }
            }
            for (User user : library.getUsers()) {
                boolean found = false;
                for (String l : lines) {
                    String[] columns = l.split(",");
                    if (columns[0].equals(user.getUsername())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    lines.add(user.getUsername() + "," + user.getPassword() + "," + user.getName());
                }
            }
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}