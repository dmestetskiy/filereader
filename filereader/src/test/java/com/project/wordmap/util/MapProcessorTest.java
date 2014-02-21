package com.project.wordmap.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;

import org.junit.BeforeClass;
import org.junit.Test;

import com.project.file.FileProcessor;
import com.project.wordmap.util.MapProcessor;

public class MapProcessorTest {

	private static Map<String, Long> wordMap;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FileProcessor.clear();
		FileProcessor.doesFileExist("src/test/resources/testFile.txt");
		wordMap =FileProcessor.processFileString();
	}

	@Test
	public void processWords() {
		SortedSet<Entry<String, Long>> sortedMap = MapProcessor.processWords(wordMap);
		assertFalse(sortedMap.isEmpty());
		for (Entry<String, Long> s : sortedMap) {
			assertEquals(Long.valueOf("557"),s.getValue());
			break;
		}
		
	}

}
