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
        String itemIDToUpdate = input.nextLine();
        LibraryItem itemToUpdate = null;
        for (LibraryItem libItem : libraryItems) {
            if (libItem.getItemID().equals(itemIDToUpdate)) {
                itemToUpdate = libItem;
                break;
            }
        }
        if (itemToUpdate == null) {
            System.out.println("Item with ID '" + itemIDToUpdate + "' not found.");
            return;
        }
        System.out.println("Updating item: " + itemToUpdate.getTitle());
        System.out.print("Enter new title (or press Enter to keep current) >> ");
        String newTitle = input.nextLine();
        if (!newTitle.isEmpty()) {
            itemToUpdate.setTitle(newTitle);
        }
        System.out.print("Enter new author (or press Enter to keep current) >> ");
        String newAuthor = input.nextLine();
        if (!newAuthor.isEmpty()) {
            ((Book) itemToUpdate).setAuthor(newAuthor);
        System.out.println("Item updated successfully.");
        }
    }

    // DELETE
    @Override
    public void removeItem() {
        System.out.print("Enter the book ID you want to remove: ");
        String itemIDToRemove = input.next();
        LibraryItem itemToRemove = null;
        for (LibraryItem item : libraryItems) {
            if (item.getItemID().equals(itemIDToRemove)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove == null) {
            System.out.println("Book not found with ID '" + itemIDToRemove + "'.");
        } else {
            libraryItems.remove(itemToRemove);
            System.out.println("Book with ID '" + itemToRemove.getItemID() + "' has been removed.");
        }
    }
    

    public void removeItemByID() {
        System.out.print("Enter the book ID you want to remove: ");
        String itemIDToRemove = input.next();
        LibraryItem itemToRemove = null;
        for (LibraryItem item : libraryItems) {
            if (item.getItemID().equals(itemIDToRemove)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            libraryItems.remove(itemToRemove);
            System.out.println("Book with ID '" + itemToRemove.getItemID() + "' has been removed.");
        } else {
            System.out.println("Book not found with ID '" + itemIDToRemove + "'.");
        }
    }
}