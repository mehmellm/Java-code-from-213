import java.io.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args ) throws Exception
	{
		String prompt = "Please enter command (copy | search | exit)";
		Scanner input = new Scanner (System.in);
		Scanner fileIn = new Scanner (System.in);
		Scanner fileOut = new Scanner (System.in);
		Scanner bufferSize = new Scanner (System.in);
		Scanner term = new Scanner (System.in);
		
		while( true )
		{
			System.out.println( prompt );
			System.out.print( "> ");
			
			String s = input.nextLine();
			s = s.trim();
			
			if ( s.equals( "copy") )
			{
				System.out.println( "Please enter the path to the file to copy" );
				System.out.print( "> ");
				String In = fileIn.nextLine();
				if ( In == null || In.isEmpty())
				{
					System.out.println("ERROR: the file name cannot be null or the empty string");
					continue;
				}
				System.out.println( "Please enter the destination path" );
				System.out.print( "> ");
				String Out = fileOut.nextLine();
				if ( Out == null || Out.isEmpty())
				{
					System.out.println("ERROR: the file name cannot be null or the empty string");
					continue;
				}
				System.out.println( "Please enter the size of the read buffer" );
				System.out.print( "> ");
				String Size = bufferSize.nextLine();
				try 
				{
					File inText = new File(In);
					File outText = new File(Out);
					
					int buffSize = Integer.parseInt(Size);
					if (buffSize <= 0 )
					{
						System.out.println("ERROR: invalid read length: " + buffSize );
						continue;
					}
				
					CopyCommand copy = new CopyCommand( buffSize, inText, outText);
					if (copy.validiateInputFile() && copy.validateOutputFile())
					{
						copy.execute();
					}
				}
				
				catch (Exception e)
				{
					System.out.print(e);
				}

			}
			else if (s.equals( "search"))
			{
				System.out.println( "Please enter the path to the file to search" );
				System.out.print( "> ");
				String In = fileIn.nextLine();
				if ( In == null || In.isEmpty())
				{
					System.out.println("ERROR: the file name cannot be null or the empty string");
					continue;
				}
				System.out.println( "Please enter the term to search for" );
				System.out.print( "> ");
				String word = term.nextLine();
				word.equalsIgnoreCase(word);
				
				try
				{
					File inText = new File(In);
					SearchCommand search = new SearchCommand(inText, word);
					if (search.validateInputFile())
					{
						if (search.execute())
						{
							System.out.println("Term found!");
						}
						else
						{
							System.out.println("Term not found!");
						}
					}
					
					else
					{
						System.out.println("ERROR: input file does not exist ");
						continue;
					}
				}
				catch(Exception e)
				{
					continue;
				}
			}
			else if (s.equals("exit"))
			{
				System.exit(0);
			}
			else
			{
				System.out.println( "Error: Invalid command!!! please try again" );
			}
		}
	}
}