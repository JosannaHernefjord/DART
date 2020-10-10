import java.util.ArrayList;

public class Album implements Comparable<Album>
{
	//-----Song album attributes----
	private ArrayList<Review> reviews;
	private int id;
	private String title;
	private String artist;
	private int releaseYear;
	private double rentPerDay;
	private boolean isAvailable;

	public Album(int id, String title, String artist, int releaseYear, double rentPerDay)
	{
		this.reviews = new ArrayList<>();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.releaseYear = releaseYear;
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

	public void addReview(Review review)
	{
		reviews.add(review);
	}

	public double getAverageRating()
	{
		if(reviews.isEmpty())
		{
			return 0;
		}
		else
		{
			int accumulatedRatings = 0;

			for(Review review : reviews)
			{
				accumulatedRatings += review.getRating();
			}
			return (double) accumulatedRatings / (double) reviews.size();
		}
	}

	public int compareTo(Album albumToCompare)
	{
		if(albumToCompare.getAverageRating() > albumToCompare.getAverageRating())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}


	public String toString()
	{
		// if the album is available or not
		String status = "unavailable";
		if (isAvailable)
			status = "available";
		return "ID:" + id + title + " - " + artist + ". Released in " + releaseYear + ". Price: " + rentPerDay + "SEK. Average rating: " + getAverageRating() + "Status: " + status;
	}

	public double getDailyRent()
	{
		return rentPerDay;
	}
}


