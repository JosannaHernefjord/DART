public class Game
{
	//---------INSTANCE VARIABLES-----------
	private int id;
	private String title;
	private String genre;
	private double dailyRent;
	private boolean isAvailable;

	//Constructor
	public Game(int id, String title, String genre, double dailyRent)
	{
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.dailyRent = dailyRent;
		this.isAvailable = true;
	}

	//---------METHODS-----------

	public void rentOut()
	{
		this.isAvailable = false;
	}

	public void returnGame()
	{
		this.isAvailable = true;
	}

	public int getId()
	{
		return id;
	}

	public boolean getIsAvailable()
	{
		return isAvailable;
	}

	public String toString()
	{
		String temp = "unavailable";

		if (isAvailable)
			temp = "available";

		return id + ": " + title + " (" + genre + "). " + dailyRent + ". Status: " + temp;
	}

}
