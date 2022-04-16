package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class MyVisitor extends SimpleFileVisitor<Path>{
	private Map<String, Integer> map = new HashMap<>();
	
	public Map<String, Integer> getMap() {
		return map;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if(attrs.size() > 0) {
			System.out.println(file);			
		}
		return FileVisitResult.CONTINUE;
	}

	
}
