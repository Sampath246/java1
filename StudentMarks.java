
import java.util.*;
public class StudentMarks {
	//storing names of the student
    String name[]=new String[5];
    //storing grades of the student
	char grade[]=new char[5];
	//used store the test marks
	double testscore[][]=new double[5][4];
	//used for storing the avg marks
	double avg[]=new double[5];
	
	//to take the details of the student i
	 public  void setdetails(int i)
	 {
		  Scanner s1=new Scanner(System.in);
			 System.out.println("Enter name for "+i+"th Student");
			 name[i]=s1.nextLine();
			 System.out.println("Enter Scores for 4 Subjects of "+i+"th Student");
			 for(int j=0;j<4;j++)
			 {
				 testscore[i][j]=s1.nextDouble();
				 try
				 {
					 if(testscore[i][j]<0||testscore[i][j]>100)
						 throw new NumberFormatException();
				 }
				 catch(NumberFormatException e) {
					 System.out.println("please Enter a valid Score");
					 
				 }
			 }
			 	 		 
		 }
	
	 
	public String getname(int i)
	{
		return name[i];
	}
	
	public void showavg(int i)
	{
		
			double total=0;
			for(int j=0;j<4;j++)
			{
				total+=testscore[i][j];
			}
			avg[i]=total/4;
		System.out.println(" Avg scores of "+name[i]+" is "+avg[i]);
	}
	public void showgrade(int i)
	{
		if(avg[i]>=90&&avg[i]<=100 )
		{   grade[i]='A';
			System.out.println(" Grade of "+name[i]+" is "+grade[i]);
		}
		if(avg[i]>=80&&avg[i]<=89 )
		{   grade[i]='B';
			System.out.println(" Grade of "+name[i]+" is "+grade[i]);
		}
		if(avg[i]>=70&&avg[i]<=79 )
		{   grade[i]='C';
			System.out.println(" Grade of "+name[i]+" is "+grade[i]);
		}
		if(avg[i]>=60&&avg[i]<=69 )
		{   grade[i]='D';
			System.out.println(" Grade of "+name[i]+" is "+grade[i]);
		}
		if(avg[i]>=0&&avg[i]<=59 )
		{   grade[i]='F';
			System.out.println(" Grade of "+name[i]+" is "+grade[i]);
					}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		StudentMarks arr[]=new StudentMarks[5];
	 int i;
	 for(i=0;i<5;i++)
	 {
		 arr[i]=new StudentMarks();
	 }
	 
	 System.out.println("Enter Student name and Test Scores ");
	for(i=0;i<5;i++)
	{
		 arr[i].setdetails(i);
	}
	 for(i=0;i<5;i++)
	 {
	     System.out.println("Name of Student is "+arr[i].getname(i)) ;
	     arr[i].showavg(i);
	     arr[i].showgrade(i);
	     
	      }
		
	
}
		}