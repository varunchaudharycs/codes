// Aim- GIVE ALPHABETICALLY SORTED TRANSACTIONS THAT CAN CONVERT PORTFOLIO TO BENCHMARK

import java.io.*;
import java.util.*;

class PortfolioBenchmark {

	// public class Asset {

	// 	HashMap<String, Long> asset;

	// 	public Asset() {

	// 		this.asset = new HashMap<String, Long>();
	// 	}

	// 	public void buy(String company, int shares) {

	// 		asset.put(company, asset.getOrDefault(company, 0) + shares);
	// 	}

	// 	public void sell(String company, int shares) {

	// 		if(asset.containsKey(company) && asset.get(company) >= shares) {

	// 			asset.put(company, asset.get(company) - shares);
	// 		}
	// 		else {

	// 			System.out.println("INVALID TRANSACTION");
	// 		}
	// 	}
	// }

	// public class Bond extends Asset {

	// 	final String type = "BOND";		

	// 	public Bond(String input) {

	// 		String[] transactions = input.split("\\|");

	// 		for(String transaction : transactions) {

	// 			String[] fields = transaction.split(",");
	// 			String company = fields[0];
	// 			String type = fields[1];
	// 			long shares = Long.parseLong(fields[2]);

	// 			super.buy(company, shares);
	// 		}
	// 	}
	// } 

	public static void main(String[] args)throws IOException {

		String inp = "Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10";

		String[] fields = inp.split(":");

		String portfolio = fields[0];
		String benchmark = fields[1];

		HashMap<String, Long> bond = new HashMap<String, Long>();
		HashMap<String, Long> stock = new HashMap<String, Long>();

		String[] portfolioTransactions = portfolio.split("\\|");

		for(String transaction : portfolioTransactions) {

			String[] parts = transaction.split(",");
			String company = parts[0];
			String type = parts[1];
			long shares = Long.parseLong(parts[2]);

			if(type.equals("BOND")) bond.put(company, bond.getOrDefault(company, 0l) + shares);
			else stock.put(company, bond.getOrDefault(company, 0l) + shares);
		}

		List<List<String>> changes = new ArrayList<>();

		String[] benchmarkTransactions = benchmark.split("\\|");

		for(String transaction : benchmarkTransactions) {

			String[] parts = transaction.split(",");
			String company = parts[0];
			String type = parts[1];
			long shares = Long.parseLong(parts[2]);

			List<String> tmp = new ArrayList<>();

			if(type.equals("BOND")) {

				if(bond.containsKey(company)) {

					if(bond.get(company) > shares) {

						tmp.add("SELL");
						tmp.add(company);
						tmp.add(type);
						tmp.add(String.valueOf(bond.get(company) - shares));
					}
					else if(bond.get(company) < shares) {

						tmp.add("BUY");
						tmp.add(company);
						tmp.add(type);
						tmp.add(String.valueOf(shares - bond.get(company)));
					}
				}
				else {

					tmp.add("BUY");
						tmp.add(company);
						tmp.add(type);
						tmp.add(String.valueOf(shares));
				}
			}
			else {

				if(stock.containsKey(company)) {

					if(stock.get(company) > shares) {

						tmp.add("SELL");
						tmp.add(company);
						tmp.add(type);
						tmp.add(String.valueOf(stock.get(company) - shares));
					}
					else if(stock.get(company) < shares) {

							tmp.add("BUY");
						tmp.add(company);
						tmp.add(type);
						tmp.add(String.valueOf(shares - stock.get(company)));
					}
				}
				else {

					tmp.add("BUY");
						tmp.add(company);
						tmp.add(type);
						tmp.add(String.valueOf(shares));
				}
			}

			if(!tmp.isEmpty()) changes.add(tmp);
		}

		System.out.println(changes);

		Collections.sort(changes, new Comparator<>() {

			public int compare(List<String> a, List<String> b) {

				if(a.get(1).compareTo(b.get(1)) == 0) {

					return a.get(2).compareTo(b.get(2));
				}
				else {

					return a.get(1).compareTo(b.get(1));
				}
			}
		});


		for(List<String> change : changes) {

			StringBuilder sb = new StringBuilder();

			for(String s : change)
			sb.append(s).append(",");

			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		}
	}
}