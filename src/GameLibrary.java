import java.util.ArrayList;
import java.util.List;

public class GameLibrary
{
	private List<Game> gameList;   //Instance variable


	//--------------CONSTRUCTOR---------
	public GameLibrary()
	{
		gameList = new ArrayList<>();
	}


	//--------------METHODS------------
	public void addGame(int id, String title, String genre, double dailyRent)
	{
		Game g = new Game(id, title, genre, dailyRent);
		gameList.add(g);
	}

	public void removeGame(int idToRemove)
	{
		boolean foundGame = false;

		for (Game g : gameList)
		{
			if (idToRemove == g.getId())
			{
				gameList.remove(g);
				foundGame = true;
				break;
			}
		}

		if (!foundGame)
		{
			System.out.println("Game with ID: " + idToRemove + " was not found.");
		}
	}

	public void gameStatus(int idToCheck)
	{
		boolean foundGame = false;

		for (Game g : gameList)
		{
			if (idToCheck == g.getId())
			{
				System.out.println(g.toString());
				foundGame = true;
				break;
			}
		}

		if (!foundGame)
		{
			System.out.println("Game with ID: " + idToCheck + " was not found.");
		}
	}

	public void rentGame(int id)
	{
		for(Game g : gameList)
		{
			if(id == g.getId())
			{
				g.rentOut();
				break;
			}
		}
	}

	public void returnGame(int id)
	{
		for(Game g : gameList)
		{
			if(id == g.getId())
			{
				g.returnGame();
				break;
			}
		}
	}

	public boolean contains(int id)
	{
		for(Game g : gameList)
		{
			if(id == g.getId())
			{
				return true;
			}
		}

		return false;
	}

	public boolean checkAvailability(int id)
	{
		for(Game g : gameList)
		{
			if(id == g.getId())
			{
				return g.getIsAvailable();
			}
		}

		return false;
	}

	public double getDailyRent(int id)
	{
		for(Game g : gameList)
		{
			if(id == g.getId())
			{
				return g.getDailyRent();
			}
		}

		return 0;
	}

	//prints all games in list to console
	public void printConsole()
	{
		for (Game g : gameList)
		{
			System.out.println(g.toString());
		}
	}
}

