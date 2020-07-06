/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author akshayas
 *
 */
public class ItemAssociation {

	public static void main(String[] args) {
		PairString p1 = new PairString("Item1", "Item2");
		PairString p2 = new PairString("Item3", "Item4");
		PairString p3 = new PairString("Item4", "Item5");

		List<PairString> ps = new ArrayList<>();
		ps.add(p1);
		ps.add(p2);
		ps.add(p3);
		List<String> l = largestItemAssociation(ps);
		System.out.println(l);
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	// RETURN "null" IF NO ITEM ASSOCIATION IS GIVEN
	static List<String> largestItemAssociation(List<PairString> itemAssociation) {
		// Return null if no itemAssociation is given
		if (itemAssociation == null || itemAssociation.size() == 0)
			return null;

		int associationSize = itemAssociation.size();
		Map<Integer, List<String>> associationMap = new HashMap<>();
		Set<String> uniqueItems = new HashSet<>();
		for (int i = 0; i < associationSize; i++) {
			PairString itemPair = itemAssociation.get(i);
			String[] items = new String[] { itemPair.first, itemPair.second };
			int key = -1;
			List<String> groupItems = new ArrayList<String>();
			boolean addItems = false;
			for (int j = 0; j < items.length; j++) {
				String item = items[j];
				if (key != -1) {
					if (!uniqueItems.contains(item)) {
						associationMap.get(key).add(item);
						uniqueItems.add(item);
					}
				} else {
					if (uniqueItems.contains(item)) {
						Set<Integer> groups = associationMap.keySet();
						for (int group : groups) {
							List<String> groupItems1 = associationMap.get(group);
							for (String groupItem : groupItems1) {
								if (groupItem.equalsIgnoreCase(item)) {
									key = group;
									break;
								}
							}
						}
					} else {
						groupItems.add(item);
						uniqueItems.add(item);
						addItems = true;
					}
				}
			}
			if (addItems) {
				associationMap.put(i, groupItems);
			}
		}
		int maxAssociation = Integer.MIN_VALUE;
		List<Integer> maxIds = new ArrayList<>();
		Set<Integer> associationId = associationMap.keySet();
		for (int id : associationId) {
			if (maxAssociation < associationMap.get(id).size()) {
				maxAssociation = associationMap.get(id).size();
				maxIds.clear();
				maxIds.add(id);
			} else if (maxAssociation == associationMap.get(id).size()) {
				maxIds.add(id);
			}
		}

		if (maxIds.size() == 1) {
			Collections.sort(associationMap.get(maxIds.get(0)));
			return associationMap.get(maxIds.get(0));
		} else {
			int maxIdFinal = -1;
			String lexString = "";
			for (Integer maxId : maxIds) {
				Collections.sort(associationMap.get(maxId));
				if (lexString.isEmpty()) {
					lexString = associationMap.get(maxId).get(0);
					maxIdFinal = maxId;
				} else {
					int compare = lexString.compareTo(associationMap.get(maxId).get(0));
					if (compare > 0)
						maxIdFinal = maxId;
				}
			}
			return associationMap.get(maxIdFinal);
		}
	}
	// METHOD SIGNATURE ENDS
}

class PairString {
	String first;
	String second;

	public PairString(String first, String second) {
		this.first = first;
		this.second = second;
	}
}
