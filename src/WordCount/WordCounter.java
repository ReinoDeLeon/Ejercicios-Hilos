package WordCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter extends Thread {
	private String actualLine;
	private int wordCount;
	private File readingFile;
	private BufferedReader reader;
	private final String splitter = " ";
	
	public WordCounter(File _readingFile) {
		readingFile = _readingFile;
	}
	
	@Override
	public void run() {
			try {
				FileReader fileReader = new FileReader(readingFile);
				reader = new BufferedReader(fileReader);
				while ((actualLine=reader.readLine())!= null) {
					countLetters(actualLine);
				}
				System.out.printf("File %s has %d words.\n",readingFile.getName(), wordCount);
			}
			catch (IOException e) {
			}
	}
	


	private void countLetters(String actualLine) {
		for (int j = 0; j < actualLine.split(splitter).length; j++) {
			wordCount++;
		}
		
		
	}
	
}
