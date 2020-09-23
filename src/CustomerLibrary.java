import java.util.ArrayList;
import java.util.List;

public class CustomerLibrary
{
	//-----INSTANCE VARIABLES----
	private List<Customer> customerList;


	//--------------CONSTRUCTOR---------
	public CustomerLibrary()
	{
		customerList = new ArrayList<Customer>();	//Make a new empty list and assign to customerList
	}


	//--------------METHODS------------
	public void addCustomer(int id, String name)
	{
		Customer c = new Customer(id, name);
		customerList.add(c);
	}

	public void removeCustomer(int idToRemove)
	{
		boolean foundCustomer = false;		//False until proven true

		for(Customer c : customerList)		//For each Customer "c" in customerList
		{
			if(c.getId() == idToRemove)		//If c's ID == idToRemove
			{
				customerList.remove(c);		// Remove c from customerList
				foundCustomer = true;		//Customer found!
				break;					    //No use in looking any more
			}
		}

		if(!foundCustomer)	//If ID was not found in the list
		{
			System.out.println("Customer with ID: " + idToRemove + " was not found.");
		}
	}

	public void printConsole()
	{
		for(Customer c : customerList)				//For each  "c" in customerList
		{
			System.out.println(c.toString());		//Print the customer info
		}
	}
}
