import java.util.ArrayList;

public class Game extends Item implements Comparable<Game>
{
	//---------INSTANCE VARIABLES-----------
	private String genre;
	private boolean isAvailable;

	//Constructor
	public Game(int id, String title, String genre, double dailyRent)
	{
		super(id, title, dailyRent);
		this.genre = genre;
		this.isAvailable = true;
	}

	//---------METHODS-----------

	public void returnGame()
	{
		this.isAvailable = true;
	}

	public String getGenre()
	{
		return genre;
	}

	public int compareTo(Game gameToCompare)
	{
		if(gameToCompare.getAverageRating() < gameToCompare.getAverageRating())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

	public String toString()
	{
		String temp = "unavailable";

		if (isAvailable)
			temp = "available";

		return getId() + ": " + getTitle() + " (" + genre + "). " + getDailyRent() + "Average rating: " + getAverageRating() + ". Status: " + temp;
	}

}
