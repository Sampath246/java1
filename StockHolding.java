package stock;
import java.util.Scanner;
public class StockHolding {
	public  float purchaseSharePrice; 
	 public  float currentSharePrice;
	 public int numberOfShares;
	 public String companyName;
	 public void getValues()
	 {
		 Scanner s1=new Scanner(System.in);
		 companyName=s1.nextLine();
		 numberOfShares=s1.nextInt();
		 purchaseSharePrice =s1.nextFloat();
		 currentSharePrice=s1.nextFloat();
	 }
	 public void show()
	 {
		 System.out.println("Company Name Is "+companyName);
		 System.out.println("Number of Shares are "+numberOfShares);
		 System.out.println("purchaseSharePrice Is "+purchaseSharePrice);
		 System.out.println("currentSharePrice Is "+currentSharePrice);
		 
		 
		 
		 
	 }
	public float costinDollars()
	{
		return purchaseSharePrice*numberOfShares;
	}
	public float valueinDollars()
	{
		return currentSharePrice*numberOfShares;
	}
}
