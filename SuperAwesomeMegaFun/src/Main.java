import java.io.*;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		FileExtractor fe = new FileExtractor();
		String directory = fe.getFolderLocation();
		System.out.println(directory);
		String text = fe.getFormattedText(directory);

		String[] list = text.split(" ");
		
		WordCounter wc = new WordCounter();
		wc.wordCount(list);
		
		wc.populateAndSortArray(wc.map);

		String s = wc.printMap(wc.map);
		
		int pos = directory.lastIndexOf("\\");
		System.out.println(pos);
		String saveDirectory = directory.substring(0 , pos+1);
		System.out.println(saveDirectory);
		
		GenerateCSV csv = new GenerateCSV();
		csv.generateFile(s, saveDirectory);
		csv.openFile();
	}
}
