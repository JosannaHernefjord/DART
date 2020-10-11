import java.util.ArrayList;
import java.util.Collections;
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
		Game game = new Game(id, title, genre, dailyRent);
		gameList.add(game);
	}

	public void addReview(int id, Review review)
	{
		for (Game game : gameList)
		{
			if(game.getId() == id)
				game.addReview(review);
		}
	}

	public void removeGame(int idToRemove)
	{
		boolean foundGame = false;

		for (Game game : gameList)
		{
			if (idToRemove == game.getId())
			{
				gameList.remove(game);
				foundGame = true;
				break;
			}
		}

		if (!foundGame)
		{
			System.out.println("Game with ID: " + idToRemove + " was not found.");
		}
	}

	public void rentGame(int id)
	{
		for (Game game : gameList)
		{
			if (id == game.getId())
			{
				game.rentOut();
				break;
			}
		}
	}

	public void returnGame(int id)
	{
		for (Game game : gameList)
		{
			if (id == game.getId())
			{
				game.returnGame();
				break;
			}
		}
	}

	public boolean contains(int id)
	{
		for (Game game : gameList)
		{
			if (id == game.getId())
			{
				return true;
			}
		}

		return false;
	}

	public boolean checkAvailability(int id)
	{
		for (Game game : gameList)
		{
			if (id == game.getId())
			{
				return game.getIsAvailable();
			}
		}

		return false;
	}

	public double getDailyRent(int id)
	{
		for (Game game : gameList)
		{
			if (id == game.getId())
			{
				return game.getDailyRent();
			}
		}

		return 0;
	}

	//prints all games in list to console
	public void printAllGames()
	{
		Collections.sort(gameList);
		for (Game game : gameList)
		{
			System.out.println(game.toString());
		}
	}

	public void printGamesHistory()
	{
		for (Game game : gameList)
		{
			for(Review review : game.getReviews())
			{
				System.out.println(review.toString());
			}
		}
	}
}

