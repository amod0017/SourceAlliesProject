/**
 *
 */
package com.sourceallies.trie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestTrie {
	private Trie myClassUnderTest;

	@Before
	public void setu() {
		myClassUnderTest = new Trie();
	}

	@Test
	public void testGetCount() {
		myClassUnderTest.insert("abc");
		myClassUnderTest.insert("abc");
		myClassUnderTest.insert("abcd");
		assertEquals(myClassUnderTest.getCount("abc"), 2);
	}

	@Test
	public void testInsert() {
		myClassUnderTest.insert("abcd");
		assertEquals(myClassUnderTest.search("abcd"), true);
		assertEquals(myClassUnderTest.search("abc"), false);
	}

	@Test
	public void testSearch() {
		myClassUnderTest.insert("abcd");
		assertEquals(myClassUnderTest.search("abcd"), true);
		assertEquals(myClassUnderTest.search("abc"), false);
	}

}
