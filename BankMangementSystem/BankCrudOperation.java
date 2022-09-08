package Jdbc.Bank;

import java.sql.SQLException;
import java.util.Scanner;

public class BankCrudOperation {

	public static void main(String... args) throws SQLException {
		BankMenuDriven bm = new BankMenuDriven();	//creating object of the class
		Scanner s = new Scanner(System.in);	//creating scanner object
		int ch;
		do {

			System.out.println("1. Create Account");
	        System.out.println("2. Display");
	        System.out.println("3. Close");
	        System.out.println("4. Deposit Amount.");
	        System.out.println("5. Withdraw Amount.");
	        System.out.println("6. View Balance");
	        System.out.println("7. Exit");
			System.out.println("Enter your choice from 1-7");
			
			ch = Integer.parseInt(s.nextLine());
			System.out.println("------------------------------");
			
			switch(ch){
			
			case 1:
				bm.createAccount();
				break;
				
			case 2:
				bm.accountDetails();
				break;
			
			case 3:
				bm.closeAccount();
				break;
			
			case 4:
				bm.depositAmount();
				break;
				
			case 5:
				bm.withdrawnAmount();
				break;
				
			case 6:
				bm.viewBalance();
				break;
				
			case 7:
				System.exit(0);
				break;
			}
		}
		while (ch!=7);
				
		}
	}