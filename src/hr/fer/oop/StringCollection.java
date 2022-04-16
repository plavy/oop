package hr.fer.oop;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class StringCollection implements Iterable<Map.Entry<String, Integer>>{
	private Map<String, Integer> map = new TreeMap<>();
	public void add(String string) {
		Integer count = map.get(string);
		count = count == null ? 1 : ++count;
		map.put(string, count);	
	}
	
	public void remove(String string) {
		Integer count = map.get(string);
		if (count != null) {
			--count;
			if (count == 0)
				map.remove(string);
			else
				map.put(string, count);
		}			
	}
	
	@Override
	public Iterator<Entry<String, Integer>> iterator() {
		return map.entrySet().iterator();
	}
	
}
