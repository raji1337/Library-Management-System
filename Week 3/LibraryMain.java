public class LibraryMain {
    public static void main(String[] args) {
        Admin admin = new Admin("Raji", "raji123");
        BookDisplay display = new BookDisplay();
        Search search = new Search(admin.getLibraryItems());
        Filter filter = new Filter(admin.getLibraryItems());
        
        /*  
            UNFINISHED MAIN SYSTEM
            To test out other methods, comment out the methods
            Methods being tested:
            Input Validation
            Search
            Filter
        */
        admin.addItem();
        admin.addItem();
        display.displayBooks(admin.getLibraryItems());
        // System.out.println("----- SEARCH -----");
        // System.out.println("TITLE SEARCH");
        // search.searchItem("Book 1");
        // System.out.println();
        // search.searchItem("Book 2");
        // System.out.println();
        // System.out.println("ID SEARCH");
        // search.searchID("123");
        // System.out.println();
        // search.searchID("321");

        System.out.println();
        System.out.println("----- FILTER -----");
        System.out.println("FILTER AUTHOR");
        filter.filterAuthor("Author 1");
        filter.filterAuthor("Author 2");
        System.out.println("FILTER AVAILABILITY");
        filter.filterAvailability(true);
        filter.filterAvailability(false);
        System.out.println("FILTER CATEGORY");
        filter.filterCategory("Fiction");
        filter.filterCategory("Non-Fiction");
    }
}