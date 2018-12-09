import java.util.Scanner;

public class Lottery {
	//lottery number
		int lotteryNumber[] = new int[5];
		
		//constructor to generate a random lottery number
		public Lottery()
		{
			
			//generating random lottery number
			for(int i=0; i<5; i++)
			{
				lotteryNumber[i] = (int) (Math.random() * 10);
			}
		}
		
		//function to compare user lottery no with lotteryNumber
		int LotteryPick (int userLotteryNo[])
		{
			//variabe to store no of digits matches
			int digitsMatch = 0;
			
			//checking the digit of userLotteryNo to lotteryNumber
			for(int i=0; i<5; i++)
			{
				if(lotteryNumber[i]==userLotteryNo[i])
				{
					digitsMatch++;
				}
			}
			//return the no of digits matches
			return digitsMatch;
		}
		
		//function to find lottery number
		int[] findLotteryNumber ()
		{
			return lotteryNumber;
		}
		
		public static void main(String []arg)
		{
			//variable for taking input
			Scanner input = new Scanner(System.in);
			
			//taking the user lottery no as input
			System.out.print("Enter your lottery ticket no digit by digit : ");
			int userLotteryNo[] = new int[5];
			for(int i=0; i<5; i++)
			{
				userLotteryNo[i] = input.nextInt();
			}
			
			//creating a lottery object!
			Lottery object = new Lottery();
			
			int lotteryNo[];
			lotteryNo = object.findLotteryNumber();
			
			//printing the winner lottery number
			System.out.print("The winner lottery number is : ");
			for(int i=0; i<5; i++)
			{
				System.out.print(lotteryNo[i]+" ");
			}
			System.out.println();
			
			//checking the user lottery no with winner lottery no
			int noOfDigitsMatched = object.LotteryPick(userLotteryNo);
			System.out.println("Number of Digits Matched are : "+noOfDigitsMatched);
			
			//if the user is winner of lottery
			if(noOfDigitsMatched == 5)
			{
				System.out.println("CONGRATULATIONS YOU ARE THE WINNER OF GRAND PRIZE WORTH 20LACS");
			}
			
			input.close();
		}
}
