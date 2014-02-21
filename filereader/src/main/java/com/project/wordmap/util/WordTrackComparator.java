package com.project.wordmap.util;

import java.util.Comparator;
import java.util.Map;

public class WordTrackComparator implements Comparator<Map.Entry<String, Long>> {

	Map<String, Long> wordTrack;

	public WordTrackComparator(Map<String, Long> wordTrack) {
		this.wordTrack = wordTrack;
	}

	@Override
	public int compare(Map.Entry<String, Long> e1, Map.Entry<String, Long> e2) {
		int compareValue = e1.getValue().compareTo(e2.getValue());
		if (compareValue > 0) {
			return -1;
		} else if (compareValue < 0) {
			return 1;
		} else {
			if (e1.getKey().compareTo(e2.getKey()) < 0) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
