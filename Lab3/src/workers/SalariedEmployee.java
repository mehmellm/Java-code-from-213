package workers;


public class SalariedEmployee extends Employee
{
	private double payRate = 15.60;
	
	protected SalariedEmployee(String name) {
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
		return payRate / 26;
	}

	@Override
	public boolean isHourly() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void setPayRate(double d) {
		// TODO Auto-generated method stub
		payRate = d;
	}
	
	

}