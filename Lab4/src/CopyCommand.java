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
		FileInputStream      fis = null;
		BufferedInputStream  bis = null;
		FileOutputStream     fos = null;
		BufferedOutputStream bos = null;
		
		long fileSize = fileIn.length();
		long numRead = 0;
		long left = fileSize;

		try
		{
			fis = new FileInputStream( fileIn );
			bis = new BufferedInputStream( fis );
			fos = new FileOutputStream( fileOut );
			bos = new BufferedOutputStream( fos );
			

			
			while ( left > 0 )
			{
				byte[] bytesWritten;
				
				if ( left > bufferSize )
				{
					bytesWritten = new byte[bufferSize];
				}
				else
				{
					bytesWritten = new byte[(int)left];
				}
				
				numRead = bis.read(bytesWritten);
				bos.write(bytesWritten, 0, bytesWritten.length);
				
				
				left -= numRead;
			}
		
			bos.flush();
		
		}
		catch( IOException ioe)
		{
			ioe.printStackTrace (System.err );
		}
		
		finally
		{
			if ( bis != null )
				bis.close();
				
			if ( fis != null )
				fis.close();
			
			if ( bos != null )
				bos.close();
				
			if ( fos != null )
				fos.close();
		}

		
	}
	
}