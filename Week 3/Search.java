import java.util.List;
public class Search implements I_Searchable {
    private List<LibraryItem> libraryItems;

    public Search(List<LibraryItem> libraryItems) {
        this.libraryItems = libraryItems;
    }

    @Override
    public void searchItem(String title) {
        boolean found = false;
        for (LibraryItem item : libraryItems) {
            if (item instanceof Book book) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    found = true;
                    System.out.println("Item found: ");
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("ID: " + book.getItemID());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Available: " + book.isAvailable());
                }
            }
        }
        if (!found) {
            System.out.println("No item found with the title: " + title);
        }
    }

    @Override
    public void searchID(String id) {
        boolean found = false;
        for (LibraryItem item : libraryItems) {
            if (item instanceof Book book) {
                if (book.getItemID().equalsIgnoreCase(id)) {
                    found = true;
                    System.out.println("Item found: ");
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("ID: " + book.getItemID());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Available: " + book.isAvailable());
                }
            }
        }
        if (!found) {
            System.out.println("No item found with the ID: " + id);
        }
    }
}