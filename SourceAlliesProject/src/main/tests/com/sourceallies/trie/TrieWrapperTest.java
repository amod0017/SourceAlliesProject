package com.sourceallies.trie;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TrieWrapperTest {
	private TrieWrapper myClassUnderTest;

	@Before
	public void setup() {
		myClassUnderTest = new TrieWrapper();
	}

	@Test
	public void testTrieInsert() {
		myClassUnderTest.trieInsert("abc");
		myClassUnderTest.trieInsert("abcd");
		myClassUnderTest.trieInsert("bcd");
		final List<MostFrequentWordsWithFreq> myExpectedOutput = new ArrayList<>();
		myExpectedOutput.add(new MostFrequentWordsWithFreq("abc", 1));
		myExpectedOutput.add(new MostFrequentWordsWithFreq("abcd", 1));
		myExpectedOutput.add(new MostFrequentWordsWithFreq("bcd", 1));
		assertEquals(myExpectedOutput, myClassUnderTest.getMostFreqWords());

	}

}
