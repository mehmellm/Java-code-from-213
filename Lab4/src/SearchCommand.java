import java.io.*;



public class SearchCommand 
{
	private File fileIn;
	private String word;
	
	
	public SearchCommand(File In, String term)
	{
		fileIn = In;
		word = term;

	}
	
	public boolean validateInputFile()
	{
		if (fileIn.exists())
		{
			if (fileIn.isDirectory())
			{
				return false;
			}
			return true;
		}
		return false;
	}
	public boolean execute() throws IOException
	{

		FileReader reader = new FileReader(fileIn);
		BufferedReader buffReader = new BufferedReader(reader);
		String ln = null;
		word = word.toLowerCase();
		
		try
		{
			
			while ((ln = buffReader.readLine()) != null)
			{
				if (ln.contains(word))
				{
					return true;
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
		return false;
	}
}