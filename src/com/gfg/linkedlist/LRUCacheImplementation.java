/**
 * 
 */
package com.gfg.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author akshayas
 *
 */
public class LRUCacheImplementation {

	static Deque<Container> queue = new LinkedList<>();
	static int maxCount = 3;
	static int currCount = 0;
	static Map<String, Container> cacheMap = new HashMap<>();

	public static void main(String[] args) {
		LRUCacheImplementation.put("1", "one");
		LRUCacheImplementation.put("2", "two");
		LRUCacheImplementation.put("3", "three");
		System.out.println(queue.toString());
		LRUCacheImplementation.put("4", "four");
		System.out.println(queue.toString());
		LRUCacheImplementation.get("3");
		System.out.println(queue.toString());
		LRUCacheImplementation.put("1", "oneeee");
		System.out.println(queue.toString());
	}

	static String get(String key) {
		String value = null;
		if (cacheMap.containsKey(key)) {
			Container c = cacheMap.get(key);
			value = c.value;
			queue.remove(c);
			queue.addFirst(cacheMap.get(key));
		}
		return value;
	}

	static void put(String key, String value) {
		if (cacheMap.containsKey(key)) {
			Container c = cacheMap.get(key);
			c.value = value;
			queue.remove(c);
			queue.addFirst(c);
			cacheMap.put(key, c);
		} else {
			Container c = new Container(key, value);
			cacheMap.put(key, c);

			if (currCount < maxCount) {
				queue.addFirst(c);
				currCount++;
			} else {
				Container c1 = queue.removeLast();
				cacheMap.remove(c1.key);
				queue.addFirst(c);
			}
		}
	}
}

class Container {
	String key;
	String value;

	public Container(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String toString() {
		return key + ":" + value;
	}
}
