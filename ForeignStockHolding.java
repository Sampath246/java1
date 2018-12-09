package stock;

import java.util.Scanner;

public class ForeignStockHolding extends StockHolding {
	public float conversionRate;
	public void show()
	{
		super.show();
		System.out.println("Conversion Rate is "+conversionRate);
	}
	 public void getValues()
	 {
		 super.getValues();
		 Scanner s1=new Scanner(System.in);
		 conversionRate=s1.nextFloat();
	 }
	 public float costinDollars()
	 {
	 	return conversionRate*purchaseSharePrice*numberOfShares;
	 }
	 public float valueinDollars()
	 {
	 	return conversionRate*currentSharePrice*numberOfShares;
	 }

}