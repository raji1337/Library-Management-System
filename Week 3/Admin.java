import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Admin extends User implements I_Manageable {
    private List<LibraryItem> libraryItems;

    public List<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    private static Scanner input = new Scanner(System.in);
    public Admin(String name, String userID) {
        super(name, userID);
        libraryItems = new ArrayList<>();
    }

    @Override
    public void accessLibrary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accessLibrary'");
    }

    // CREATE
    @Override
    public void addItem() {
        BookDisplay display = new BookDisplay();
        Book book = new Book(null, null, false, null, null);
        System.out.println("----- BOOK INPUT -----");
        System.out.print("Enter book ID >> "); book.setItemID(input.nextLine()); // Book ID
        System.out.print("Enter book title >> "); book.setTitle(input.nextLine()); // Book Title
        System.out.print("Enter book author >> "); book.setAuthor(input.nextLine()); // Book Author
        display.displayCategory(book);
        System.out.print("Enter book category >> "); book.setCategory(InputValidation.bookCategoryValidation()); // Book Category
        book.setAvailable(InputValidation.bookStatusValidation()); // Book Status
        libraryItems.add(book);
        System.out.println("Book '" + book.getTitle() + "' added successfully.");
    }

    // UPDATE
    @Override
    public void updateItem() {
        System.out.print("Enter the book ID you want to update: ");
        String itemIDToUpdate = input.nextLine(); // Read input for item ID
        LibraryItem itemToUpdate = null;
    
        // Find the item to update
        for (LibraryItem libItem : libraryItems) {
            if (libItem.getItemID().equals(itemIDToUpdate)) {
                itemToUpdate = libItem;
                break;
            }
        }
    
        // If the item is not found, display a message
        if (itemToUpdate == null) {
            System.out.println("Item with ID '" + itemIDToUpdate + "' not found.");
            return;
        }
    
        // Update item details based on user input (using the Book class as an example)
        System.out.println("Updating item: " + itemToUpdate.getTitle());
        
        System.out.print("Enter new title (or press Enter to keep current) >> ");
        String newTitle = input.nextLine();
        if (!newTitle.isEmpty()) {
            itemToUpdate.setTitle(newTitle);
        }
    
        System.out.print("Enter new author (or press Enter to keep current) >> ");
        String newAuthor = input.nextLine();
        if (!newAuthor.isEmpty()) {
            ((Book) itemToUpdate).setAuthor(newAuthor); // Typecast to Book to update author
        }
    
        System.out.println("Item updated successfully.");
    }
    

    // DELETE
    @Override
    public void removeItem() {
        System.out.print("Enter the book ID you want to remove: ");
        String itemIDToRemove = input.next(); // Read input for item ID
        LibraryItem itemToRemove = null;
    
        // Find the item to remove
        for (LibraryItem item : libraryItems) {
            if (item.getItemID().equals(itemIDToRemove)) {
                itemToRemove = item;
                break;
            }
        }
    
        // Attempt to remove the item
        if (itemToRemove == null) {
            System.out.println("Book not found with ID '" + itemIDToRemove + "'.");
        } else {
            libraryItems.remove(itemToRemove);
            System.out.println("Book with ID '" + itemToRemove.getItemID() + "' has been removed.");
        }
    }
    

    public void removeItemByID() {
        System.out.print("Enter the book ID you want to remove: ");
        String itemIDToRemove = input.next(); // Read input for item ID
        LibraryItem itemToRemove = null;
    
        // Find the item to remove
        for (LibraryItem item : libraryItems) {
            if (item.getItemID().equals(itemIDToRemove)) {
                itemToRemove = item;
                break;
            }
        }
    
        // Check if the item was found and remove it
        if (itemToRemove != null) {
            libraryItems.remove(itemToRemove);
            System.out.println("Book with ID '" + itemToRemove.getItemID() + "' has been removed.");
        } else {
            System.out.println("Book not found with ID '" + itemIDToRemove + "'.");
        }
    }

    public void searchItem(){
        Search search = new Search(libraryItems);
        System.out.println("----- TITLE SEARCH -----");
        System.out.print("Enter book title >> "); String title = input.nextLine(); // Book Title
        search.searchItem(title);
    }

    public void searchID(){
        Search search = new Search(libraryItems);
        System.out.println("----- ID SEARCH -----");
        System.out.print("Enter book ID >> "); String id = input.nextLine(); // Book ID
        search.searchID(id);
        
    }

    public void filterAuthor(){
        Filter filter = new Filter(libraryItems);
        System.out.println("----- FILTER AUTHOR -----");
        System.out.print("Enter author >> "); String author = input.nextLine(); // Book ID
        filter.filterAuthor(author);
    }

    public void filterCategory(){
        Filter filter = new Filter(libraryItems);
        System.out.println("----- FILTER CATEGORY -----");
        System.out.print("Enter category >> "); String category = input.nextLine(); 
        filter.filterCategory(category);
    }

    public void filterAvailability(){
        Filter filter = new Filter(libraryItems);
        System.out.println("----- FILTER AVAILABILITY -----");
        System.out.print("Enter availability [A]- Available [B]- Unavailable >> "); String choice = input.nextLine(); 
        boolean availability = true;
        if (choice.equalsIgnoreCase("a")){
            availability = true;
        } else if (choice.equalsIgnoreCase("b")){
            availability = false;
        }
        filter.filterAvailability(availability);
    }
}