import java.util.List;
public class BookDisplay {
    // READ
    public void displayCategory(Book book) {
        System.out.println("---- BOOK CATEGORIES -----");
        for (int i = 0; i < book.getCategories().length; i++) {
            System.out.println("[" + (i + 1) + "]: " + book.getCategories()[i]);
        }
        System.out.println("--------------------");
    }

    public void displayLibraryItems(List<LibraryItem> libraryItems) {
        if (libraryItems.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }
        for (LibraryItem item : libraryItems) {
            System.out.println("Item ID: " + item.getItemID() + ", Title: " + item.getTitle() + ", Author: " + item.getAuthor() + ", Status: " + (item.isAvailable() ? "Available" : "Unavailable"));
        }
    }

    public void displayBooks(List<LibraryItem> libraryItems) {
        System.out.println("----- LIBRARY ITEMS -----");
        for (LibraryItem item : libraryItems) {
            System.out.println(item.getTitle() + " (ID: " + item.getItemID() + ")");
        }
        System.out.println("--------------------");
    }
}