import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class WordCounter {
	
	ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	int count = 0;
	
	public void wordCount(String[] list){
		for(String word:list)
		{
			if(!map.containsKey(word))
			{
				map.put(word, 1);
			}
			else
			{
				map.put(word, map.get(word) + 1);
			}	
		}
	}
	
	public void sortHashMap(ConcurrentHashMap<String, Integer> passedMap)
	{
		ConcurrentHashMap t = passedMap;
		List<String> al = new ArrayList<String>(t.values());
		Collections.sort(al);
		
	}
	
	public String printMap(ConcurrentHashMap<String, Integer> passedMap)
	{
		String str = "";
		for (String key : map.keySet()) {
	        str += key + ", " + map.get(key) + "\n";
	    }
		
		System.out.println(str);
		
		return str;
	}
	
	public void populateAndSortArray(ConcurrentHashMap<String, Integer> passedMap)
	{
		int i = 0;
		String[][] array = new String[passedMap.size()][2];
		
		for (String key : map.keySet()) {
	        array[i][0] = map.get(key).toString();
	        array[i][1] = key;
	        i++;
	    }

		for(int row = 0; row < array.length-1; row++)
			System.out.println(array[row][0] + ", " + array[row][1]);
	}
}
