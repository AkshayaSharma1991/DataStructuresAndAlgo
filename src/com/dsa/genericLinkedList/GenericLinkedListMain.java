/**
 * 
 */
package com.dsa.genericLinkedList;

import java.util.Iterator;

/**
 * @author akshayas
 *
 */
public class GenericLinkedListMain {
	
	public static void main(String[] arg) {
		GenericLinkedList<String> ll = new GenericLinkedList<>();
		ll.append("Ashish");
		ll.append("Akshaya");
		
		Iterator<String> llIterator = ll.iterator();
		while(llIterator.hasNext()) {
			System.out.println(llIterator.next());
		}
	}

}
