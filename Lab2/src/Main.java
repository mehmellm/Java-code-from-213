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
			
			else if ( in.contains( "+" ))
			{
				int index = in.indexOf( "+" );
				//System.out.println( "Index of plus sign: " + index );
				if (index == 0)
				{
					System.out.println( "ERROR: invalid number detected" );
					continue;
				}
				else if (index != -1 )
				{
					String firstStr = in.substring(0 ,  index );
					String secondStr = in.substring( index + 1 );
					
					firstStr = firstStr.trim();
					secondStr = secondStr.trim();
					
					//System.out.println( firstStr );
					//System.out.println( secondStr );
					
					try
					{
						int first = Integer.parseInt( firstStr );
						int second = Integer.parseInt( secondStr );
						
						if (first < 0)
						{
							System.out.println("ERROR: negative numbers are not allowed");
							continue;
						}
						
						//System.out.println( "First int: " + first );
						//System.out.println( "Second int: " + second );
						System.out.println( "The result is:" + (first + second) );
					
					}
					catch( Exception e )
					{
						System.out.println( "ERROR: invalid number detected" );
						continue;
					}
					
				}
				
			}
			
			else if ( in.contains( "/" ))
			{
				int index = in.indexOf( "/" );
				//System.out.println( "Index of division sign: " + index );

				String firstStr = in.substring(0 ,  index );
				String secondStr = in.substring( index + 1 );
					
				firstStr = firstStr.trim();
				secondStr = secondStr.trim();
					
				//System.out.println( firstStr );
				//System.out.println( secondStr );
					
				try
				{
					int first = Integer.parseInt( firstStr );
					int second = Integer.parseInt( secondStr );
						
					if (first < 0)
					{
						System.out.println("ERROR: negative numbers are not allowed");
						continue;
					}
					if (second < 0)
					{
						System.out.println("ERROR: negative numbers are not allowed");
						continue;
					}
					else if (second == 0)
					{
						System.out.println("ERROR: dividing by zero is not allowed");
						continue;
					}
					//System.out.println( "First int: " + first );
					//System.out.println( "Second int: " + second );
					System.out.println( "The result is:" + (first / second) );
					
				}
				catch( Exception e )
				{
					System.out.println( "ERROR: invalid number detected" );
					continue;
				}
					
			}
			
			else if ( in.contains( "*" ))
			{
				int index = in.indexOf( "*" );
				//System.out.println( "Index of multiplication sign: " + index );
				if (index == 0)
				{
					System.out.println( "ERROR: invalid number detected" );
					continue;
				}
				else if (index != -1 )
				{
					String firstStr = in.substring(0 ,  index );
					String secondStr = in.substring( index + 1 );
					
					firstStr = firstStr.trim();
					secondStr = secondStr.trim();
					
					//System.out.println( firstStr );
					//System.out.println( secondStr );
					
					try
					{
						int first = Integer.parseInt( firstStr );
						int second = Integer.parseInt( secondStr );
						
						if (first < 0)
						{
							System.out.println("ERROR: negative numbers are not allowed");
							continue;
						}
						if (second < 0)
						{
							System.out.println("ERROR: negative numbers are not allowed");
							continue;
						}

						//System.out.println( "First int: " + first );
						//System.out.println( "Second int: " + second );
						System.out.println( "The result is:" + (first * second) );
					
					}
					catch( Exception e )
					{
						System.out.println( "ERROR: invalid number detected" );
						continue;
					}
					
				}
				
			}
			
			else if ( in.contains( "-" ))
			{
				int index = in.indexOf( "-" );
				//System.out.println( "Index of plus sign: " + index );
				
				String firstStr = in.substring(0 ,  index );
				String secondStr = in.substring( index + 1 );
					
				firstStr = firstStr.trim();
				secondStr = secondStr.trim();
					
				//System.out.println( firstStr );
				//System.out.println( secondStr );
					
				try
				{
					int first = Integer.parseInt( firstStr );
					int second = Integer.parseInt( secondStr );
						
					if (first < 0)
					{
						System.out.println("ERROR: negative numbers are not allowed");
						continue;
					}
						
						//System.out.println( "First int: " + first );
						//q
					System.out.println( "Second int: " + second );
						System.out.println( "The result is:" + (first - second) );
					
					}
				catch( Exception e )
				{
					System.out.println( "ERROR: invalid number detected" );
					continue;
				}
				
				}
							
			else
			{
				System.out.println( "ERROR: invalid or no operator specified - please try again");
				continue;
			}
			
		}
	}
	
	
	
	
	
}