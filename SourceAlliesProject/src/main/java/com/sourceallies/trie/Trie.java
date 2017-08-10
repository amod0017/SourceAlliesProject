package com.sourceallies.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private final Map<Character, Trie> childrens;
	private boolean isEndOfTheWord;
	private int frequency;

	/** Initialize your data structure here. */
	public Trie() {
		childrens = new HashMap<>();
		isEndOfTheWord = false;
		frequency = 0;
	}

	/**
	 * returns the number of time a word had occured.
	 */

	public int getCount(final String word) {
		Trie current = this;
		for (int i = 0; i < word.length(); i++) {
			final Trie node = current.childrens.get(word.charAt(i));
			if (node == null) {
				return 0;
			}
			current = node;
		}
		return current.frequency;

	}

	/** Inserts a word into the trie. */
	public void insert(final String word) {
		Trie current = this;
		for (int i = 0; i < word.length(); i++) {
			Trie node = current.childrens.get(word.charAt(i));
			if (node == null) {
				node = new Trie();
				current.childrens.put(word.charAt(i), node);
			}
			current = node;
		}
		current.isEndOfTheWord = true;
		current.frequency = current.frequency + 1;
	}

	/** Returns if the word is in the trie. */
	public boolean search(final String word) {
		Trie current = this;
		for (int i = 0; i < word.length(); i++) {
			final Trie node = current.childrens.get(word.charAt(i));
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfTheWord;

	}

}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */