public class Customer
{
	//-----INSTANCE VARIABLES----
	private int id;
	private String name;
	private String membership;
	private boolean hasRequestedMembership;

	//--------------CONSTRUCTOR---------
	public Customer(int id, String name)
	{
		this.id = id;
		this.name = name;
		this.membership = "Not a member";
		this.hasRequestedMembership = false;
	}

	//--------------METHODS------------
	public int getId()
	{
		return id;
	}

	public boolean getHasRequestedMembership()
	{
		return hasRequestedMembership;
	}

	public String toString()
	{
		return "ID: " + id + " Name: " + name + "Membership: " + membership;
	}

}
