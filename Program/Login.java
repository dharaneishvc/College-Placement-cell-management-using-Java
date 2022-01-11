import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Login extends User{

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    private String username;
    private String password;

    User loggedInUser = null;
    List<User> listOfUsers = new ArrayList<>();

    {
        listOfUsers.add(new User("user1", "password1"));
        listOfUsers.add(new User("user2", "password2"));
        listOfUsers.add(new User("user3", "password3"));
    }

    public Login()
    {
        this.username = "";
        this.password = "";
    }

    public boolean checkLogin()
    {
        for(User user : listOfUsers)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }
    public  boolean checkusername(String username){
        for(User user : listOfUsers){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void readCredentials() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Username: ");
            username = reader.readLine();
            System.out.print("Password: ");
            password = reader.readLine();
        } catch (Exception e) {
            System.out.println("Error Reading credentials");
        }
    }

    public void addUser(User user) {
        listOfUsers.add(user);
    }

    public User getUser(String username) {
        for (User user : listOfUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkCredentials() {
        if (getUser(username) != null && getUser(username).getPassword().equals(password)) {
            loggedInUser = getUser(username);
            return true;
        }
        return false;
    }

    public void printLoggedInUser() {
        System.out.println("Logged in user: " + loggedInUser.getUsername());
    }

    public boolean admincheck(){
        if(loggedInUser.getUsername().equals("user1") || loggedInUser.getUsername().equals("user2") || loggedInUser.getUsername().equals("user3") || loggedInUser.getUsername().equals("user4")|| loggedInUser.getUsername().equals("user5")|| loggedInUser.getUsername().equals("user6")){
            System.out.println("You are an admin");
            return true;
        }
        else{
            System.out.println("You are not an admin");
            return false;
        }
    }
    public void printListOfUsers() {
        for (User user : listOfUsers) {
            System.out.println(user.getUsername());
        }
    }
}
