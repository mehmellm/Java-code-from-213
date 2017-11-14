/** Author Lucas Mehmel
 * Class CSC 213L
 * Lab7
 * Purpose: helper method that finds all the factors of the integer
 *
 */


import java.util.ArrayList;

public class RunnableHelper implements Runnable
{
	private int integer;
	
	public RunnableHelper(int integer)
	{
		this.integer = integer;
	}
	
	@Override
	public void run()
	{
		try
		{
			ArrayList<Integer> factors = new ArrayList<Integer>();
			for (int runner = 1; runner <= integer; runner++)
			{
				if (integer % runner == 0)
				{
					factors.add(runner);
				}
			}
			for (int n = 0; n < factors.size(); n++)
			{
				System.out.print(factors.get(n) + ",");
				Thread.sleep(500);
			}
			System.out.println();
			
		}
		catch(Exception e)
		{
			
		}
		
	}
}