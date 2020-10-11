import java.util.ArrayList;

public class Game implements Comparable<Game>
{
	//---------INSTANCE VARIABLES-----------
	private ArrayList<Review> reviews;
	private int id;
	private String title;
	private String genre;
	private double dailyRent;
	private boolean isAvailable;

	//Constructor
	public Game(int id, String title, String genre, double dailyRent)
	{
		this.reviews = new ArrayList<>();
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

	public ArrayList<Review> getReviews()
	{
		return reviews;
	}

	public double getDailyRent()
	{
		return dailyRent;
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
				if(review.isRatingValid())
					accumulatedRatings += review.getRating();
			}
			return (double) accumulatedRatings / (double) reviews.size();
		}
	}

	public int compareTo(Game gameToCompare)
	{
		if(gameToCompare.getAverageRating() > gameToCompare.getAverageRating())
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
		String temp = "unavailable";

		if (isAvailable)
			temp = "available";

		return id + ": " + title + " (" + genre + "). " + dailyRent + "Average rating: " + getAverageRating() + ". Status: " + temp;
	}

}
