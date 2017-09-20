import java.io.*;



public class CopyCommand {
	private int bufferSize;
	private File fileIn;
	private File fileOut;
	
	public CopyCommand(int size, File in, File out)
	{
		bufferSize = size;
		fileIn = in;
		fileOut = out;
		
	}
	public boolean validiateInputFile()
	{
		if (fileIn.exists())
		{
			if (fileIn.isDirectory())
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else 
		{
			return false;
		}
	}
	public boolean validateOutputFile()
	{
		if (fileOut.isDirectory())
		{
			return false;
		}
		else
		{
			return true;	
		}
	}
	public void execute()throws IOException
	{
			
	}
	
}