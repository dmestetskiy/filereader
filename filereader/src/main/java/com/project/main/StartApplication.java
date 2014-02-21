package com.project.main;

import java.util.Map;
import java.util.SortedSet;

import com.project.common.Constants;
import com.project.file.FileProcessor;
import com.project.input.UserInputReader;
import com.project.wordmap.util.MapProcessor;

public class StartApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String command = null;
		while(!(command =UserInputReader.readCommands()).equals(Constants.Q)){
			if(FileProcessor.doesFileExist(command)){
				long startTime = System.currentTimeMillis();
				Map<String, Long> wordTrack = FileProcessor.processFileString();
				SortedSet<Map.Entry<String,Long>> sortedWords = MapProcessor.processWords(wordTrack);
				String fileName = FileProcessor.writeToFile(command, sortedWords);
				System.out.println(Constants.YOUR_FILE_IS_HERE+":"+fileName);
				long endTime   = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				System.out.println("Total time in ms:"+totalTime);
				FileProcessor.clear();
			}else{
				System.out.println(Constants.COULD_NOT_PROCESS_INPUT);
			}
			System.out.println();
		}
		
	}

}
