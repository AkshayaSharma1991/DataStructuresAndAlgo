/**
 * 
 */
package com.gfg.string.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author akshayas
 *
 */
public class PermuteString {
	
	public static void main(String[] args)  throws NumberFormatException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(reader.readLine());
		
		for (int i = 1; i <= cases ; i++) {
			String s = reader.readLine();
			List<String> s1 = new ArrayList<>();
			permute(s, 0, s.length(),s1);
			StringBuffer sb =  new StringBuffer();
			Collections.sort(s1);
			for(int j=0; j<s1.size();j++) {
				sb.append(s1.get(j)  + " ");
			}
			System.out.println(sb);
		}
	}
	
	private static void permute(String a, int start, int end, List<String> response) {
		if(start ==  end-1) {
			response.add(a);
			return;
		}else {
			for(int  i= start; i<end;  i++) {
				a = swap(a, start, i);
				permute(a, start+1, end, response);
				a = swap(a, start,i);
			}
		}
		
	}
	
	
	private static String swap(String a, int x, int y) {
		char[] b  = a.toCharArray();
		char c =  b[x];
		b[x] = b[y];
		b[y] =  c;
		return String.valueOf(b);
	}

}
