public class Book extends LibraryItem {
    protected String category;
    protected String[] categories = {
        "Fiction", // 0
        "Non-Fiction", // 1
        "Poetry", // 2
        "Drama", // 3
        "Humor", // 4
        "Educational", // 5
        "Self-Help", // 6
        "Cookbook", // 7
        "Travelogue", // 8
        "Sport" // 9
    };

    public Book(String title, String itemID, boolean status, String author, String category) {
        super(title, itemID, status, author);
        this.category = category;
    }

    // Category
    public String[] getCategories() {
        return categories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(int index) {
        this.category = categories[index];
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void checkOut() {
        if (isAvailable()) {
            System.out.println("Book '" + title + "' has been checked out.");
            setAvailable(false);
        } else {
            System.out.println("Book '" + title + "' is currently unavailable.");
        }
    }

    @Override
    public void returnItem() {
        if (!isAvailable()) {
            System.out.println("Book '" + title + "' has been returned.");
            setAvailable(true);
        } else {
            System.out.println("Book '" + title + "' was not checked out.");
        }
    }
}