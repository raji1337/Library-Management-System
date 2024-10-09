public abstract class User {
    protected String name;
    protected String userID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public User(String name, String userID) {
        this.name = name;
        this.userID = userID;
    }

    public abstract void accessLibrary();
}