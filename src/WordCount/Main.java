package WordCount;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		
		Path baseResourcePath = Paths.get(System.getProperty("user.dir"), "resources");
		
		File files[] = new File[new File(baseResourcePath.toString()).list().length];
		WordCounter wordCounter[] = new WordCounter[files.length];
		int position = 0;
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(baseResourcePath)) {
		    for (Path filesInDirectory: stream) {
		    	files[position] = filesInDirectory.toFile();
		    	position++;
		    }
		} catch (IOException | DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
		

		WordCounter firstFile = new WordCounter(files[0]);

		WordCounter secondFile = new WordCounter(files[1]);

		WordCounter thirdFile = new WordCounter(files[2]);

		WordCounter fourthFile = new WordCounter(files[3]);
		
		
		firstFile.run();
		secondFile.run();
		thirdFile.run();
		fourthFile.run();
		
		firstFile.join();
		secondFile.join();
		thirdFile.join();
		fourthFile.join();
		
		System.out.println("\n*----------Finished counting words----------*");
		
		
		
		
	}

}
