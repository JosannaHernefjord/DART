import java.util.ArrayList;
import java.util.List;

public class CustomerLibrary
{
	//-----INSTANCE VARIABLES----
	private List<Customer> customerList;


	//--------------CONSTRUCTOR---------
	public CustomerLibrary()
	{
		customerList = new ArrayList<>();    //Make a new empty list and assign to customerList
	}


	//--------------METHODS------------
	public void addCustomer(int id, String name, String password)
	{
		Customer c = new Customer(id, name, password);
		customerList.add(c);
	}

	public void removeCustomer(int idToRemove)
	{
		boolean foundCustomer = false;        //False until proven true

		for (Customer customer : customerList)        //For each Customer "c" in customerList
		{
			if (customer.getId() == idToRemove)        //If c's ID == idToRemove
			{
				customerList.remove(customer);        // Remove c from customerList
				foundCustomer = true;        //Customer found!
				break;                        //No use in looking any more
			}
		}

		if (!foundCustomer)    //If ID was not found in the list
		{
			System.out.println("Customer with ID: " + idToRemove + " was not found.");
		}
	}

	public Customer getCustomer(int id)
	{
		for (Customer customer : customerList)
		{
			if (customer.getId() == id)
				return customer;
		}

		return null;
	}

	public ArrayList<Customer> getPendingMembershipRequests()
	{
		ArrayList<Customer> result = new ArrayList<>();

		for (Customer customer : customerList)
		{
			if (customer.getHasRequestedMembership())
				result.add(customer);
		}

		return result;
	}

	public void printConsole()
	{
		for (Customer customer : customerList)                //For each  "customer" in customerList
		{
			System.out.println(customer.toString());        //Print the customer info
		}
	}
}
