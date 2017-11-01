import java.util.ArrayList;

public class RunnableHelper implements Runnable
{
	private int number;
	
	public RunnableHelper(int number)
	{
		this.number = number;
	}
	
	@Override
	public void run()
	{
		try
		{
			ArrayList<Integer> factors = new ArrayList<Integer>();
			for (int runner = 1; runner <= number; runner++)
			{
				if (number % runner == 0)
				{
					factors.add(runner);
				}
				for (int n = 0; n < factors.size(); n++)
				{
					System.out.print(factors.get(n) + ",");
					Thread.sleep(500);
				}
				System.out.println();
			}
		}
		catch(Exception e)
		{
			
		}
		
	}
}