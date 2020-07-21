/**
 * 
 */
package com.gfg.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author akshayas
 *
 */
public class MinSwaps {

	public static void main(String[] args) {
		int[] a = { 0, 2, 3, 4, 1, 6, 5 };
		System.out.println(minSwaps(a));
	}

	static int minSwaps(int[] a) {
		int n = a.length;
		List<Pair> arrPos = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			arrPos.add(new Pair(a[i], i));
		}
		arrPos.sort(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.key < o2.key)
					return -1;
				else if (o1.key == o2.key)
					return 0;
				else
					return 1;
			}
		});

		boolean[] visited = new boolean[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i] || arrPos.get(i).value == i)
				continue;
			int cycle_size = 0;
			int j = i;

			while (!visited[j]) {
				visited[j] = true;
				j = arrPos.get(j).value;
				cycle_size++;
			}

			if (cycle_size > 0) {
				ans += (cycle_size - 1);
			}
		}

		return ans;
	}
}

class Pair {
	int key;
	int value;

	public Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public String toString() {
		return key + ":" + value;
	}
}