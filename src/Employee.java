public class Employee
{
	//-----INSTANCE VARIABLES----
	private int id;
	private String name;
	private String address;
	private int birthYear;
	private int age;
	private double grossSalary;

	//--------------CONSTRUCTOR---------
	public Employee(int id, String name, int birthYear, String address, double grossSalary)
	{
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.address = address;
		this.age = 2020 - birthYear;

		this.grossSalary = grossSalary;
	}

	//---------METHODS-----------

	public int getId()
	{
		return id;
	}

	public String toString()
	{
		return id + ": " + name + " - " + birthYear + " (" + age + "): " +
				address + " - " + employeeSalary() + " (" + this.grossSalary + ")" + " SEK/month, " +
				employeeBonus() + " SEK bonus.";
	}

	public double employeeSalary()
	{
		if (grossSalary * 12 < 100000)
		{
			return grossSalary;
		} else
		{
			return (grossSalary * 0.7);
		}
	}

	public double employeeBonus()
	{
		if (age < 22)
		{
			return 4000;
		} else if (22 < age && age < 30)
		{
			return 6000;
		} else
		{
			return 7500;
		}
	}
}
