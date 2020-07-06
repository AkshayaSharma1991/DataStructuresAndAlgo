/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author akshayas
 *
 */
public class SuggestedProducts {

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		List<List<String>> suggestedProducts = suggestedProducts(products, "mouse");

		System.out.println(suggestedProducts);
		
		String[] products1 = { "havana" };
		List<List<String>> suggestedProducts1 = suggestedProducts(products1, "tikona");

		System.out.println(suggestedProducts1);
	}

	static List<List<String>> suggestedProducts(String[] products, String searchString) {
		List<List<String>> suggestedProducts = new ArrayList<List<String>>();
		Arrays.sort(products);
		for (int i = 0; i < searchString.length(); i++) {
			int count = 0;
			String currSearchString = searchString.substring(0, i + 1);
			List<String> currProducts = new ArrayList<>();
			for (String product : products) {
				if (count > 2)
					break;
				boolean isMatch = true;
				for (int j = 0; j < currSearchString.length(); j++) {
					if (product.charAt(j) == currSearchString.charAt(j))
						continue;
					else {
						isMatch = false;
						break;
					}
				}
				if (isMatch) {
					currProducts.add(product);
					count++;
				}
			}
			suggestedProducts.add(currProducts);
		}
		return suggestedProducts;
	}
}
