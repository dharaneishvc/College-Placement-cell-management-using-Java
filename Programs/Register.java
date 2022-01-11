import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {

    private String name;
    private String rollNumber;
    private String email;
    private String mobile;
    private String password;
    private String confirmPassword;


    public Register(String rollNumber, String name, String email, String mobile) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.email = email;
        this.mobile = mobile;
    }

    public Register() {

    }

    public static boolean isPhValid(String str) {
        Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(str);
        return (m.find() && m.group().equals(str))? true: false;
    }

    public static boolean isEmValid(String str) {
        Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher m = p.matcher(str);
        return (m.find() && m.group().equals(str))? true:false;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordAgain(String passwordAgain) {
        confirmPassword = passwordAgain;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordAgain() {
        return confirmPassword;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    public void resetPassword(){
        User u = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new password: ");
        String newPassword = sc.nextLine();
        this.password = newPassword;
        u.resetPassword(newPassword);
        sc.close();
    }
}
