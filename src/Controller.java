import java.util.Scanner;

public class Controller
{
	private Scanner sc;
	private EmployeeLibrary employeeLibrary;
	private GameLibrary gameLibrary;
	private CustomerLibrary customerLibrary;

	public Controller()
	{
		sc = new Scanner(System.in);
		employeeLibrary = new EmployeeLibrary();
		gameLibrary = new GameLibrary();
		customerLibrary = new CustomerLibrary();
	}

	public void runApplication()
	{
		String userInput = "";

		while (!userInput.equals("X"))
		{
			Message.printMainScreen();
			userInput = sc.nextLine();
			userInput = userInput.toUpperCase();

			switch (userInput)
			{
				case "M":
					managerRoutine();
					break;
				case "E":
					employeeRoutine();
					break;
				case "C":
					customerRoutine();
					break;
				case "X":
					break;
				default:
					Message.printInvalidInput();
					break;
			}
		}

		sc.close();
	}

	private void managerRoutine()
	{
		Message.printPasswordPrompt();
		String input = sc.nextLine();

		if (input.equals("admin1234"))
		{
			while (!input.equals("4"))
			{
				Message.printManagerScreen();
				input = sc.nextLine();
				if (input.equals("1"))
				{
					addNewEmployee();
				} else if (input.equals("2"))
				{
					System.out.println("---------------EMPLOYEES---------------");
					employeeLibrary.printConsole();
					System.out.println("---------------------------------------");
				} else if (input.equals("3"))
				{
					Message.printRemoveEmployee();
					int id = sc.nextInt();
					sc.nextLine();
					employeeLibrary.removeEmployee(id);
				} else if (!input.equals("4"))
				{
					Message.printInvalidInput();
				}
			}
		}
	}

	private void employeeRoutine()
	{
		Message.printEmployeeScreen();
		String input = sc.nextLine();

		if(input.equals("password123"))
		{
			while (!input.equals("password"))
			{
				Message.printEmployeeScreen();
				input = sc.nextLine();
				if(input.equals("1"))
				{
					addNewGame();
				}
				if(input.equals("2"))
				{
					Message.printRemoveGame();
					int id = sc.nextInt();
					sc.nextLine();
					gameLibrary.removeGame(id);
				}
				//TODO
			}

		}
	}

	private void customerRoutine()
	{
		Message.printCustomerScreen();
		//TODO
	}

	private void addNewEmployee()
	{
		int id, birthYear;
		double grossSalary;
		String name, address;

		Message.printCreateEmployee();

		System.out.print("ID: ");
		id = sc.nextInt();
		sc.nextLine();			//Read next line to clear scanner buffer.

		System.out.print("Name: ");
		name = sc.nextLine();

		System.out.print("Birth year: ");
		birthYear = sc.nextInt();
		sc.nextLine();			//Read next line to clear scanner buffer.

		System.out.print("Address: ");
		address = sc.nextLine();

		System.out.print("Monthly gross salary: ");
		grossSalary = sc.nextDouble();
		sc.nextLine();			//Read next line to clear scanner buffer.

		employeeLibrary.addEmployee(id, name, birthYear, address, grossSalary);
	}

	private void addNewGame()
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

		gameLibrary.addGame(id,name,genre,dailyRent);
	}
}
