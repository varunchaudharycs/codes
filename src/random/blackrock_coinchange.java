import java.io.*;
import java.util.*;
import java.math.BigDecimal;

class blackrock_coinchange {

	public static void main(String[] args)throws IOException {

		readInput("50;50.4");
	}

	public static void readInput(String line) {

		String[] fields = line.split(";");
		double price = Double.parseDouble(fields[0]);
		double cash = Double.parseDouble(fields[1]);

		calculateChange(cash, price);
	}

	public enum Denomination {

		FIFTY_POUNDS(50.00d),
        TWENTY_POUNDS(20.00d),
        TEN_POUNDS(10.00d),
        FIVE_POUNDS(5.00d),
        TWO_POUNDS(2.00d),
        ONE_POUND(1.00d),
    	FIFTY_PENCE(0.50d),
        TWENTY_PENCE(0.20d),
        TEN_PENCE(0.10d),
        FIVE_PENCE(0.05d),
        TWO_PENCE(0.02d),
        ONE_PENCE(0.01d);

        private final Double value;
        private final String currency;

        Denomination(Double value) {

	        this.value = value;
	        this.currency = this.name().replace("_", " ");
   		}

	    public BigDecimal getValue() {
	        return BigDecimal.valueOf(this.value);
	    }

	    @Override
	    public String toString() {
	        return this.currency;
	    }
	} 

	public static void calculateChange(double cash, double purchasePrice) {

		if(cash < purchasePrice) { System.out.println("ERROR"); }
		else if(cash == purchasePrice) { System.out.println("Zero"); }
		else {

			BigDecimal cashD = BigDecimal.valueOf(cash);
			BigDecimal purchasePriceD = BigDecimal.valueOf(purchasePrice);
			BigDecimal cashback = cashD.subtract(purchasePriceD);
			StringBuilder change = new StringBuilder();

			for(Denomination d : Denomination.values()) {

				int count = 0;

				while(cashback.compareTo(d.getValue()) >= 0) {

					count++;
					cashback = cashback.subtract(d.getValue());
				}

				if(count == 2) { change.append("TWO ").append(d.toString()).append(", "); }
				else if(count == 1) { change.append(d.toString()).append(", "); }
			}

			change.setLength(change.length() - 2);
			System.out.println(change);
		}
	}
}