import java.io.*;
import java.util.*;

class NearestCity {

	public static void main(String[] args) throws IOException {

		String[] cities = new String[]{"c1", "c2", "c3"};

		int[] allX = new int[]{3, 2, 1};
		int[] allY = new int[]{3, 2, 3};

		int numOfQueries = 3;

		String[] queries = new String[]{"c1", "c2", "c3"};

		String[] ret = findNearest(cities, allX, allY, numOfQueries, queries);

		for(String s: ret) { System.out.println(s); }
	}

	public static int findDistance(int x1, int y1, int x2, int y2) {

		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	// LOGIC - maintain tree map. So, for a matching X, distance is calc ONLY b/w Ylower and Yupper
	public static String[] findNearest(String[] cities, int[] allX, int[] allY, int numOfQueries, String[] queries) {

		int totalCities = cities.length;

		String[] nearest = new String[totalCities]; // stores results

		Map<Integer, TreeMap<Integer, String>> mapX = new HashMap<>();
		Map<Integer, TreeMap<Integer, String>> mapY = new HashMap<>();
		Map<String, Integer> city_idx = new HashMap<>();

		String[] result = new String[numOfQueries];

		for(int i = 0; i < totalCities; ++i) {

			mapX.computeIfAbsent(allX[i], k -> new TreeMap<Integer, String>()).put(allY[i], cities[i]);
			mapY.computeIfAbsent(allY[i], k -> new TreeMap<Integer, String>()).put(allX[i], cities[i]);
			city_idx.put(cities[i], i);			
		}

		for(int i = 0; i < numOfQueries; ++i) {

			int idx = city_idx.get(queries[i]);

			if(nearest[idx] != null) { 

				result[i] = nearest[idx]; 
				continue;
			}

			int x = allX[idx];
			int y = allY[idx];

			if(mapX.get(x).size() > 1 || mapY.get(y).size() > 1) { // MATCH

				int nearestDistance = Integer.MAX_VALUE;
				String nearestCity = "";

				if(mapX.get(x).size() > 1) { // SAME X

					TreeMap<Integer, String> sameXCitiesY = mapX.get(x);

					Map.Entry<Integer, String> lowerBound = sameXCitiesY.lowerEntry(y);
					Map.Entry<Integer, String> upperBound = sameXCitiesY.higherEntry(y);

					if(lowerBound == null) {

						nearestDistance = findDistance(x, y, x, upperBound.getKey());
						nearestCity = upperBound.getValue();
					}
					else if(upperBound == null) {

						nearestDistance = findDistance(x, y, x, lowerBound.getKey());
						nearestCity = lowerBound.getValue();
					}
					else {

						int lowerDistance = findDistance(x, y, x, lowerBound.getKey());
						int upperDistance = findDistance(x, y, x, upperBound.getKey());

						if(lowerDistance < upperDistance) {

							nearestDistance = lowerDistance;
							nearestCity = lowerBound.getValue();
						}
						else {

							nearestDistance = upperDistance;
							nearestCity = upperBound.getValue();
						}
					}
					
				}

				if(mapY.get(y).size() > 1) { // SAME Y

					TreeMap<Integer, String> sameYCitiesX = mapY.get(y);

					Map.Entry<Integer, String> lowerBound = sameYCitiesX.lowerEntry(x);
					Map.Entry<Integer, String> upperBound = sameYCitiesX.higherEntry(x);

					int currDistance;
					String currCity;

					if(lowerBound == null) {

						currDistance = findDistance(x, y, upperBound.getKey(), y);
						currCity = upperBound.getValue();
					}
					else if(upperBound == null) {

						currDistance = findDistance(x, y, lowerBound.getKey(), y);
						currCity = lowerBound.getValue();
					}
					else {

						int lowerDistance = findDistance(x, y, lowerBound.getKey(), y);
						int upperDistance = findDistance(x, y, upperBound.getKey(), y);

						if(lowerDistance < upperDistance) {

							currDistance = lowerDistance;
							currCity = lowerBound.getValue();
						}
						else {

							currDistance = upperDistance;
							currCity = upperBound.getValue();
						}
					}

					if(currDistance <= nearestDistance) {

						if(currDistance < nearestDistance) {

							nearestDistance = currDistance;
							nearestCity = currCity;
						}
						else {

							nearestCity = (nearestCity.compareTo(currCity) > 0) ? currCity : nearestCity;
						}
					}
				}

				result[i] = nearestCity;
				nearest[idx] = result[i];
			}
			else { // NO MATCH

				result[i] = "None";
				nearest[idx] = "None";
			} 
		}

		return result;
	}

	// Maintain maps- x_coordinate -> [cities] & y_coordinate -> [cities] & city -> index.
	// public static String[] findNearest(String[] cities, int[] allX, int[] allY, int numOfQueries, String[] queries) {

	// 	int totalCities = cities.length;

	// 	String[] nearest = new String[totalCities]; // stores results

	// 	Map<Integer, List<Integer>> mapX = new HashMap<>();
	// 	Map<Integer, List<Integer>> mapY = new HashMap<>();
	// 	Map<String, Integer> city_idx = new HashMap<>();

	// 	String[] result = new String[numOfQueries];

	// 	for(int i = 0; i < totalCities; ++i) {

	// 		mapX.computeIfAbsent(allX[i], k -> new ArrayList<Integer>()).add(i);
	// 		mapY.computeIfAbsent(allY[i], k -> new ArrayList<Integer>()).add(i);
	// 		city_idx.put(cities[i], i);			
	// 	}

	// 	for(int i = 0; i < numOfQueries; ++i) {

	// 		int idx = city_idx.get(queries[i]);

	// 		if(nearest[idx] != null) { 

	// 			result[i] = nearest[idx]; 
	// 			continue;
	// 		}

	// 		int x = allX[idx];
	// 		int y = allY[idx];

	// 		if(mapX.get(x).size() > 1 || mapY.get(y).size() > 1) {

	// 			int nearestDistance = Integer.MAX_VALUE;
	// 			int nearestIdx = -1;

	// 			if(mapX.get(x).size() > 1) {

	// 				List<Integer> sameCities = mapX.get(x);

	// 				for(int cityIdx : sameCities) {

	// 					if(cityIdx == idx) { continue; }

	// 					int currDist = findDistance(x, y, allX[cityIdx], allY[cityIdx]);

	// 					if(currDist < nearestDistance) {

	// 						nearestDistance = currDist;
	// 						nearestIdx = cityIdx;
	// 					}
	// 					else if(currDist == nearestDistance) {

	// 						if(cities[cityIdx].compareTo(cities[idx]) < 0) { nearestIdx = cityIdx; }
	// 					}
	// 				}
	// 			}

	// 			if(mapY.get(y).size() > 1) {

	// 				List<Integer> sameCities = mapY.get(y);

	// 				for(int cityIdx : sameCities) {

	// 					if(cityIdx == idx) { continue; }

	// 					int currDist = findDistance(x, y, allX[cityIdx], allY[cityIdx]);

	// 					if(currDist < nearestDistance) {

	// 						nearestDistance = currDist;
	// 						nearestIdx = cityIdx;
	// 					}
	// 					else if(currDist == nearestDistance) {

	// 						if(cities[cityIdx].compareTo(cities[idx]) < 0) { nearestIdx = cityIdx; }
	// 					}
	// 				}
	// 			}

	// 			result[i] = cities[nearestIdx];
	// 			nearest[idx] = result[i];
	// 		}
	// 		else { 

	// 			result[i] = "None";
	// 			nearest[idx] = "None";
	// 		} 
	// 	}

	// 	return result;
	// }
}