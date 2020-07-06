/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author akshayas
 *
 */
public class FavoriteGenres {

	public static void main(String[] args) {
		Map<String, List<String>> userSongs = new HashMap<String, List<String>>();
		List<String> list1 = Arrays.asList(new String[] { "song1", "song2", "song3", "song4", "song8" });
		List<String> list2 = Arrays.asList(new String[] { "song5", "song6", "song7" });

		userSongs.put("David", list1);
		userSongs.put("Emma", list2);

		Map<String, List<String>> songGenres = new HashMap<String, List<String>>();
		List<String> list3 = Arrays.asList(new String[] { "song1", "song3" });
		List<String> list4 = Arrays.asList(new String[] { "song7" });
		List<String> list5 = Arrays.asList(new String[] { "song2", "song4" });
		List<String> list6 = Arrays.asList(new String[] { "song5", "song6" });
		List<String> list7 = Arrays.asList(new String[] { "song8", "song9" });
		songGenres.put("Rock", list3);
		songGenres.put("Dubstep", list4);
		songGenres.put("Techno", list5);
		songGenres.put("Pop", list6);
		songGenres.put("Jazz", list7);

		Map<String, List<String>> userFavorites = getFavoriteGenres(userSongs, songGenres);
		System.out.println(userFavorites);
	}

	static Map<String, List<String>> getFavoriteGenres(Map<String, List<String>> userSongs,
			Map<String, List<String>> songGenres) {
		Map<String, List<String>> userFavorite = new HashMap<>();
		Map<String, String> songsToGenre = new HashMap<>();
		for (Entry<String, List<String>> genre : songGenres.entrySet()) {
			for (String song : genre.getValue()) {
				songsToGenre.put(song, genre.getKey());
			}
		}
		Map<String, Integer> countMap = new HashMap<>();
		int max = 0;
		for (String user : userSongs.keySet()) {
			countMap.clear();
			max = 0;
			userFavorite.put(user, new ArrayList<String>());
			for (String song : userSongs.get(user)) {
				String genre = songsToGenre.get(song);
				int count = countMap.getOrDefault(genre, 0) + 1;
				countMap.put(genre, count);
				max = Math.max(count, max);
			}

			for (String genre : countMap.keySet()) {
				if (countMap.get(genre) == max) {
					userFavorite.get(user).add(genre);
				}
			}
		}
		return userFavorite;
	}

}
