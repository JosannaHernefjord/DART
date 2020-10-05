import java.util.Scanner;

public class Controller
{
	private Scanner sc;
	private EmployeeLibrary employeeLibrary;
	private GameLibrary gameLibrary;
	private CustomerLibrary customerLibrary;
	private AddItem addItem;
	private double rentProfit;

	public Controller()
	{
		sc = new Scanner(System.in);
		employeeLibrary = new EmployeeLibrary();
		gameLibrary = new GameLibrary();
		customerLibrary = new CustomerLibrary();
		addItem = new AddItem();
		rentProfit = 0;
	}

	public void runApplication()
	{
		String userInput = "";

		while (!userInput.equals("X"))
		{
			Message.printMainScreen();
			userInput = sc.nextLine();
			userInput = userInput.toUpperCase();	//To make small letters to capital letters

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
			while (!input.equals("6"))
			{
				Message.printManagerScreen();
				input = sc.nextLine();
				if (input.equals("1"))
				{
					addItem.addNewEmployee();

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
				} else if (input.equals("4"))
				{
					Message.printViewEmployeeNetSalary();
					int id = sc.nextInt();
					sc.nextLine();
					employeeLibrary.printSalary(id);
				} else if (input.equals("5"))
				{
					Message.printEmployeeBonus();
					int id = sc.nextInt();
					sc.nextLine();
					employeeLibrary.printBonus(id);
				} else if (!input.equals("6"))
				{
					Message.printInvalidInput();
				}
			}
		} else
		{
			Message.printInvalidPassword();
		}
	}

	private void employeeRoutine()
	{
		Message.printPasswordPrompt();
		String input = sc.nextLine();

		if (input.equals("password123"))
		{
			while (!input.equals("7"))
			{
				Message.printEmployeeScreen();
				input = sc.nextLine();

				if (input.equals("1"))
				{
					addItem.addNewGame();
				}
				if (input.equals("2"))
				{
					Message.printRemoveGame();
					int id = sc.nextInt();
					sc.nextLine();
					gameLibrary.removeGame(id);
				}
				if (input.equals("3"))
				{
					addItem.addCustomer();
				}
				if (input.equals("4"))
				{
					Message.printRemoveCustomer();
					int id = sc.nextInt();
					sc.nextLine();
					customerLibrary.removeCustomer(id);
				}
				if (input.equals("5"))
				{
					System.out.println("Total rent profit is: " + rentProfit + " kr.");
				}
				if (input.equals("6"))
				{
					System.out.println("-----------------GAMES-----------------");
					gameLibrary.printConsole();
					System.out.println("---------------------------------------");
				}
			}

		} else
		{
			Message.printInvalidPassword();
		}
	}

	private void customerRoutine()
	{
		String input = "";

		while (!input.equals("3"))
		{
			Message.printCustomerScreen();
			input = sc.nextLine();

			if (input.equals("1"))     // Rent a game
			{
				System.out.println("Write the ID of the game you want to rent: ");
				int id = sc.nextInt();
				sc.nextLine();

				if (gameLibrary.checkAvailability(id))
				{
					gameLibrary.rentGame(id);
					System.out.println("Game rented!");
				} else
				{
					if (gameLibrary.contains(id))
						System.out.println("Game with ID: " + id + " is not available.");
					else
						System.out.println("Game with ID: " + id + " does not exist.");
				}
			} else if (input.equals("2"))    //Return a game
			{
				int id;
				int daysRented;

				System.out.println("Enter the following information: ");

				System.out.print("ID of game to return: ");
				id = sc.nextInt();
				sc.nextLine();

				System.out.print("Number of days rented: ");
				daysRented = sc.nextInt();
				sc.nextLine();

				if (gameLibrary.contains(id) && !gameLibrary.checkAvailability(id))
				{
					gameLibrary.returnGame(id);
					double cost = daysRented * gameLibrary.getDailyRent(id);
					rentProfit = rentProfit + cost;
					System.out.println("Game returned! You paid: " + cost + " kr.");
				} else
				{
					if (gameLibrary.contains(id))
						System.out.println("Game with ID: " + id + " is already returned.");
					else
						System.out.println("Game with ID: " + id + " does not exist.");
				}
			}
			else
			{
				Message.printInvalidInput();
			}
		}

	}
}
