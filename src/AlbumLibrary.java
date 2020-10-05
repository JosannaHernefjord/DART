import java.util.ArrayList;
import java.util.List;

public class AlbumLibrary
{
	private List<Album> albumList;

	//-----Constructor----
	public AlbumLibrary()
	{
		albumList = new ArrayList<>();
	}

	public void addAlbum(int id, String title, String artist, int releaseYear, double rentPerDay)
	{
		Album album = new Album(id, title, artist, releaseYear, rentPerDay);
		albumList.add(album);
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
				album.rentOutSongAlbum();
				break;
			}
		}
	}

	public void printAllAlbums()    // view all albums
	{
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
				album.returnSongAlbum();
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

}