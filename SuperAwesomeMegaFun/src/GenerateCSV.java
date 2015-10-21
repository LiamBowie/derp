
import java.awt.Desktop;
import java.io.*;

public class GenerateCSV {

	private File f;

	public void generateFile(String str, String directory)
	{
		File f = new File(directory + "/derp.csv");
		try
		{
			FileWriter writer = new FileWriter(f);
			writer.append("WORD, FREQUENCY, \n");
			writer.append(str);
			writer.flush();
			writer.close();
			
			this.f = f;
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void openFile()
	{
		try
		{
			Desktop.getDesktop().open(this.f);
		}catch(Exception e){};
	}
}
