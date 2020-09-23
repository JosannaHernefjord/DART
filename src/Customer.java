public class Customer
{
	//-----INSTANCE VARIABLES----
	private int id;
	private String name;

	//--------------CONSTRUCTOR---------
	public Customer(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	//--------------METHODS------------
	public int getId()
	{
		return id;
	}

	public String toString()
	{
		return "ID: " + id + " Name: " + name;
	}
}
