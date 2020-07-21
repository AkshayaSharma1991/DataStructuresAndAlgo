/**
 * 
 */
package com.gfg.trie;

import java.util.HashMap;
import java.util.Map;

import com.dsa.hashing.WordCount;

/**
 * @author akshayas
 *
 */
public class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode((char) 0);
	}

	public void insert(String s) {
		int length = s.length();
		TrieNode crawl = root;

		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			Map<Character, TrieNode> children = crawl.children;

			if (children.containsKey(c)) {
				crawl = children.get(c);
			} else {
				TrieNode temp = new TrieNode(c);
				children.put(c, temp);
				crawl = temp;
			}
		}
		crawl.isEnd = true;
	}

	public boolean wordBreak(String s, TrieNode root) {
		int length = s.length();
		for (int i = 1; i <=length; i++) {
			if (search(s.substring(0, i), root) && wordBreak(s.substring(i, length - i), root)) {
				return true;
			}
		}
		return false;
	}

	public boolean search(String s, TrieNode node) {
		int length = s.length();
		TrieNode crawl = node;

		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			Map<Character, TrieNode> children = crawl.children;
			if (children.containsKey(c)) {
				crawl = children.get(c);
			} else
				return false;
		}
		return crawl != null && crawl.isEnd;
	}

	public String getMatchingPrefix(String s) {
		int n = s.length();
		TrieNode crawl = root;
		StringBuilder sb = new StringBuilder();
		int prevLevel = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			Map<Character, TrieNode> children = crawl.children;
			if (children.containsKey(c)) {
				sb.append(c);
				crawl = children.get(c);

				if (crawl.isEnd)
					prevLevel = i + 1;
			} else
				break;
		}
		if (crawl.isEnd)
			return sb.substring(0, prevLevel).toString();
		return sb.toString();
	}

	public static void main(String[] args) {
		Trie dict = new Trie();
		dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");
		dict.insert("basement");
		String input = "caterer";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
		System.out.println(dict.search("cat", dict.root));
		System.out.println(dict.wordBreak("basement", dict.root));
	}
}

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isEnd;
	char value;

	public TrieNode(char c) {
		value = c;
		children = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
}