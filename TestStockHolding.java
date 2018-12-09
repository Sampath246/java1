package stock;

import java.util.Scanner;

public class TestStockHolding {
	public static void sort(StockHolding a[],int start,int finish)
	{
	 int xchg,i,j;
	 for(i=start;i<finish;i++)
	 {   xchg=0;
		 for(j=start;j<finish-1-i;j++)
		 {
			 if(a[j].companyName.compareTo(a[j+1].companyName)>0)
			 {
				 StockHolding temp=new StockHolding();
				 temp=a[j];
				 a[j]=a[j+1];
				 a[j+1]=temp;
				 xchg++;
			 }
			 
		 }
		 if(xchg==0)
			 break;
	 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enetr no. of StockHolding Instances");
		int sh,i;
		Scanner sc=new Scanner(System.in);
		sh=sc.nextInt();
		System.out.println("Enter no. of Foreogn stocks");
		int fsh=sc.nextInt();
		StockHolding a[]=new StockHolding[sh+fsh];
		for(i=0;i<sh;i++)
		{
			a[i]=new StockHolding();
			a[i].getValues();
		}
		
		System.out.println("Stocks after sorting" );
		sort(a,0,sh);
		for(i=0;i<sh;i++)
			a[i].show();
		
		
		for(i=sh;i<(sh+fsh);i++)
		{
			a[i]=new ForeignStockHolding();
			a[i].getValues();
		}
		sort(a,sh,fsh+sh);
		System.out.println("Foreign Stocks after sorting" );
		for(i=(sh+fsh-1);i>=sh;i--)
			a[i].show();
			
		
		
			
		}

	}



