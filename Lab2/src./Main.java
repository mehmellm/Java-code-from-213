import java.util.Scanner;

public class Main 
{
	public static void main(String[] args )
	{
		String prompt = "Please enter a mathematical expression (q to exit): ";
		Scanner input = new Scanner(System.in );
		
		while(true)
		{
			System.out.print( prompt );
			String in = input.nextLine();
			
			// removing whitespace
			in = in.trim();
			
			// comparing entire string
			if( in.equalsIgnoreCase( "q" ) ) // or .equalsIgnoreCase()
			{
				System.out.println( "Goodbye!!! ");
				System.exit(0); // terminates program
			}
			
			else if (in.contains("abcdefghijklmnopqrstuvwxyz"))//if any char not an int besides operator
			{
				System.out.println( "ERROR: invalid number detected" );
				break;
			}
			// get index of character
			else if ( in.contains( "+" ))
			{
				int index = in.indexOf( "+" );
				System.out.println( "Index of plus sign: " + index );
				if (index == 0)
				{
					System.out.println( "ERROR: invalid number detected" );
					break;
				}
				else if (index != -1 )
				{
					String firstStr = in.substring(0 ,  index );
					String secondStr = in.substring( index + 1 );
					
					System.out.println( firstStr );
					System.out.println( secondStr );
					
					
				}
				

			}
			
			else if ( in.contains( "-" ))
			{
				int index = in.indexOf( "-" );
				System.out.println( "Index of plus sign: " + index );
				if (index == 0)
				{
					System.out.println("ERROR: negative numbers are not allowed");
					break;
				}
				else if (index != -1 )
				{
					String firstStr = in.substring(0 ,  index );
					String secondStr = in.substring( index + 1 );
					
					System.out.println( firstStr );
					System.out.println( secondStr );
					
				
				}
				
				
			}
			
			else
			{
				System.out.println( "ERROR: invalid or no operator specified - please try again");
				break;
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