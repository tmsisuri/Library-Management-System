public class User {
    private final String username;
    private final String password;
    private final String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }

    public static User fromFileString(String line) {
        String[] parts = line.split(",");
        return new User(parts[0], parts[1], parts[2]);
    }
}