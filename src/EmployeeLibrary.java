import java.util.ArrayList;
import java.util.List;

public class EmployeeLibrary
{
	//-----INSTANCE VARIABLES----
	private List<Employee> employeeList;

	//--------------CONSTRUCTOR---------
	public EmployeeLibrary()
	{
		employeeList = new ArrayList<>();
	}

	//--------------METHODS------------
	public void addEmployee(int id, String name, int birthYear, String address, double grossSalary)
	{
		Employee e = new Employee(id, name, birthYear, address, grossSalary); //Create the employee
		employeeList.add(e);    //Add the employee to the list
	}

	public void removeEmployee(int idToRemove)
	{
		boolean foundEmployee = false;        //False until proven true

		for (Employee e : employeeList)        //For each Employee "e" in EmployeeList
		{
			if (e.getId() == idToRemove)        //If e's ID == idToRemove
			{
				employeeList.remove(e);        // Remove e from gameList
				foundEmployee = true;        //Employee found!
				break;                        //No use in looking any more
			}
		}

		if (!foundEmployee)    //If ID was not found in the list
		{
			System.out.println("Employee with ID: " + idToRemove + " was not found.");
		}
	}

	public void printConsole()
	{
		for (Employee e : employeeList)                //For each  "e" in employeeList
		{
			System.out.println(e.toString());        //Print the employee info
		}
	}
}

