public class Message
{
	public static void printManagerScreen()
	{
		System.out.println("Manager Screen - Type one of the options below:");
		System.out.println("1. Add an employee \n2. View all employees \n3. Return to Main Menu");
	}

	public static void printEmployeeScreen()
	{
		System.out.println("Employee Screen - Type one of the options below:");
		System.out.println("1. Register a game \n2. Remove a game \n3. Register a customer \n4. Remove a customer");
		System.out.println("5. Show total rent profit \n6. View all games \n7. Return to Main Menu");
	}

	public static void printCustomerScreen()
	{
		System.out.println("Customer Screen - Type one of the options below:");
		System.out.println("1. Rent a game \n2. Return to a game \n3. Return to Main Menu");
	}

	public static void printMainScreen()
	{
		System.out.println("Main menu");
		System.out.println("Welcome to DART, your good old game rental system. \nThe competition has no steam to keep up!");
		System.out.println("Please specify your role by entering one of the options given");
		System.out.println("1. Enter “M” for Manager \n2. Enter ”E” for Employee \n3. Enter ”C” for Customer \n4. Enter ”X” to exit system");

	}
		public static void printCreateEmployee()
	{
		System.out.println("Creating an Employee. Please type the Employee’s:");
	}

	public static void printRemoveEmployee()
	{
		System.out.print("Which employee should be removed? ID: ");
	}

	public static void printInvalidInput()
	{
		System.out.println("Invalid input.");
	}

	public static void printPasswordPrompt()
	{
		System.out.println("Please enter password:");
	}

	public static void printCreateGame()
	{
		System.out.println("Add a game. Please type the game's:");
	}
	public static void printRemoveGame()
	{
		System.out.println("Which game should be removed? ID: ");
	}
	public static void printCreateCustomer()
	{
		System.out.println("Creating an Customer. Please type the Customer’s:");
	}
	public static void printRemoveCustomer()
	{
		System.out.print("Which customer should be removed? ID: ");
	}

	public static void printInvalidPassword()
	{
		System.out.println("Invalid password.");
		System.out.println();
	}
}
