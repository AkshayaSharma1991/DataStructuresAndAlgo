/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class TopNBuzzWords {

	public static void main(String[] args) {
		int numToys = 6;
		int topToys = 2;
		List<String> toys = Arrays.asList(new String[] { "elmo", "elsa", "legos", "drone", "tablet", "warcraft" });
		int numQuotes = 6;
		List<String> quotes = Arrays
				.asList(new String[] { "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
						"The new Elmo dolls are super high quality",
						"Expect the Elsa dolls to be very popular this year, Elsa!",
						"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
						"For parents of older kids, look into buying them a drone",
						"Warcraft is slowly rising in popularity ahead of the holiday season" });

		List<String> buzzWords = buzzWords(toys, numToys, quotes, numQuotes, topToys);

		System.out.println(buzzWords);
	}

	static List<String> buzzWords(List<String> toys, int numToys, List<String> quotes, int numQuotes, int nTopToys) {
		Map<String, ToyHolder> result = new HashMap<>();

		for (int i = 0; i < numToys; i++) {
			result.put(toys.get(i), new ToyHolder(toys.get(i)));
		}
		int max_count = Integer.MIN_VALUE;
		for (int i = 0; i < numQuotes; i++) {
			for (int j = 0; j < numToys; j++) {
				String[] sentence = quotes.get(i).split(" ");
				int wordCount = wordCount(sentence, toys.get(j));
				ToyHolder th = result.get(toys.get(j));
				th.wordCount += wordCount;
				max_count = Math.max(max_count, wordCount);
				if (wordCount > 0)
					th.quoteCount++;
			}
		}

		PriorityQueue<ToyHolder> queue = new PriorityQueue<>(new ToyComparator());

		for (String s : result.keySet()) {
			queue.add(result.get(s));
		}

		List<String> topToys = new ArrayList<>(nTopToys);
		for (int i = nTopToys; i > 0; i--) {
			topToys.add(queue.poll().toy);
		}

		return topToys;

	}

	static int wordCount(String[] sentence, String word) {
		int result = 0;
		for (int i = 0; i < sentence.length; i++) {
			String s1 = sentence[i].toLowerCase();
			if (s1.contains(word))
				result++;
		}
		return result;
	}
}

class ToyHolder {
	public int quoteCount = 0;
	public int wordCount = 0;
	public String toy = "";

	public ToyHolder(String toy) {
		this.toy = toy;
	}

	public String toString() {
		return (toy + " , " + wordCount + ":" + quoteCount);
	}
}

class ToyComparator implements Comparator<ToyHolder> {
	@Override
	public int compare(ToyHolder o1, ToyHolder o2) {
		if (o1.wordCount > o2.wordCount)
			return -1;
		else if (o1.wordCount < o2.wordCount)
			return +1;
		else {
			if (o1.quoteCount > o2.quoteCount)
				return -1;
			else
				return +1;
		}
	}

}
