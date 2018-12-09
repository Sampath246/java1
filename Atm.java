import java.util.Scanner;

public class Atm {
	//Storing the user Balance
    int  userBalance;
    
    //Storing the user Pin
    int userPIN;
    
    //storing the amount available in ATM 
    static int atmBalance=10000;
    
    //Initialize data of  users .......
    public Atm()
    {
   	 userPIN=16103069;
   	 userBalance=5000;
   	 
    }
    //When User choose withdraw option
    public void withdraw(int withdraw)
    {
   		try
			{   
   			//When Amount is either less than 100 or exceed 10000
   			if(withdraw<=100 || withdraw>=10000) throw new InvalidAmount("Invalid Amount");
   			
   			//when Amount is not a multiple of 100, 500 or 2000
				if(withdraw%100!=0) throw new NoteException("Amount is not a multiple of 100, 500 or 2000");
				
				//When Atm has Shortage of cash
				if(atmBalance-withdraw<0)  throw new AtmBalanceShort("ATM hasn`t have Entered amount");
				
				//When User Balance is insufficient
				if(this.userBalance-withdraw<0) throw new BalanceShort("User  Balance is less than the Entered Balance");
				
				//Set the User balance when Amount is Withdraw
				this.userBalance-=withdraw;
				
				//Set the Atm Balance when amount is deposited
				atmBalance-=withdraw;
			}
   		
           //Catch Exceptions
			catch(NoteException e)
			{
				System.out.println(e.getMessage());
				
			}
			catch(BalanceShort e)
			{
				System.out.println(e.getMessage());
				
			}
			catch(AtmBalanceShort e)
			{
				System.out.println(e.getMessage());
				
			}
			catch(InvalidAmount e)
			{
				System.out.println(e.getMessage());
				
			}
   	 
    }
    
    //When User press Deposit option
    public void deposit(int deposit)
    {
   	 try
			{   //When deposited amount is not a multiple of 100,500 or 2000
				if(deposit%100!=0) throw new NoteException("Amount is not a multiple of 100, 500 or 2000");
				
			//set user balance when amount is Deposited
				userBalance+=deposit;
				//set the Atm amount when the amount is deposited
				System.out.println(userBalance);
				atmBalance+=deposit;
			}
   	 
   	 //Catch Exception
			catch(NoteException e)
			{
				System.out.println(e.getMessage());
				
			}
    }
    
    
    //main method
public static void main(String[] args) {
	
	//Atm object
	Atm obj=new Atm();
	
	//input that get input from console
	Scanner input=new Scanner(System.in);
	
	//it stores the temporary pin number of coming user 
	int pin;
	
	//Loop for getting the Pin Number
	while(true)
	{
		try
	{
			System.out.println("Enter Pin:");
			pin=input.nextInt();
			
			//throws the exception when the entered pin is wrong
			if(pin!=obj.userPIN) throw new InvalidPin("Invalid Pin try again::");
			              break;
			}
		
		//Catch Exception
			catch( InvalidPin e)
			{
				System.out.println(e.getMessage());
			}
	}
	
	//that handles the loop for option menu
	boolean loop=true;
	
	//it stores the choice of user
	int choice=0;
	
	while(loop)
	{  
		//Print the valid Option to the screen
		System.out.println("Enter your Choice:\n1.Withdraw"
				+"\n2.Deposit\n3.Check Balanace\n4.Print Transaction"
				+ "\n5.Exit");
		choice=input.nextInt();
		
		//Handle the cases via switch statement
		switch(choice)
		{
		
		case 1:
		{
			int withdraw;
			System.out.println("Enter Withdraw Amount :");
			//getting the amount that to be withdraw
			withdraw=input.nextInt();
			
			//calling the Withdraw method
		    obj.withdraw(withdraw);
			break;
			
		}
		case 2:
		{
			int deposit;
			System.out.println("Enter deposit Amount :");
			
			//Getting the amount that to be deposited
			deposit=input.nextInt();
			
			//calling the Deposit method 
			obj.deposit(deposit);
			break;
			
		}
		case 3:
		{
			//Print the Remaining balance of the user
			System.out.println("Balance:"+obj.userBalance);
			break;
		}
		case 4:
		{
			//Print the Transaction history slip 
			System.out.println("Collect Transactin History");
			break;
		}
		case 5:
		{
			
			//Exiting from the ATM
			System.out.println("Exiting...........");
			loop=false;
			break;
		}
		default :
		{  //For Invalid Option
			
			try {
				
				//throw the Invalid option Exception
			throw new InvalidOption("Invalid Option..Choose right one");}
			catch(InvalidOption e)
			{
				System.out.println(e.getMessage());
				break;
			}
			
		}
		
		}
		
	}
	input.close();

}

}
