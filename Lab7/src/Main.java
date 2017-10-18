import java.util.Scanner;

// Author Lucas Mehmel

public class Main
{
	public static void Main(String[] args)
	{
		String prompt = "Please enter a non-negative, non-zero integer (q to exit)";
		String prompt2 = "Please select an option for computation: ";
		Scanner input = new Scanner (System.in);
		
		while(true)
		{
			System.out.println( prompt );
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
			System.out.println( prompt2 );
			System.out.println("  1. Stand-alone thread");
			System.out.println("  2. Executer service");
			System.out.print( "> ");
			String computation = input.nextLine();
			
			if (computation.equals( "1" ))
			{
				System.out.println("The factors of " + integer + " are:");
				//run()
			}
			
			else if (computation.equals("2"))
			{
				System.out.println("The factors of " + integer + " are:");
				//
			}
			
			else 
			{
				System.out.println("ERROR - invalid selection: " + computation);
				continue;
			}
			
		}
	}
}