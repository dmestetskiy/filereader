package com.project.file;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.project.file.FileProcessor;

public class FileProcessorTest {

	@Test
	public void testDoesFileExistFalse() {
		assertFalse(FileProcessor.doesFileExist("asdfasdf"));
	}

	@Test
	public void testDoesFileExistTrue() {
		assertTrue(FileProcessor.doesFileExist("src/test/resources/testFile.txt"));
	}
	
	@Test
	public void testProcessFileString() {
		FileProcessor.doesFileExist("src/test/resources/testFile.txt");
		Map<String, Long> wordMap =FileProcessor.processFileString();
		assertFalse(wordMap.isEmpty());
		assertEquals(Long.valueOf(2),wordMap.get("datestamp"));
	}

}
