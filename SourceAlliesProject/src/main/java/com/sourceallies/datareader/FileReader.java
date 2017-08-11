package com.sourceallies.datareader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import com.sourceallies.trie.MostFrequentWordsWithFreq;
import com.sourceallies.trie.Trie;
import com.sourceallies.trie.TrieWrapper;

public class FileReader {
	private final Trie stopWords;
	private final TrieWrapper frequentWords;

	public FileReader() {
		stopWords = new Trie();
		frequentWords = new TrieWrapper();
	}

	public List<MostFrequentWordsWithFreq> getMostFrequentWord() {
		return frequentWords.getMostFreqWords();
	}

	private void insertInTrie(String[] words) {
		for (final String string : words) {
			stopWords.insert(string);
		}
	}

	private void insertInTrieWrapper(String[] words) {
		for (final String string : words) {
			if (!stopWords.search(string)) {
				frequentWords.trieInsert(string);
			}

		}
	}

	public void readFileAndInsertInTrie(InputStream myFile) {
		String line;
		try (InputStreamReader inputStreamReader = new InputStreamReader(myFile, Charset.forName("UTF-8"));
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

			while ((line = bufferedReader.readLine()) != null) {
				final String[] words = line.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
				insertInTrie(words);
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public void readFileAndMaintainMostFrequentWords(FileInputStream myFile) {
		String line;
		try (InputStreamReader inputStreamReader = new InputStreamReader(myFile, Charset.forName("UTF-8"));
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

			while ((line = bufferedReader.readLine()) != null) {
				final String[] words = line.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
				insertInTrieWrapper(words);
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}
}
