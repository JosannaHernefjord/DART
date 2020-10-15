import java.util.ArrayList;
import java.util.Collections;

public class AlbumLibrary
{
	private ArrayList<Album> albumList;

	//-----Constructor----
	public AlbumLibrary()
	{
		albumList = new ArrayList<>();
	}

	public void addAlbum(int id, String title, String artist, int releaseYear, double rentPerDay)
	{
		if(!contains(id))
		{
			Album album = new Album(id, title, artist, releaseYear, rentPerDay);
			albumList.add(album);
		}
		else
			System.out.println("Album with ID: " + id + " already exist.");
	}

	public void removeAlbum(int idToRemove)
	{
		boolean foundAlbum = false;

		for (Album album : albumList)
		{
			if (idToRemove == album.getId())        // for every song album in the library/list
			{
				albumList.remove(album);
				foundAlbum = true;
				break;
			}
		}

		if (!foundAlbum)
		{
			System.out.println("Song album with ID: " + idToRemove + " was not found.");
		}
	}

	public void rentAlbum(int id)
	{
		for (Album album : albumList)
		{
			if (id == album.getId())
			{
				album.rentOut();
				break;
			}
		}
	}

	public void printAllAlbums()    // view all albums
	{
		Collections.sort(albumList);
		for (Album album : albumList)
		{
			System.out.println(album.toString());
		}
	}

	public boolean checkAvailability(int id)    // see the availability
	{
		for (Album album : albumList)
		{
			if (id == album.getId())
			{
				return album.getIsAvailable();
			}
		}

		return false;
	}

	public boolean contains(int id)
	{
		for (Album album : albumList)
		{
			if (id == album.getId())
			{
				return true;
			}
		}
		return false;

	}

	public void returnAlbum(int id)
	{
		for (Album album : albumList)
		{
			if (id == album.getId())
			{
				album.returnItem();
				break;
			}
		}
	}

	public double getDailyRent(int id)
	{
		for (Album album : albumList)
		{
			if (id == album.getId())
			{
				return album.getDailyRent();
			}
		}
		return 0;
	}

	public void addReview(int id, Review review)
	{
		for (Album album : albumList)
		{
			if(album.getId() == id)
				album.addReview(review);
		}
	}

	public void printByYear(int year)
	{
		for (Album album : albumList) {
			if(year == (album.getReleaseYear()))
			{
				System.out.println(album.toString());
			}
		}
	}

	public void printAlbumsHistory()
	{
		for (Album album : albumList)
		{
			for(Review review : album.getReviews())
			{
				System.out.println(review.toString());
			}
		}
	}

	public void printMostProfitable()
	{
		albumList.trimToSize();
		Album mostProfitableAlbum = albumList.get(0);

		for(Album album : albumList)
		{
			if(mostProfitableAlbum.getTotalRentProfit() < album.getTotalRentProfit())
			{
				mostProfitableAlbum = album;
			}
		}
		System.out.println(mostProfitableAlbum.toString());
	}

}
