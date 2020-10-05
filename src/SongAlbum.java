public class SongAlbum
{
	//-----Song album attributes----
	private int id;
	private String title;
	private String artist;
	private int releaseYear;
	private double userRate;
	private double rentPerDay;
	private boolean isAvailable;

	public SongAlbum(int id, String title, String artist, int releaseYear, double rentPerDay)
	{
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.releaseYear = releaseYear;
		this.userRate = userRate;
		this.rentPerDay = rentPerDay;
		this.isAvailable = true;
	}

	public int getId() // to be able to remove album
	{
		return id;
	}

	public void rentOutSongAlbum() // needs to be in another name than game?
	{
		this.isAvailable = false;
	}

	public void returnSongAlbum()
	{
		this.isAvailable = true;
	}

	public boolean getIsAvailable()
	{
		return isAvailable;
	}

	public String toString()
	{
		// if the album is available or not
		String status = "unavailable";
		if (isAvailable)
			status = "available";
		return "ID:" + id + title + " - " + artist + ". Released in " + releaseYear + ". Price: " + rentPerDay + "SEK. Status: " + status;
	}

	public double getDailyRent()
	{
		return rentPerDay;
	}
}


