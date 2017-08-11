package com.sourceallies.datareader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.sourceallies.trie.MostFrequentWordsWithFreq;

public class Main {
	public static void main(String[] args) {
		final FileReader fileReader = new FileReader();
		try {
			fileReader
					.readFileAndInsertInTrie(new FileInputStream(System.getProperty("user.dir") + "\\stop-words.txt"));
			fileReader.readFileAndMaintainMostFrequentWords(
					new FileInputStream(System.getProperty("user.dir") + "\\mobydick.txt"));
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

		for (final MostFrequentWordsWithFreq word : fileReader.getMostFrequentWord()) {
			System.out.println(word.toString());
		}

	}

}
