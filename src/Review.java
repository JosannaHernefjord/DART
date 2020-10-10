public class Review
{
	private int rating;
	private String review;

	public Review(int rating, String review)
	{
		this.rating = rating;
		this.review = review;
	}

	public int getRating()
	{
		return rating;
	}

	public String toString()
	{
		return "Rating: " + rating + "\n Review: " + review;
	}
}
