public class Customer
{
	//-----INSTANCE VARIABLES----
	private int id;
	private String name;
	private String membership;
	private String password;
	private boolean hasRequestedMembership;
	public final String notMember = "Not a member";
	public final String silver = "Silver";
	public final String gold = "Gold";
	public final String platinum = "Platinum";


	//--------------CONSTRUCTOR---------
	public Customer(int id, String name, String password)
	{
		this.id = id;
		this.name = name;
		this.membership = "Not a member";
		this.hasRequestedMembership = false;
		this.password = password;
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

	public boolean checkPassword(String password)
	{
		return this.password.equals(password);
	}

	public void requestHandled()
	{
		hasRequestedMembership = false;
	}

	public void requestMembershipUpgrade()
	{
		if (!membership.equals(platinum))
			hasRequestedMembership = true;
	}

	public void upgrade()
	{
		if (membership.equals(notMember))
		{
			membership = silver;
		}
		else if (membership.equals(silver))
		{
			membership = gold;
		}
		else
		{
			membership = platinum;
		}
	}

	public String toString()
	{
		return "ID: " + id + " - Name: " + name + " - Membership: " + membership;
	}

}
