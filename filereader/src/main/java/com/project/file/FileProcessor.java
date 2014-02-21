package com.project.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;

import com.project.common.Constants;

public class FileProcessor {
	private static BufferedReader br = null;
	private static File fileToRead = null;
	private static Map<String, Long> wordTrack = new HashMap<String, Long>();
	private static int longestWord = 0;

	public static Boolean doesFileExist(String filePath) {
		fileToRead = new File(filePath);
		Boolean fileExists = fileToRead.exists() && fileToRead.canRead();
		return fileExists;

	}

	public static Map<String, Long> processFileString() {
		try {
			br = new BufferedReader(new FileReader(fileToRead));
			String line;
			while ((line = br.readLine()) != null) {
				processFileLine(line.toLowerCase());
			}
		} catch (FileNotFoundException e) {
			System.out.println(Constants.FILE_NOT_FOUND);
		} catch (IOException e) {
			System.out.println(Constants.UNKNOWN_ERROR);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(Constants.UNKNOWN_ERROR);
				}
			}
		}

		return wordTrack;

	}

	private static void processFileLine(String s) {
		String[] words = s.split(Constants.WORD_PATTERN);
		for (String word : words) {
			if (word.length() > 0 && !word.equals("\"") && !word.equals("'")
					&& !word.contains(" ")) {
				if (longestWord < word.length()) {
					longestWord = word.length();
				}
				if (wordTrack.containsKey(word)) {
					Long count = wordTrack.get(word) + Long.valueOf("1");
					wordTrack.put(word, count);
				} else {
					wordTrack.put(word, Long.valueOf("1"));
				}
			}
		}
	}

	public static String writeToFile(String filePath,
			SortedSet<Map.Entry<String, Long>> sortedWords) {
		File output = new File(fileToRead.getParent() + "/fileSummary.txt");
		try {
			PrintWriter printer = new PrintWriter(output);
			for (Entry<String, Long> wordEntry : sortedWords) {
				printer.write(String.format("%-" + longestWord + "s",
						wordEntry.getKey())
						+ " - " + wordEntry.getValue() + "\n");
			}

			printer.close();
		} catch (FileNotFoundException e) {
			System.out.println(Constants.OUTPUT_FILE_NOT_FOUND);
		}

		return output.getAbsolutePath();
	}

	public static void clear() {
		fileToRead = null;
		wordTrack = new HashMap<String, Long>();
	}

}
