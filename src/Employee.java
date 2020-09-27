public class Employee
{
	//-----INSTANCE VARIABLES----
	private int id;
	private String name;
	private String address;
	private int birthYear;
	private int age;
	private double grossSalary;
	private int bonus;

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
				address + " - " + grossSalary +"SEK";
	}

	public String employeeSalary()
	{
		if (grossSalary * 12 < 100000)
		{
			return "Monthly net salary: " + grossSalary + " - " + "Yearly net salary: " + (grossSalary*12+ bonus);
		} else
		{
			return "Montlhy net salary: " + grossSalary * 0.7 + " - " + "Yearly net salary: " + ((grossSalary * 0.7)*12+ bonus) ;
		}
	}

	public String employeeBonus()
	{
		if (age < 22)
		{
			bonus = 4000;
			return "Employee will receive 4000SEK in bonus";
		} else if (age >= 22 && age <= 30 )
		{
			bonus = 6000;
			return "Employee will receive 6000SEK in bonus";
		} else
		{
			bonus = 7500;
			return "Employee will receive 7500SEK in bonus";
		}
	}
}
