package hr.fer.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Collection implements Iterable<Pair<String, Integer>> {
	List<String> list = new ArrayList<>();

	public void add(String s) {
		list.add(s);
	}

	@Override
	public Iterator<Pair<String, Integer>> iterator() {
		Map<String, Integer> map = new TreeMap<>();
		for (String s : list) {
			map.compute(s, (a, b) -> b == null ? 1 : b + 1);
		}
		List<Pair<String, Integer>> lista = new ArrayList<>();
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			lista.add(new Pair<String, Integer>(e.getKey(), e.getValue()));
		}
		Collections.reverse(lista);
		return lista.iterator();
	}

}
