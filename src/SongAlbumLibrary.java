import java.util.ArrayList;
import java.util.List;

public class SongAlbumLibrary
{
	private List<SongAlbum> songAlbumList;
	public SongAlbumLibrary()
	{
		songAlbumList = new ArrayList<>();
	}

	public void addSongAlbum(int id, String title, String artist, int releaseYear, double rentPerDay)
	{
		SongAlbum songAlbum = new SongAlbum(id, title, artist, releaseYear, rentPerDay);
		songAlbumList.add(songAlbum);
	}

	public void removeSongAlbum(int idToRemove)
	{
		boolean foundSongAlbum = false;

		for (SongAlbum songAlbum : songAlbumList)
		{
			if (idToRemove == songAlbum.getId()) 		// for every song album in the library/list
			{
				songAlbumList.remove(songAlbum);
				foundSongAlbum = true;
				break;
			}
		}

		if (!foundSongAlbum)
		{
			System.out.println("Song album with ID: " + idToRemove + " was not found.");
		}
	}

	public void rentSongAlbum(int id)
	{
		for (SongAlbum songAlbum : songAlbumList)
		{
			if (id == songAlbum.getId())
			{
				songAlbum.rentOutSongAlbum();
				break;
			}
		}
	}

	public void printAllSongAlbums() 	// view all albums
	{
		for (SongAlbum songAlbum : songAlbumList)
		{
			System.out.println(songAlbum.toString());
		}
	}

	public boolean checkAvailability(int id) 	// see the availability
	{
		for (SongAlbum songAlbum : songAlbumList)
		{
			if (id == songAlbum.getId())
			{
				return songAlbum.getIsAvailable();
			}
		}

		return false;
	}

	public boolean contains(int id)
	{
		for (SongAlbum songAlbum : songAlbumList)
		{
			if (id == songAlbum.getId())
			{
				return true;
			}
		}
		return false;

	}

	public void returnSongAlbum(int id)
	{
		for (SongAlbum songAlbum : songAlbumList)
		{
			if (id == songAlbum.getId())
			{
				songAlbum.returnSongAlbum();
				break;
			}
		}
	}

	public double getDailyRent(int id)
	{
		for (SongAlbum songAlbum : songAlbumList)
		{
			if (id == songAlbum.getId())
			{
				return songAlbum.getDailyRent();
			}
		}
		return 0;
	}

}
