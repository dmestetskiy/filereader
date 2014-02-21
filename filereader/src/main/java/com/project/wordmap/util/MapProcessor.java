package com.project.wordmap.util;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapProcessor {

	
	public static SortedSet<Map.Entry<String, Long>> processWords(Map<String, Long> wordTrack){
		WordTrackComparator wtc = new WordTrackComparator(wordTrack);
		SortedSet<Map.Entry<String, Long>> sortedWords =  new TreeSet<Map.Entry<String, Long>>(wtc);
		sortedWords.addAll(wordTrack.entrySet());
		
		return sortedWords;
		
	}
	
}
