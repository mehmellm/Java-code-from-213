import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** Author Lucas Mehmel
 * Class CSC 213L
 * Lab7
 * Purpose: find all the factors of a inputed integer 
 * using a single thread and an executorService
 *
 */

public class Main
{
	public static void main(String[] args)
	{
		String prompt = "Please enter a non-negative, non-zero integer (q to exit) ";
		String prompt2 = "Please select an option for computation: ";
		Scanner input = new Scanner (System.in);
		ExecutorService execute = Executors.newSingleThreadExecutor();
		while(true)
		{
			System.out.print( prompt );
			String inte = input.nextLine();
			int integer = 0;
			if (inte.equals("q"))
			{
				System.exit(0);
			}
			try
			{
				integer = Integer.parseInt( inte );
			}
			catch(Exception e)
			{
				System.out.println("ERROR - invalid integer: " + inte);
			}
			if (integer < 1)
			{
				System.out.println("ERROR - invalid integer: " + integer);
				continue;
			}
			while(true)
			{
				System.out.println( prompt2 );
				System.out.println("  1. Stand-alone thread");
				System.out.println("  2. Executer service");
				System.out.print( "> ");
				String computation = input.nextLine();
				try
				{
					if (computation.equals( "1" ))
					{
						Thread thred = new Thread(new RunnableHelper(integer));
						thred.setName("Stand-alone thread");
						System.out.println("The factors of " + integer + " are:");
						thred.start();
						thred.join();
						break;
					}
			
					else if (computation.equals("2"))
					{
						Future<?> job = execute.submit(new RunnableHelper(integer));
						System.out.println("The factors of " + integer + " are:");
						try
						{
							job.get();
							break;
						}
						catch(ExecutionException e)
						{
							continue;
						}
						
				
					}
			
					else 
					{
						System.out.println("ERROR - invalid selection: " + computation);
						continue;
					}
				}
				catch(Exception e)
				{
					System.out.println("Error - invalid integer: " + integer);
				}
			}
		}
	}
}