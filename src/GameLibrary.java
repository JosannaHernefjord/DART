import java.util.HashMap;

public class GameLibrary
{
	private HashMap<Integer,Game> gameMap; //Trying out hashmap here


	//--------------CONSTRUCTOR---------
	public GameLibrary()
	{
		gameMap = new HashMap<>();
	}


	//--------------METHODS------------
	public void addGame(int id, String title, String genre, double dailyRent)
	{
		Game g = new Game(id, title, genre, dailyRent);
		gameMap.put(g.getId(), g);
	}

	public void removeGame(int idToRemove)
	{
		if(gameMap.containsKey(idToRemove))
		{
			gameMap.remove(idToRemove);
		}
		else
		{
			System.out.println("Game with ID: " + idToRemove + " was not found.");
		}
	}

	public void gameStatus(int idToCheck)
	{
		if(gameMap.containsKey(idToCheck))
			gameMap.get(idToCheck).toString();
	}

	//prints all games in list to console
	public void printConsole()
	{
		for(int i : gameMap.keySet())
		{
			System.out.println(gameMap.get(i).toString());		//Print the game info
		}
	}
}

