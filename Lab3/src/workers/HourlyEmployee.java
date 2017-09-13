package workers;


public class HourlyEmployee extends Employee
{
	private double payRate;
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
		return getPayRate() * getHoursWorked();
	}

	@Override
	public boolean isHourly() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public double getHoursWorked()
	{
		if (hoursWorked< 0) // needs work!!!!!!!!!!
		{
			System.out.println("ERROR: the number of hours worked cannot be < 0 ");
		}
		else
		{
			return hoursWorked;
		}
	}
	
	public void setHoursWorked(double hours)
	{
		
		hoursWorked = hours;
	}
	
	public void setPayRate()
	{
		payRate = 15.60;
	}
	
}