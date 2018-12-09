package stock;

import java.util.*;

public class MenuDriven {
	public static void sort(StockHolding a[],int n)
    {
   	 int i,j;
   	 for(i=0;i<n;i++)
   	 {
   		 for(j=i+1;j<n-1;j++)
   		 {
   			 if(a[j].companyName.compareTo(a[j+1].companyName)>0)
   			 {
   				 StockHolding p=a[j];
   				 a[j]=a[j+1];
   				 a[j+1]=p;
   			 }
   		 }
   	 }
    }
	public static void sortbv(StockHolding a[],int n)
    {
   	 int i,j;
   	 for(i=0;i<n;i++)
   	 {
   		 for(j=i+1;j<n-1;j++)
   		 {
   			 if(a[j].valueinDollars()-a[j+1].valueinDollars()>0)
   			 {
   				 StockHolding p=a[j];
   				 a[j]=a[j+1];
   				 a[j+1]=p;
   			 }
   		 }
   	 }
    }
	public static void main(String[] args) {
		StockHolding a[]=new StockHolding[8];
		int i;
		Scanner s=new Scanner(System.in);
		for(i=0;i<3;i++)
		  a[i]=new StockHolding();
		System.out.println("enter the no. of the users(max 8 ):");
		int n =s.nextInt();
		System.out.println("enter the type of the users(foreign(0) or local(1)):");
		int d=s.nextInt();
		switch(d)
		{
		case 0:for(i=0;i<n;i++)
          		{
			   a[i]=new ForeignStockHolding();
			   System.out.println("enter the data for "+i+"th user :");
			   a[i].getValues();
	         	}
		         break;
		case 1:for(i=0;i<n;i++)
  		        {
	            a[i]=new StockHolding();
	            System.out.println("enter the data for "+i+"th user :");
				   a[i].getValues();
		         	   }
                 break;
		}
		float w;
		while(d!=7)
		{
			System.out.println("1.Display stock imformation with lowest value");
			System.out.println("2.Display stock imformation with highest value");
			System.out.println("3.Display the most profitable stock ");
			System.out.println("4.Display the least profitable stock ");
			System.out.println("5.list all stocks sorted by company names");
			System.out.println("6.list all stocks from the lowest value to the highest value");
			System.out.println("7. exit");
			d=s.nextInt();
			switch(d)
			{
			case 1: w=a[0].valueinDollars();
			       for(i=1;i<n;i++)
			       {
			    	   if(w>a[i].valueinDollars())
			    		  w=a[i].valueinDollars();
			       }
			       System.out.println(w);
			       break;
			case 2:  w=a[0].valueinDollars();
		            for(i=1;i<n;i++)
		           {
		    	   if(w<a[i].valueinDollars())
		    		  w=a[i].valueinDollars();
		            }
		            System.out.println(w);
		            break;
			case 3:   w=a[0].valueinDollars()-a[0].costinDollars();
		            for(i=1;i<n;i++)
		          {
		    	   if(w<a[i].valueinDollars()-a[i].costinDollars())
		    		  w=a[i].valueinDollars()-a[i].costinDollars();
		           }
		            System.out.println(w);
		           break;
			case 4:  w=a[0].valueinDollars()-a[0].costinDollars();
		           for(i=1;i<n;i++)
		           {
		    	     if(w>a[i].valueinDollars()-a[i].costinDollars())
		    		  w=a[i].valueinDollars()-a[i].costinDollars();
		           }
		           System.out.println(w);
		           break;
			case 5:sort(a,n);
			       for(i=0;i<n;i++)
				    a[i].show();
		           break;
			case 6:sortbv(a,n);
	        		for(i=0;i<n;i++)
			       a[i].show();
	               break;
			case 7: d=7;
			}
		}
		
	}



	
}
