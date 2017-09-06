import java.util.Scanner;

public class Main 
{
	public static void main(String[] args )
	{
		String prompt = "Please enter a mathematical expression ( addition or substraction only, q to quit): ";
		Scanner input = new Scanner(System.in );
		
		while(true)
		{
			System.out.print( prompt );
			String in = input.nextLine();
			
			// removing whitespace
			in = in.trim();
			
			// comparing entire string
			if( in.equals( "q" ) ) // or .equalsIgnoreCase()
			{
				System.out.println( "Goodbye!!! ");
				System.exit(0); // terminates program
			}
			
			// get index of character
			if ( in.contains( "+" ))
			{
				
			}
			
			
			int index = in.indexOf( "+" );
			System.out.println( "Index of plus sign: " + index );
			
			String firstStr = in.substring(0 ,  index );
			String secondStr = in.substring( index + 1 );
			
			// Chop up a sting
			if (index != -1 )
			{
				
				System.out.println( firstStr );
				System.out.println( secondStr );
			}
			
			try
			{
				int first = Integer.parseInt( firstStr );
				int second = Integer.parseInt( secondStr );
				
				System.out.println( "First int: " + first );
				System.out.println( "Second int: " + second );
				System.out.println( "answer is:  " + (first + second) );
			
			}
			catch( Exception e )
			{
				System.out.println( "Error occured" );
				continue;
			}
			
			System.out.println( in );
			
		}
	}
	
	
	
	
	
}