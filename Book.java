public class Book {
    private int bookID;
    private String title;
    private String author;
    private String status;
    private String reservedByUserID;
    private String category;
    private String[] categories = {
        "Fiction", // 0
        "Non-Fiction", // 1
        "Poetry", // 2
        "Drama", // 3
        "Humor", // 4
        "Educational", // 5
        "Self-Help", // 6
        "Cookbooks", // 7
        "Travelogues", // 8
        "Sports" // 9
    };

    // Book ID
    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    // Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Author
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
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
    public void displayCategory() {
        System.out.println("---- BOOK CATEGORIES -----");
        for (int i = 0; i < categories.length; i++) {
            System.out.println("[" + (i + 1) + "]: " + categories[i]);
        }
        System.out.println("--------------------");
    }

    // Status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Reserved by User ID
    public String getReservedByUserID() {
        return reservedByUserID;
    }
    public void setReservedByUserID(String reservedByUserID) {
        this.reservedByUserID = reservedByUserID;
    }
}