package com.sourceallies.trie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MostFrequentWordsWithFreqTest {
	private MostFrequentWordsWithFreq myClassUnderTest;

	@Before
	public void setup() {
		myClassUnderTest = new MostFrequentWordsWithFreq("abcd", 2);
	}

	@Test
	public void testCompare() {
		final MostFrequentWordsWithFreq smallerMostFrequent = new MostFrequentWordsWithFreq("abc", 1);
		final MostFrequentWordsWithFreq equalMostFrequent = new MostFrequentWordsWithFreq("abcde", 2);
		final MostFrequentWordsWithFreq largerMostFrequent = new MostFrequentWordsWithFreq("abcd", 21);
		assertTrue(myClassUnderTest.compareTo(smallerMostFrequent) > 0);
		assertTrue(myClassUnderTest.compareTo(equalMostFrequent) == 0);
		assertTrue(myClassUnderTest.compareTo(largerMostFrequent) < 0);
	}

	@Test
	public void testEquals() {
		final MostFrequentWordsWithFreq falseMostFrequent = new MostFrequentWordsWithFreq("abc", 1);
		final MostFrequentWordsWithFreq falseMostFrequent1 = new MostFrequentWordsWithFreq("abcd", 1);
		final MostFrequentWordsWithFreq trueMostFrequent = new MostFrequentWordsWithFreq("abcd", 2);
		final String notInstanceOf = "A";

		assertEquals(myClassUnderTest.equals(falseMostFrequent), false);
		assertEquals(myClassUnderTest.equals(falseMostFrequent1), false);
		assertEquals(myClassUnderTest.equals(trueMostFrequent), true);
		assertEquals(myClassUnderTest.equals(notInstanceOf), false);
	}

	@Test
	public void testGetFreq() {
		assertEquals(myClassUnderTest.getFreq(), 2);
	}

	@Test
	public void testGetWord() {
		assertEquals(myClassUnderTest.getWord(), "abcd");
	}

	@Test
	public void testIncreaseFrequency() {
		myClassUnderTest.increaseFrequency();
		assertEquals(myClassUnderTest.getFreq(), 3);
	}

	@Test
	public void testToString() {
		assertEquals(myClassUnderTest.toString(), "abcd" + " frequency " + 2);
	}

}
