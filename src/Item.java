import java.util.ArrayList;

public abstract class Item
{
	private int id;
	private double totalRentProfit;
	private String title;
	private double dailyRent;
	protected boolean isAvailable;
	private ArrayList<Review> reviews;

	public Item(int id, String title, double dailyRent)
	{
		this.id = id;
		this.title = title;
		this.dailyRent = dailyRent;
		this.isAvailable = true;
		this.reviews = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Review> getReviews()
	{
		return reviews;
	}

	public double getDailyRent() {
		return dailyRent;
	}

	protected boolean getIsAvailable()
	{
		return isAvailable;
	}

	public void rentOut()
	{
		this.isAvailable = false;
	}

	public void returnItem()
	{
		this.isAvailable = true;
	}

	public void addReview(Review review)
	{
		reviews.add(review);
		totalRentProfit = totalRentProfit + review.getDaysRented() * dailyRent;
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
}
