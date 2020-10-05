import java.util.Scanner;

public class Controller
{
	private Scanner sc;
	private EmployeeLibrary employeeLibrary;
	private GameLibrary gameLibrary;
	private CustomerLibrary customerLibrary;
	private AlbumLibrary albumLibrary;
	private AddItem addItem;
	private double rentProfit;

	public Controller()
	{
		sc = new Scanner(System.in);
		employeeLibrary = new EmployeeLibrary();
		gameLibrary = new GameLibrary();
		customerLibrary = new CustomerLibrary();
		albumLibrary = new AlbumLibrary();
		addItem = new AddItem();
		rentProfit = 0;
	}

	public void runApplication()
	{
		String Input = "";

		while (!Input.equals("X"))
		{
			Message.printMainScreen();
			Input = sc.nextLine();
			Input = Input.toUpperCase();    //To make small letters to capital letters

			switch (Input)
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
				int id;
				switch (input)
				{
					case "1":
						addItem.addNewEmployee();
						break;
					case "2":
						System.out.println("---------------EMPLOYEES---------------");
						employeeLibrary.printConsole();
						System.out.println("---------------------------------------");
					case "3":
						Message.printRemoveEmployee();
						id = sc.nextInt();
						sc.nextLine();
						employeeLibrary.removeEmployee(id);
					case "4":
						Message.printViewEmployeeNetSalary();
						id = sc.nextInt();
						sc.nextLine();
						employeeLibrary.printSalary(id);
						break;
					case "5":
						Message.printEmployeeBonus();
						id = sc.nextInt();
						sc.nextLine();
						employeeLibrary.printBonus(id);
						break;
					default:
						Message.printInvalidInput();
						break;
				}
			}

		}
		sc.close();
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
				int id;

				switch (input)
				{
					case "1":
						addItem.addNewGame();
						break;
					case "2":
						Message.printRemoveGame();
						id = sc.nextInt();
						sc.nextLine();
						gameLibrary.removeGame(id);
						break;
					case "3":
						addItem.addCustomer();
						break;
					case "4":
						Message.printRemoveCustomer();
						id = sc.nextInt();
						sc.nextLine();
						customerLibrary.removeCustomer(id);
						break;
					case "5":
						System.out.println("Total rent profit is: " + rentProfit + " kr.");
						break;
					case "6":
						System.out.println("-----------------GAMES-----------------");
						gameLibrary.printConsole();
						System.out.println("---------------------------------------");
						break;
					case"7":
						addItem.addNewSongAlbum();
					case"8":
						Message.printRemoveSongAlbum();
						id = sc.nextInt();
						sc.nextLine();
						albumLibrary.removeAlbum(id);
					default:
						Message.printInvalidPassword();
						break;
				}
			}
		}
		sc.close();
	}

	private void customerRoutine()
	{
		String input = "";

		while (!input.equals("3"))
		{
			Message.printCustomerScreen();
			input = sc.nextLine();
			int id;

			switch (input)
			{
				case "1":     // Rent a game

					System.out.println("Write the ID of the game you want to rent: ");
					id = sc.nextInt();
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

				case "2":   //Return a game
				{
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
				case "3":
					System.out.println("-----------------SONG ALBUMS-----------------");
					albumLibrary.printAllAlbums();
					System.out.println("---------------------------------------------");

					System.out.println("Which song album would you like to rent? ID: ");
					id = sc.nextInt();
					sc.nextLine();

					if (albumLibrary.checkAvailability(id))
					{
						albumLibrary.rentAlbum(id);
						System.out.println("Song album rented!");
					} else
					{
						if (albumLibrary.contains(id))
							System.out.println("Album with ID: " + id + " is already rented.");
						else
							System.out.println("Album with ID: " + id + " not found.");
					}
				case "4":
					System.out.println("Which song album would you like to return? ID: ");
					id = sc.nextInt();
					sc.nextLine();

					System.out.println("Number of days rented: ");
					int daysRented = sc.nextInt();
					sc.nextLine();

					if (albumLibrary.contains(id) && !albumLibrary.checkAvailability(id))
					{
						albumLibrary.returnAlbum(id);
						double cost = daysRented * albumLibrary.getDailyRent(id);
						rentProfit = rentProfit + cost;
						System.out.println("Song album returned! You paid: " + cost + " kr.");
					}

				default:
					Message.printInvalidInput();
			}

		}
	}
}
