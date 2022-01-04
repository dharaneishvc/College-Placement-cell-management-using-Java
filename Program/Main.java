public class Main {
	public static void main(String[] args)
    {
		int ch = Intropage();
    }
	public static int Intropage()
	{
	System.out.print("\n\t********************************College-Placement-Cell***********************************\n");
	System.out.println("\n1.Admin");
	System.out.println("\n2.Faculty");
	System.out.println("\n3.Student");
	System.out.println("\n4.Exit");
    System.out.print("\t*******************************************************************************************\n");
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your choice(1-4):");
    int choice = input.nextInt();

    while(choice<1||choice>4)
    {
    	 System.out.println("Wrong Input!!! Enter correct choice(1-4):");
    	 choice = input.nextInt();

    }
    return choice;
	}
}
