/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NGram {
  /**
   * Iterate through each line of input.
   */
	
	static String text = "Mary had a little lamb its fleece was white as snow;\n" + 
			"And everywhere that Mary went, the lamb was sure to go.\n" + 
			"It followed her to school one day, which was against the rule;\n" + 
			"It made the children laugh and play, to see a lamb at school.\n" + 
			"And so the teacher turned it out, but still it lingered near,\n" + 
			"And waited patiently about till Mary did appear.\n" + 
			"\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";
	 static String modifiedText = text.replaceAll("\\n", " ").replaceAll(",", "").replaceAll("\\.", " ")
			  .replaceAll("\"", "").replaceAll("\\?", "").replaceAll(";"," ");
	public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String word = line.split(",")[1];
      getPrediction(word);
    }
  }
  
  static void getPrediction(String word) {
	  List<Pair> predictions = buildFrequency(word);
	  DecimalFormat df = new DecimalFormat("0.000"); 
	  StringBuilder sb = new StringBuilder();
	  for(int i=0; i<predictions.size(); i++) {
		  sb.append(predictions.get(i).s  + "," + df.format(predictions.get(i).score) + ";");
	  }
	  System.out.println(sb.toString().substring(0, sb.length()-1));
  }
  
  static List<Pair> buildFrequency(String searchString) {
	 
	  
	  String[] tokens = modifiedText.split(" ");
	  Map<String, Integer> frequencyMap = new HashMap<>();
	  
	  int  totalWords = 0;
	  
	  for(int i=0; i<tokens.length-1; i++) {
		  if(tokens[i].equalsIgnoreCase(searchString)) {
			  frequencyMap.put(tokens[i+1], frequencyMap.getOrDefault(tokens[i+1], 0)  + 1);
			  totalWords++;
		  }
	  }
	  
	 List<Pair> prediction = new ArrayList<>();
	 
	 for(Entry<String, Integer> entry: frequencyMap.entrySet()) {
		 prediction.add(new Pair(entry.getKey(), (double)entry.getValue()/totalWords));
	 }
	  
	 Collections.sort(prediction);
	 return prediction;
  }
}

class Pair  implements Comparable<Pair>{
	String s;
	Double score;
	
	public Pair(String s, Double score) {
		this.s = s;
		this.score = score;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Pair o) {
		if(o.score.compareTo(this.score)==0) {
			return this.s.compareTo(o.s);
		}
		return o.score.compareTo(this.score);
	}
	
	
}