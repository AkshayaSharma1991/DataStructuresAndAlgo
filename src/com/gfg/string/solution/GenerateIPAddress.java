/**
 * 
 */
package com.gfg.string.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akshayas
 *
 */
public class GenerateIPAddress {

	public static void main(String[] args) {
		System.out.println(generateIP("25525511135").toString());
	}

	static List<String> generateIP(String s) {
		if (s.length() < 3 || s.length() > 12) {
			return new ArrayList<String>();
		}
		return convert(s);
	}

	static List<String> convert(String s) {
		ArrayList<String> l = new ArrayList<>();
		int size = s.length();

		String snew = s;

		for (int i = 1; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					snew = snew.substring(0, k) + "." + snew.substring(k);
					snew = snew.substring(0, j) + "." + snew.substring(j);
					snew = snew.substring(0, i) + "." + snew.substring(i);

					if (isValid(snew)) {
						l.add(snew);
					}
					snew = s;
				}
			}
		}
		return l;
	}

	private static boolean isValid(String ip) {
		String a[] = ip.split("[.]");
		for (String s : a) {
			int i = Integer.parseInt(s);
			if (s.length() > 3 || i < 0 || i > 255) {
				return false;
			}
			if (s.length() > 1 && i == 0)
				return false;
			if (s.length() > 1 && i != 0 && s.charAt(0) == '0')
				return false;
		}

		return true;
	}
}
