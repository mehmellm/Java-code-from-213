package workers;


public class HourlyEmployee extends Employee
{
	private double payRate = 15.60;
	private double hoursWorked;
	
	protected HourlyEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPayRate() {
		// TODO Auto-generated method stub
		return payRate;
	}

	@Override
	public double getPaycheckAmount() {
		// TODO Auto-generated method stub
		return payRate * hoursWorked;
	}

	@Override
	public boolean isHourly() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public double getHoursWorked()
	{
			return hoursWorked;
	}
	
	public void setHoursWorked(double hours)
	{
		if (hours < 0) 
		{
			System.out.println("ERROR: the number of hours worked cannot be < 0 ");
		}
		else
		{
		hoursWorked = hours;
		}
	}
	
	public void setPayRate(double d)
	{
		payRate = d;
	}
	
}