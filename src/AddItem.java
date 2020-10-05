import java.util.Scanner;

public class AddItem
{
	private Scanner sc;
	private EmployeeLibrary employeeLibrary;
	private GameLibrary gameLibrary;
	private CustomerLibrary customerLibrary;

	public AddItem()
	{
		sc = new Scanner(System.in);
		employeeLibrary = new EmployeeLibrary();
		gameLibrary = new GameLibrary();
		customerLibrary = new CustomerLibrary();
	}
	public void addNewEmployee()
	{
		int id, birthYear;
		double grossSalary;
		String name, address;

		Message.printCreateEmployee();

		System.out.print("ID: ");
		id = sc.nextInt();
		sc.nextLine();            //Read next line to clear scanner buffer.

		System.out.print("Name: ");
		name = sc.nextLine();

		System.out.print("Birth year: ");
		birthYear = sc.nextInt();
		sc.nextLine();            //Read next line to clear scanner buffer.

		System.out.print("Address: ");
		address = sc.nextLine();

		System.out.print("Monthly gross salary: ");
		grossSalary = sc.nextDouble();
		sc.nextLine();            //Read next line to clear scanner buffer.

		employeeLibrary.addEmployee(id, name, birthYear, address, grossSalary);
	}

	public void addCustomer()
	{
		int id;
		String name;

		Message.printCreateCustomer();

		System.out.print("ID: ");
		id = sc.nextInt();
		sc.nextLine();

		System.out.print("Name: ");
		name = sc.nextLine();

		customerLibrary.addCustomer(id, name);
	}

	public void addNewGame()
	{
		int id;
		String name, genre;
		double dailyRent;

		Message.printCreateGame();

		System.out.print("ID: ");
		id = sc.nextInt();
		sc.nextLine();

		System.out.print("Name: ");
		name = sc.nextLine();

		System.out.print("Genre: ");
		genre = sc.nextLine();

		System.out.print("Daily rent: ");
		dailyRent = sc.nextDouble();
		sc.nextLine();

		gameLibrary.addGame(id, name, genre, dailyRent);
	}
}
