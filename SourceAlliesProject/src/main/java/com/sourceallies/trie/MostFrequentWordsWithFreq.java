package com.sourceallies.trie;

/**
 * Pojo class for maintaining word with their respective frequency count
 * 
 * @author amod0
 *
 */
public class MostFrequentWordsWithFreq implements Comparable<MostFrequentWordsWithFreq> {
	private final String word;
	private int freq;

	public MostFrequentWordsWithFreq(final String word, final int freq) {
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(final MostFrequentWordsWithFreq mostFrequentWordsWithFreq) {
		return freq - mostFrequentWordsWithFreq.freq;
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof MostFrequentWordsWithFreq)) {
			return false;
		}
		return freq == ((MostFrequentWordsWithFreq) obj).freq && word.equals(((MostFrequentWordsWithFreq) obj).word);
	}

	public int getFreq() {
		return freq;
	}

	public String getWord() {
		return word;
	}

	public void increaseFrequency() {
		freq = freq + 1;
	}

	@Override
	public String toString() {
		return word + " frequency " + freq;
	}
}
