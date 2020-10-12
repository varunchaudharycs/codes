package random;

import java.io.*;
import java.util.*;

public class FavoriteGenres {

	public static void main(String[] args) throws IOException {

		Map<String, List<String>> userSongs = new HashMap<String, List<String>>() {{

			put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
   			put("Emma", Arrays.asList("song5", "song6", "song7"));
		}};

		Map<String, List<String>> songGenres = new HashMap<String, List<String>>() {{

			put("Rock", Arrays.asList("song1", "song3"));
   			put("Dubstep", Arrays.asList("song7"));
   			put("Techno", Arrays.asList("song2", "song4"));
   			put("Pop", Arrays.asList("song5", "song6"));
   			put("Jazz", Arrays.asList("song8", "song9"));
		}};

		new FavoriteGenres().findGenres(userSongs, songGenres);
	}

	public void findGenres(Map<String, List<String>> userSongs, Map<String, List<String>> genreSongs) {

		Map<String, List<String>> result = new HashMap<>();

		Map<String, String> songGenres = new HashMap<>();

		for(Map.Entry<String, List<String>> e : genreSongs.entrySet()) {

			String genre = e.getKey();
			List<String> songs = e.getValue();

			for(String song : songs) {

				songGenres.put(song, genre);
			}
		}

		for(Map.Entry<String, List<String>> e : userSongs.entrySet()) {

			String user = e.getKey();
			List<String> songs = e.getValue();
			int maxValue = 0;

			HashMap<String, Integer> userGenres = new HashMap<>();

			for(String song : songs) {

				userGenres.put(songGenres.get(song), userGenres.getOrDefault(songGenres.get(song), 0) + 1);
				maxValue = Math.max(maxValue, userGenres.get(songGenres.get(song)));
			}

			List<String> favGenres = new ArrayList<>();

			for(Map.Entry<String, Integer> x : userGenres.entrySet()) {

				if(x.getValue() == maxValue) { favGenres.add(x.getKey()); }
			}

			result.put(user, favGenres);
		}

		System.out.println(result);
	}
}