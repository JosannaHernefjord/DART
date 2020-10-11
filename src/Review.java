public class Review
{
	int customerId;
	int daysRented;
	private int rating;
	private String review;

	public Review(int customerId,int daysRented,int rating, String review)
	{
		this.customerId = customerId;
		this.daysRented = daysRented;
		this.rating = rating;
		this.review = review;
	}

	public int getRating()
	{
		return rating;
	}

	public String toString()
	{
		return "Customer id: " + customerId + "Days rented: " + daysRented + " Rating: " + rating + " Review: " + review;
	}
}
