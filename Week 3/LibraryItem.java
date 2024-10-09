public abstract class LibraryItem {
    protected String title;
    protected String itemID;
    protected String author;
    protected boolean status;

    public LibraryItem(String title, String itemID, boolean status, String author) {
        this.title = title;
        this.itemID = itemID;
        this.status = status;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public boolean isAvailable() {
        return status;
    }

    public void setAvailable(boolean status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public abstract void checkOut();
    public abstract void returnItem();
}