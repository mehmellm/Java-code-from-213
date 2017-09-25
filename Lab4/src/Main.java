import java.io.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args )
	{
		String prompt = "Please enter command (copy | search | exit)";
		Scanner input = new Scanner (System.in);
		
		while( true )
		{
			System.out.println( prompt );
			System.out.print( "> ");
			
			String s = input.nextLine();
			
			if ( s.equals( "copy") )
			{
				System.out.println( "Please enter the path to the file to copy" );
				System.out.print( "> ");
				String fileIn = input.nextLine();
				System.out.println( "Please enter the destination path" );
				System.out.print( "> ");
				String fileOut = input.nextLine();
				System.out.println( "Please enter the size of the read buffer" );
				System.out.print( "> ");
				String bufferSize = input.nextLine();
				CopyCommand( bufferSize, fileIn, fileOut);
			}
		}
	}
}