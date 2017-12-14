import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;

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
		FileInputStream fis = new FileInputStream(fileIn);
		BufferedInputStream bis = new BufferedInputStream(fis);
		long fsize = fileIn.length();
		
		String ln = null;
		word = word.toLowerCase();
		
		try
		{
			
			while ((ln = bis.readLine()) != null)
			{
				if (ln.contains(word))
				{
					return "Term " + word + " FOUND";
				}

			}
		}
		finally
		{
			if ( bis != null)
			{
				bis.close();
			}
			if ( fis != null)
			{
				fis.close();
			}
		}
		return "Term " + word + " NOT FOUND";
	}

	}


