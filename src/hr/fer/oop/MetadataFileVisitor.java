package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class MetadataFileVisitor extends SimpleFileVisitor<Path> {
	private List<String> data = new LinkedList<>();

	public List<String> getMetaData() {
		return data;
	}

	private String fileExtension;

	public MetadataFileVisitor(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		data.add(dir.getFileName().toString() + "," + attrs.creationTime().toString().substring(0, 10) + " " + attrs.creationTime().toString().substring(11, 16) + "," + 0);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (fileExtension.equals("*") || file.getFileName().toString().endsWith(fileExtension))
			data.add(file.getFileName().toString() + "," + attrs.creationTime().toString().substring(0, 10) + " " + attrs.creationTime().toString().substring(11, 16) + "," + attrs.size());
		return FileVisitResult.CONTINUE;
	}

}
