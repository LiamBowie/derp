import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileExtractor {

	private File directory;
	private String directoryString;
	private String text = "";
	
	public String getFolderLocation()
	{
		folderLocation();
		return directoryString;
	}
	
	public String getFormattedText(String path) throws FileNotFoundException
	{
		readText(path);
		return text;
	}
	
	private void folderLocation(){
		JFileChooser f = new JFileChooser();
		f.setCurrentDirectory(new File("D:\\Users\\Iain\\Documents"));
		f.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
		f.showOpenDialog(null);

		directory = f.getSelectedFile();
		directoryString = directory.getAbsolutePath();
		//return(directoryString);
	}
	
	private void readText(String path) throws FileNotFoundException
	{
		File file = new File(path);
		Scanner fileIn = new Scanner(file);
		String word;
		
		while(fileIn.hasNext())
		{
			word = fileIn.next();
			text = text.concat(word + " ");
		}
		fileIn.close();
		
		text = text.toLowerCase().replaceAll("[^a-z0-9 ]", "").replaceAll("  ", " ");
	}

}
