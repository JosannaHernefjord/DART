
public class Album extends Item implements Comparable<Album>
{
	//-----Song album attributes----
	private String artist;
	private int releaseYear;

	public Album(int id, String title, String artist, int releaseYear, double rentPerDay)
	{
		super(id, title, rentPerDay);
		this.artist = artist;
		this.releaseYear = releaseYear;
		this.isAvailable = true;
	}

	public int getReleaseYear()
	{
		return releaseYear;
	}

	public int compareTo(Album albumToCompare)
	{
		if(albumToCompare.getAverageRating() < albumToCompare.getAverageRating())
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
		// if the album is available or not
		String status = "Can be returned";
		if (isAvailable)
			status = "Not rented";
		return "ID: " + getId() + "  " + getTitle() + " - " + artist + ". Released in " + releaseYear + ". Price: " + getDailyRent() + "SEK. Average rating: " + getAverageRating() + "Status: " + status;
	}

}


