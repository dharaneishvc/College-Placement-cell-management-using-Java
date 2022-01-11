import java.util.Scanner;

public class PersonalDetails {

    private String fatherName;
    private String motherName;
    private String DOB;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pinCode;

    public PersonalDetails(String fatherName, String motherName, String DOB, String address, String city, String state, String country, String pinCode) {
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.DOB = DOB;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    public PersonalDetails() {

    }

    @Override
    public String toString() {
        return "PersonalDetails{" +
                "fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", DOB='" + DOB + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

    public void editPersonalDetails(int choice){

        Scanner sc = new Scanner(System.in);

        switch (choice){
            case 1:
                System.out.println("Enter new father name");
                this.fatherName = sc.nextLine();
                break;
            case 2:
                System.out.println("Enter new mother name");
                this.motherName = sc.nextLine();
                break;
            case 3:
                System.out.println("Enter new DOB");
                this.DOB = sc.nextLine();
                break;
            case 4:
                System.out.println("Enter new address");
                this.address = sc.nextLine();
                break;
            case 5:
                System.out.println("Enter new city");
                this.city = sc.nextLine();
                break;
            case 6:
                System.out.println("Enter new state");
                this.state = sc.nextLine();
                break;
            case 7:
                System.out.println("Enter new country");
                this.country = sc.nextLine();
                break;
            case 8:
                System.out.println("Enter new pin code");
                this.pinCode = sc.nextLine();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        sc.close();

    }
}


