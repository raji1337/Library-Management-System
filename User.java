import java.util.List;
public class User {
    private String name;
    private String username;
    private String password;
    private List<String> borrowed;
    private List<String> reserved;

    // Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // Password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Borrowed
    public List<String> getBorrowed() {
        return borrowed;
    }
    public void setBorrowed(List<String> borrowed) {
        this.borrowed = borrowed;
    }

    // Reserved
    public List<String> getReserved() {
        return reserved;
    }
    public void setReserved(List<String> reserved) {
        this.reserved = reserved;
    }
}