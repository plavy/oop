package hr.fer.oop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Run {

	public static void main(String[] args) {
		Collection list = new Collection();
		list.add("Ahoj");
		list.add("Ahoj");
		list.add("Ola");
		list.add("Ola");
		list.add("Hej");
		list.add("Hai");

		for(Pair<String, Integer> i : list) {
			System.out.format("%s %s%n", i.getFirst(), i.getSecond());
		}
		
		list.add("Ahoj");
		
		System.out.println();
		for(Pair<String, Integer> i : list) {
			System.out.format("%s %s%n", i.getFirst(), i.getSecond());
		}
	}
		
}
