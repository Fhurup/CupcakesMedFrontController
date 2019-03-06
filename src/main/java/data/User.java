
package data;


public class User {
    private String username;
    private String password;
    private int balance;
    private String email;
    private Role role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public User(String username, String password, int balance, String email, Role role) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.email = email;
        this.role = role;
    }



 
}
