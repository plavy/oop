package hr.fer.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MyInt implements Iterable<Integer>{
	private int broj;
	private List<Integer> lista;
	
	public MyInt(int broj) {
		this.broj = broj;
		this.lista = new ArrayList<>();
		
		int i = 2;
		int tmp = broj;
		int brdj;
		while(true) {
			if(tmp % i == 0) {
				tmp = tmp / i;
				lista.add(i);
			} else {
				i++;
			}
			if(tmp == 1) break;
		}
	}
		
	public Iterator<Integer> iterator() {
		return lista.iterator();
	}
}
