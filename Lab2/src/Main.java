import java.util.Scanner;

public class Main 
{
	public static void main(String[] args )
	{
		String prompt = "Please enter some text: ";
		Scanner input = new Scanner(System.in );
		
		while(true)
		{
			System.out.print( prompt );;
			String in = input.nextLine();
			
			// removing whitespace
			in = in.trim();
			
			// comparing entire string
			if( in.equals( "q" ) ) // or .equalsIgnoreCase()
			{
				System.out.println( "You found the q ");
				System.exit(0); // terminates program
			}
			
			System.out.println( in );
			
			// get index of character
			int index = in.indexOf( "+" );
			System.out.println( "Index of plus sign: " + index );
			
			// Chop up a sting
			if (index != -1 )
			{
				String first = in.substring(0 ,  index );
				String second = in.substring( index + 1 );
				
				System.out.println( first );
				System.out.println( second );
			}
			
			
			
		}
	}
	
	
	
	
	
}