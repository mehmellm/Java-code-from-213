import java.util.Scanner;

/* Block comment
 * * 
* 
 * Blocks of Fun!!!!
*/

/**
 * Javadoc
 * @author mehmell
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		// Output to the console
		System.out.println("Hello world!");
		System.out.println("This is CSC213");
		// Getting input from user
		Scanner input = new Scanner( System.in);
		String  s   = input.nextLine();
		
		System.out.println( "You typed: " + s);
		
		// Getting input from user forever
		while(true)
		{
			System.out.print(">");;
			String s1 = input.nextLine();
			System.out.println("You typed: " + s1);
		}
	}
}