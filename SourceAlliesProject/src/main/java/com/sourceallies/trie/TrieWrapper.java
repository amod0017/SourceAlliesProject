package com.sourceallies.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class maintains a list of most frequenct word inserted at any given
 * instance
 *
 * @author amod0
 *
 */
public class TrieWrapper {
	private static final int MAX = 100;
	private final Trie root;
	private final List<MostFrequentWordsWithFreq> mostFreqWords;

	public TrieWrapper() {
		root = new Trie();
		mostFreqWords = new ArrayList<>();
	}

	public List<MostFrequentWordsWithFreq> getMostFreqWords() {
		return mostFreqWords;
	}

	public void trieInsert(final String word) {
		root.insert(word);
		final int indexOf = mostFreqWords.indexOf(new MostFrequentWordsWithFreq(word, root.getCount(word) - 1));
		if (mostFreqWords.size() < MAX) {
			// if mostFreq contains element
			if (indexOf > -1) {
				mostFreqWords.get(indexOf).increaseFrequency();
			} else {
				mostFreqWords.add(new MostFrequentWordsWithFreq(word, root.getCount(word)));
			}
		} else {
			// element is in list so increase freq
			if (indexOf != -1) {
				mostFreqWords.get(indexOf).increaseFrequency();
			}
			// if word.freq is greater than the minimum
			// remove minimum element i.e. first
			// add new element to list
			// sort list
			else if (root.getCount(word) >= mostFreqWords.get(0).getFreq()) {
				mostFreqWords.remove(0);
				mostFreqWords.add(new MostFrequentWordsWithFreq(word, root.getCount(word)));
			} // else it's fine no update needed in list
		}
		Collections.sort(mostFreqWords);
	}

}
