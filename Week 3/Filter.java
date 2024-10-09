import java.util.List;
public class Filter implements I_Filterable {
    private final List<LibraryItem> libraryItems;

    public Filter(List<LibraryItem> libraryItems) {
        this.libraryItems = libraryItems;
    }

    @Override
    public void filterAuthor(String author) {
        boolean found = false;
        int ctr = 1;
        for (LibraryItem item : libraryItems) {
            if (item instanceof Book book) { 
                
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    found = true;
                    
                    System.out.println("Book " + ctr);
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("ID: " + book.getItemID());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Available: " + book.isAvailable() +"\n");
                    ctr++;
                }
            }
        }
        if (!found) {
            System.out.println("No item found with the author: " + author);
        }
    }

    @Override
    public void filterCategory(String category) {
        boolean found = false;
        int ctr = 1;
        for (LibraryItem item : libraryItems) {
            if (item instanceof Book book) {
                if (book.getCategory().equalsIgnoreCase(category)) {
                    found = true;
                    System.out.println("Book " + ctr);
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("ID: " + book.getItemID());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Available: " + book.isAvailable() + "\n");
                    ctr++;
                }
            }
        }
        if (!found) {
            System.out.println("No items found in the category: " + category);
        }
    }
    

    @Override
    public void filterAvailability(boolean isAvailable) {
        boolean found = false;
        int ctr = 1;
        for (LibraryItem item : libraryItems) {
            if (item instanceof Book book) {
                if (book.isAvailable() == isAvailable) {
                    found = true;
                    System.out.println("Book " + ctr);
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("ID: " + book.getItemID());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Category: " + book.getCategory() + "\n");
                    ctr++;
                }
            }
        }
        if (!found) {
            System.out.println("No items found with availability: " + isAvailable);
        }
    }
    
}