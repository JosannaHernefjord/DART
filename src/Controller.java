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

		testSetup();

		while (!Input.equals("X"))
		{
			Print.printMainScreen();
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
					Print.printInvalidInput();
					break;
			}
		}

		sc.close();
	}

	private void managerRoutine()
	{
		Print.printPasswordPrompt();
		String input = sc.nextLine();

		if (input.equals("admin1234"))
		{
			while (!input.equals("12"))
			{
				Print.printManagerScreen();
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
						Print.printRemoveEmployee();
						id = sc.nextInt();
						sc.nextLine();
						employeeLibrary.removeEmployee(id);
						break;

					case "4":
						Print.printViewEmployeeNetSalary();
						id = sc.nextInt();
						sc.nextLine();
						employeeLibrary.printSalary(id);
						break;

					case "5":
						Print.printEmployeeBonus();
						id = sc.nextInt();
						sc.nextLine();
						employeeLibrary.printBonus(id);
						break;

					case "6":
						System.out.println("-------------Game rent history------------");
						gameLibrary.printGamesHistory();
						System.out.println("------------------------------------------");
						break;

					case "7":
						System.out.println("-------------Album rent history------------");
						albumLibrary.printAlbumsHistory();
						System.out.println("-------------------------------------------");
						break;

					case "8":
						System.out.println("--------Print most profitable game--------");
						gameLibrary.printMostProfitable();
						System.out.println("------------------------------------------");
						break;

					case "9":
						System.out.println("--------Print most profitable Album--------");
						albumLibrary.printMostProfitable();
						System.out.println("-------------------------------------------");
						break;

					case"10":
						System.out.println("-------Print most profitable Customer------");
						customerLibrary.printMostProfitable();
						System.out.println("-------------------------------------------");
						break;

					case"11":
						System.out.println("-----Print rent frequency of games and album -----");
						gameLibrary.printRentFrequency();
						albumLibrary.printRentFrequency();
						System.out.println("--------------------------------------------------");
						break;

					default:
						if (!input.equals("12"))
						{
							Print.printInvalidInput();
						}
						break;
				}
			}
		}
		else Print.printInvalidPassword();
	}

	private void employeeRoutine()
	{
		Print.printPasswordPrompt();
		String input = sc.nextLine();

		if (input.equals("password123"))
		{
			while (!input.equals("10"))
			{
				Print.printEmployeeScreen();
				input = sc.nextLine();
				int id;

				switch (input)
				{
					case "1":
						addNewGame();
						break;

					case "2":
						Print.printRemoveGame();
						id = sc.nextInt();
						sc.nextLine();
						gameLibrary.removeGame(id);
						break;

					case "3":
						addCustomer();
						break;

					case "4":
						Print.printRemoveCustomer();
						id = sc.nextInt();
						sc.nextLine();
						customerLibrary.removeCustomer(id);
						break;

					case "5":
						System.out.println("Total rent profit is: " + rentProfit + " kr.");
						break;

					case "6":
						System.out.println("-----------------GAMES-----------------");
						gameLibrary.printAllGames();
						System.out.println("---------------------------------------");
						break;

					case "7":
						addNewSongAlbum();
						break;

					case "8":
						Print.printRemoveSongAlbum();
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
							Print.printInvalidInput();
						}
						break;
					}
				}
			}
		}
		else
			Print.printInvalidPassword();
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
			while (!input.equals("11"))
			{
				Print.printCustomerScreen();
				input = sc.nextLine();
				switch (input)
				{
					case "1":     // Rent a game
						rentGame(activeCustomer);
						break;

					case "2":        //Return a game
						returnGame(activeCustomer);
						break;

					case "3":            //rent an album
						rentAlbum(activeCustomer);
						break;

					case "4":            // return an album
						returnAlbum(activeCustomer);
						break;

					case "5":
						activeCustomer.requestMembershipUpgrade();
						System.out.println("Request for upgrade membership done.");
						break;

					case "6":
						activeCustomer.printMessages();
						break;

					case "7":
						sendMessage(activeCustomer.getId());
						break;

					case "8":
						System.out.println("-------All games by rating-------");
						gameLibrary.printAllGames();
						System.out.println("---------------------------------");
						break;

					case "9":
						System.out.println("-------All album by rating-------");
						albumLibrary.printAllAlbums();
						System.out.println("---------------------------------");
						break;

					case"10":
						System.out.println("---------------------------------");
						searchItem();
						System.out.println("---------------------------------");
						break;

					default:
						if (!input.equals("11"))
						{
							Print.printInvalidInput();
						}
						break;
				}
			}
		}
		else
		{
			Print.printInvalidPassword();
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
		Print.printCreateEmployee();

		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();            //Read next line to clear scanner buffer.

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Birth year: ");
		int birthYear = sc.nextInt();
		sc.nextLine();            //Read next line to clear scanner buffer.

		System.out.print("Address: ");
		String address = sc.nextLine();

		System.out.print("Monthly gross salary: ");
		double grossSalary = sc.nextDouble();
		sc.nextLine();            //Read next line to clear scanner buffer.

		employeeLibrary.addEmployee(id, name, birthYear, address, grossSalary);
	}

	public void addCustomer()
	{
		Print.printCreateCustomer();

		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Password: ");
		String password = sc.nextLine();

		customerLibrary.addCustomer(id, name, password);
	}

	public void addNewGame()
	{
		Print.printCreateGame();

		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Genre: ");
		String genre = sc.nextLine();

		System.out.print("Daily rent: ");
		double dailyRent = sc.nextDouble();
		sc.nextLine();

		gameLibrary.addGame(id, name, genre, dailyRent);
	}

	public void addNewSongAlbum()
	{
		Print.printCreateSongAlbum();

		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Title: ");
		String title = sc.nextLine();

		System.out.print("Artist: ");
		String artist = sc.nextLine();

		System.out.print("Released in year: ");
		int releaseYear = sc.nextInt();
		sc.nextLine();

		System.out.print("Daily rent: ");
		double rentPerDay = sc.nextDouble();
		sc.nextLine();

		albumLibrary.addAlbum(id, title, artist, releaseYear, rentPerDay);

	}

	public void rentGame(Customer activeCustomer)
	{
		System.out.println("-----------------GAMES------------------");
		gameLibrary.printAllGames();
		System.out.println("----------------------------------------");
		System.out.println("Write the ID of the game you want to rent: ");
		int id = sc.nextInt();
		sc.nextLine();

		if (gameLibrary.checkAvailability(id))
		{
			if (activeCustomer.getNumberObjectsRented() < activeCustomer.rentLimit())
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

	public void returnGame(Customer activeCustomer)
	{
		System.out.println("-----------------GAMES------------------");
		gameLibrary.printAllGames();
		System.out.println("----------------------------------------");

		System.out.println("Enter the following information: ");

		System.out.print("ID of game to return: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Number of days rented: ");
		int daysRented = sc.nextInt();
		sc.nextLine();

		if (gameLibrary.contains(id) && !gameLibrary.checkAvailability(id) && daysRented > 0)
		{
			gameLibrary.returnGame(id);
			activeCustomer.returnedOneItem();

			if (activeCustomer.getsForFree())
			{
				System.out.println("Game returned for free!");
			}
			else
			{
				activeCustomer.increaseCredits();
				double cost = daysRented * gameLibrary.getDailyRent(id) * activeCustomer.discount();
				rentProfit = rentProfit + cost;
				activeCustomer.addRentProfit(cost);
				System.out.println("Game returned! You paid: " + cost + " kr.");
			}

			Review review = leaveReview(activeCustomer, daysRented);
			albumLibrary.addReview(id,review);
		}
		else if (daysRented <= 0)
		{
			System.out.println("Days invalid");
		}
		else
		{
			if (gameLibrary.contains(id))
				System.out.println("Game with ID: " + id + " is already returned.");
			else
				System.out.println("Game with ID: " + id + " does not exist.");
		}
	}

	public void rentAlbum(Customer activeCustomer)
	{
		System.out.println("-----------------ALBUMS-----------------");
		albumLibrary.printAllAlbums();
		System.out.println("----------------------------------------");

		System.out.println("Which album would you like to rent? ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		if (albumLibrary.checkAvailability(id))
		{
			if (activeCustomer.getNumberObjectsRented() < activeCustomer.rentLimit())
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

	public void returnAlbum(Customer activeCustomer)
	{
		System.out.println("-----------------ALBUM------------------");
		albumLibrary.printAllAlbums();
		System.out.println("----------------------------------------");

		System.out.println("Which album would you like to return? ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Number of days rented: ");
		int daysRented = sc.nextInt();
		sc.nextLine();

		if (albumLibrary.contains(id) && !albumLibrary.checkAvailability(id))
		{
			albumLibrary.returnAlbum(id);
			activeCustomer.returnedOneItem();

			if (activeCustomer.getsForFree())
			{
				System.out.println("Game returned for free!");
			}
			else
			{
				activeCustomer.increaseCredits();
				double cost = daysRented * albumLibrary.getDailyRent(id) * activeCustomer.discount();
				rentProfit = rentProfit + cost;
				activeCustomer.addRentProfit(cost);
				System.out.println("Song album returned! You paid: " + cost + " kr.");
			}

			Review review = leaveReview(activeCustomer, daysRented);
			albumLibrary.addReview(id,review);
		}
		else
		{
			if (albumLibrary.contains(id))
				System.out.println("Album with ID: " + id + " is already returned.");
			else
				System.out.println("Album with ID: " + id + " does not exist.");
		}
	}

	private Review leaveReview(Customer activeCustomer, int daysRented)
	{
		System.out.println("Would you like to leave a rating? (y/n)");
		String input = sc.nextLine();
		int rating = 0;
		String review = "";
		boolean isValidRating = false;

		if (input.equals("y"))
		{
			isValidRating = true;
			System.out.println("Print a review from 0 to 5: ");
			rating = sc.nextInt();
			sc.nextLine();

			while (rating < 0 || rating > 5)
			{
				System.out.println("Invalid input, try again (0-5). ");
				rating = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("Would you like to leave a written review? (y/n)");
			input = sc.nextLine();

			if (input.equals("y"))
			{
				System.out.println("Write your review: ");
				review = sc.nextLine();
			}
		}

		return new Review(activeCustomer.getId(), daysRented, rating, review, isValidRating);
	}

	private void sendMessage(int senderId)
	{
		System.out.println("Write recipient ID: ");
		int recipient = sc.nextInt();
		sc.nextLine();

		if (customerLibrary.contains(recipient))
		{
			System.out.println("Write your message: ");
			String message = sc.nextLine();
			customerLibrary.getCustomer(recipient).addMessage(new Message(senderId, message));
		}
		else
		{
			System.out.println("Customer not found.");
		}
	}

	public void searchItem()
	{
		System.out.println("What item do you wish to search for? Type one of the options below: \n1) Games \n2) Song albums");
		String input = sc.nextLine();

		if (input.equals("1"))
		{
			System.out.println("Enter genre to search for games: ");
			String genre = sc.nextLine();
			gameLibrary.printByGenre(genre);

		}
		else if (input.equals("2"))
		{
			System.out.println("Enter release year to search for song albums: ");
			int year = sc.nextInt();
			albumLibrary.printByYear(year);

		}
		else
		{
			Print.printInvalidInput();
		}

	}

	private void testSetup()
	{
		customerLibrary.addCustomer(1, "Adam", "123");
		customerLibrary.addCustomer(2, "Bob", "123");
		customerLibrary.addCustomer(3, "Linda", "123");
		gameLibrary.addGame(1, "Destiny 2", "FPS", 20);
		gameLibrary.addGame(2, "CS:GO", "FPS", 15);
		gameLibrary.addGame(3, "WOW", "RPG", 10);
		employeeLibrary.addEmployee(1, "Carl", 1992, "Java Street", 250000);
		albumLibrary.addAlbum(1, "Top hits", "Various", 2020, 5);
		albumLibrary.addAlbum(2, "Mozart", "Wolfgang Amadeus Mozart", 1779, 10);
		albumLibrary.addAlbum(3, "Rap God", "Eminem", 2010, 8);
	}
}
