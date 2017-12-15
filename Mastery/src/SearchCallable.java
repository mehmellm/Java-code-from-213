import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.concurrent.Callable;

import javax.swing.SwingUtilities;

public class SearchCallable implements Callable 
{
	private File fileIn;
	private String word;
	
	public SearchCallable(File In, String term)
	{
		fileIn = In;
		word = term;

	}

	/** fixed size for buffer reader */
	int size = 1024; 
	
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		
		
		FileReader reader = new FileReader(fileIn);
		BufferedReader buffReader = new BufferedReader(reader);
		String ln = null;
		boolean found = false;
		word = word.toLowerCase();
		
		try
		{
			
			while ((ln = buffReader.readLine()) != null)
			{
				if (ln.contains(word))
				{
					found = true;
					break;
					
				}

			}

		}
		finally
		{
			if ( buffReader != null)
			{
				buffReader.close();
			}
			if ( reader != null)
			{
				reader.close();
			}
		}
		if (!found)
		{
			
			return " NOT FOUND";
		}
		else
		{
			return "FOUND";
		}
		
	}
}


