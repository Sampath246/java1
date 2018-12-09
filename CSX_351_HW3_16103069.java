package sampath2;
import java.io.*;
public class CSX_351_HW3_16103069 {
		public static void main(String[] args)throws Exception {
			File file=new File("H:\\java\\hw3\\HW3-unsorted-keywords.txt");
			File file1=new File("H:\\java\\hw3\\output-HW3.txt");
			FileWriter fw = new FileWriter(file1);
			File file2=new File("H:\\java\\hw3\\HW3-input-code.cpp");
			BufferedReader br= new BufferedReader(new FileReader(file));
			BufferedReader b = new BufferedReader(new FileReader(file2));
			BufferedReader b1 = new BufferedReader(new FileReader(file1));
			String str;
			int n=0;
			while((str=br.readLine())!= null)  //finding no of keywords
				{if(str.length()>0)
					n++;}
		
			
			String a[]=new String[n];
		 br= new BufferedReader(new FileReader(file));
			int i=0,j=0;
			while((str=br.readLine())!=null) //storing keyword from file in to array
			{
				if(str.length()>0)
				{a[i]=str;
				System.out.println(a[i]);
				i++;}
			}
			
			for(i=0;i<n;i++)       //sorting the keyword array
			{
				int xchanges=0;
				for(j=0;j<n-i-1;j++)
				{
					if((a[j].compareTo(a[j+1]))>0)
					{
						String temp;
						temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
						xchanges++;
					}	
				}
				if(xchanges==0)
					break;
			}
			String g;
			i=0;
			
			int count=0;
			while((g=b.readLine())!=null)  //reading line from cpp file and separating the words 
			{
			i++;
			int flag=0;
	       
			String x="line "+i+": ";
			for(int k=0;k<g.length();k++)
			samp:{int r=k;
				  char w=g.charAt(k);
				  if(w>=97 && w<=122||w>=48 && w<=57||w =='_')
				   {
				    String q="";
				    while(w>=97 && w<=122||w>=48 && w<=57||w=='_')
				    {
				   	 q=q+w;
				     k++;
				     if(k<g.length())
				     w=g.charAt(k);
				 	  else
				 	  w='&';
				 }k=k-1;
				 int low,hig,mid;
				 low=0;
				 hig=n-1;
				 while(low<=hig) //  binary search for finding the no of key words present in the cpp file
				 {
					 mid=(low+hig)/2;
					 if(q.compareTo(a[mid])==0)
					 {
						flag=1;
						count++;
						x=x+q+"("+r+") ";
					    break;
					 }
					 else if(q.compareTo(a[mid])>0)
				      low=mid+1;
					 else
					hig=mid-1;
				 }
				 }
				  else
				  {
					  if(w=='/')
					  {
						  k++;
						  w=g.charAt(k);
						  if(w=='/')
						  {
							  break samp;
						  }
						  else
							  k=k-1;
					  }
				  }
				}
			if(flag==1) // for writing in the output file
			{
				x=x+"\n";
				fw.write(x);
				System.out.println(x);
				
			}
			}
			String f="number of keywords found : " + count + "\n";
			System.out.print(f);
			fw.write(f);
			br.close();
			b.close();
			fw.close();
			b1.close();
		}
}


