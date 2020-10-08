import java.util.Scanner;

public class Controller
{
	private Scanner sc;
	private EmployeeLibrary employeeLibrary;
	private GameLibrary gameLibrary;
	private CustomerLibrary customerLibrary;
	private AlbumLibrary albumLibrary;
	private double rentProfit;

	public Controller()
	{
		sc = new Scanner(System.in);
		employeeLibrary = new EmployeeLibrary();
		gameLibrary = new GameLibrary();
		customerLibrary = new CustomerLibrary();
		albumLibrary = new AlbumLibrary();
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
						addNewEmployee();
						break;
					case "2":
						System.out.println("---------------EMPLOYEES---------------");
						employeeLibrary.printConsole();
						System.out.println("---------------------------------------");
						break;
					case "3":
						Message.printRemoveEmployee();
						id = sc.nextInt();
						sc.nextLine();
						employeeLibrary.removeEmployee(id);
						break;
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
						if (!input.equals("6"))
						{
							Message.printInvalidInput();
						}
						break;
				}
			}
		}
		else Message.printInvalidPassword();
	}

	private void employeeRoutine()
	{
		Message.printPasswordPrompt();
		String input = sc.nextLine();

		if (input.equals("password123"))
		{
			while (!input.equals("10"))
			{
				Message.printEmployeeScreen();
				input = sc.nextLine();
				int id;

				switch (input)
				{
					case "1":
						addNewGame();
						break;
					case "2":
						Message.printRemoveGame();
						id = sc.nextInt();
						sc.nextLine();
						gameLibrary.removeGame(id);
						break;
					case "3":
						addCustomer();
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
					case "7":
						addNewSongAlbum();
						break;
					case "8":
						Message.printRemoveSongAlbum();
						id = sc.nextInt();
						sc.nextLine();
						albumLibrary.removeAlbum(id);
						break;
					case "9":
						System.out.println("------MEMBERSHIP REQUESTS------");
						printRequestList();
						System.out.println("-------------------------------");
						break;
					default:
					{
						if (!input.equals("10"))
						{
							Message.printInvalidInput();
						}
						break;
					}
				}
			}
		}
		else
			Message.printInvalidPassword();
	}

	private void customerRoutine()
	{
		String input = "";
		Customer activeCustomer;

		System.out.print("Enter ID: ");
		int loginId = sc.nextInt();
		sc.nextLine();
		activeCustomer = customerLibrary.getCustomer(loginId);
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		if (activeCustomer.checkPassword(password))
		{
			while (!input.equals("6"))
			{
				Message.printCustomerScreen();
				input = sc.nextLine();
				int id;
				int daysRented;
				switch (input)
				{
					case "1":     // Rent a game

						System.out.println("Write the ID of the game you want to rent: ");
						id = sc.nextInt();
						sc.nextLine();

						rentGame(id,activeCustomer);
						break;

					case "2":        //Return a game

						System.out.println("Enter the following information: ");

						System.out.print("ID of game to return: ");
						id = sc.nextInt();
						sc.nextLine();

						System.out.print("Number of days rented: ");
						daysRented = sc.nextInt();
						sc.nextLine();

						returnGame(id,daysRented,activeCustomer);
						break;

					case "3":			//rent an album
						System.out.println("-----------------ALBUMS-----------------");
						albumLibrary.printAllAlbums();
						System.out.println("---------------------------------------------");

						System.out.println("Which album would you like to rent? ID: ");
						id = sc.nextInt();
						sc.nextLine();

						rentAlbum(id,activeCustomer);
						break;
					case "4":			// return an album
						System.out.println("Which album would you like to return? ID: ");
						id = sc.nextInt();
						sc.nextLine();

						System.out.println("Number of days rented: ");
						daysRented = sc.nextInt();
						sc.nextLine();

						returnAlbum(id,daysRented,activeCustomer);
						break;
					case "5":
						activeCustomer.requestMembershipUpgrade();
						System.out.println("Request for upgrade membership done.");
						break;
					default:
						if (!input.equals("6"))
						{
							Message.printInvalidInput();
						}
						break;
				}
			}
		}
		else
		{
			Message.printInvalidPassword();
		}
	}

	public void printRequestList()
	{
		for (Customer customer : customerLibrary.getPendingMembershipRequests())
		{
			System.out.println(customer.toString());
			System.out.print("Accept (y/n): ");
			String answer = sc.nextLine();
			if (answer.equals("y"))
				customer.upgrade();

			customer.requestHandled();
		}
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
		String password;

		Message.printCreateCustomer();

		System.out.print("ID: ");
		id = sc.nextInt();
		sc.nextLine();

		System.out.print("Name: ");
		name = sc.nextLine();

		System.out.print("Password: ");
		password = sc.nextLine();

		customerLibrary.addCustomer(id, name, password);
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

	public void addNewSongAlbum()
	{
		int id;
		String title;
		String artist;
		int releaseYear;
		double rentPerDay;

		Message.printCreateSongAlbum();

		System.out.print("ID: ");
		id = sc.nextInt();
		sc.nextLine();

		System.out.print("Title: ");
		title = sc.nextLine();

		System.out.print("Artist: ");
		artist = sc.nextLine();

		System.out.print("Released in year: ");
		releaseYear = sc.nextInt();
		sc.nextLine();

		System.out.print("Daily rent: ");
		rentPerDay = sc.nextDouble();
		sc.nextLine();

		albumLibrary.addAlbum(id, title, artist, releaseYear, rentPerDay);

	}

	public void rentGame(int id, Customer activeCustomer)
	{

		if (gameLibrary.checkAvailability(id))
		{
			if(activeCustomer.getNumberObjectsRented() < activeCustomer.rentLimit())
			{
				gameLibrary.rentGame(id);
				activeCustomer.rentedOneItem();
				System.out.println("Game rented!");
			}
			else
			{
				System.out.println("You've reached your rent limit.");
			}
		}
		else
		{
			if (gameLibrary.contains(id))
				System.out.println("Game with ID: " + id + " is not available.");
			else
				System.out.println("Game with ID: " + id + " does not exist.");
		}
	}

	public void returnGame(int id, int daysRented, Customer activeCustomer)
	{

		if (gameLibrary.contains(id) && !gameLibrary.checkAvailability(id))
		{
			gameLibrary.returnGame(id);
			activeCustomer.returnedOneItem();

			if(activeCustomer.getsForFree())
			{
				System.out.println("Game returned for free!");
			}
			else
			{
				activeCustomer.increaseCredits();
				double cost = daysRented * gameLibrary.getDailyRent(id) * activeCustomer.discount();
				rentProfit = rentProfit + cost;
				System.out.println("Game returned! You paid: " + cost + " kr.");
			}
		}
		else
		{
			if (gameLibrary.contains(id))
				System.out.println("Game with ID: " + id + " is already returned.");
			else
				System.out.println("Game with ID: " + id + " does not exist.");
		}
	}
	public void rentAlbum(int id, Customer activeCustomer)
	{
		if (albumLibrary.checkAvailability(id))
		{
			if(activeCustomer.getNumberObjectsRented() < activeCustomer.rentLimit())
			{
				albumLibrary.rentAlbum(id);
				activeCustomer.rentedOneItem();
				System.out.println("Album rented!");
			}
			else
			{
				System.out.println("You've reached your rent limit.");
			}
		}
		else
		{
			if (albumLibrary.contains(id))
				System.out.println("Album with ID: " + id + " is already rented.");
			else
				System.out.println("Album with ID: " + id + " not found.");
		}
	}

	public void returnAlbum(int id, int daysRented, Customer activeCustomer)
	{

		if (albumLibrary.contains(id) && !albumLibrary.checkAvailability(id))
		{
			albumLibrary.returnAlbum(id);
			activeCustomer.returnedOneItem();

			if(activeCustomer.getsForFree())
			{
				System.out.println("Game returned for free!");
			}
			else
			{
				activeCustomer.increaseCredits();
				double cost = daysRented * albumLibrary.getDailyRent(id) * activeCustomer.discount();
				rentProfit = rentProfit + cost;
				System.out.println("Song album returned! You paid: " + cost + " kr.");
			}
		}
		else
		{
			if (albumLibrary.contains(id))
				System.out.println("Album with ID: " + id + " is already returned.");
			else
				System.out.println("Album with ID: " + id + " does not exist.");
		}
	}

}
