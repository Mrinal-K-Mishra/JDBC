package Jdbc.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Jdbc.assignment.Helper;

public class BankMenuDriven {
	Scanner sc = new Scanner(System.in);
	int AccountNumber;
	String FullName, AccountType;
	Double Balance=0.0;
	
	//create a method for insert data
	public void createAccount() throws SQLException{
		//creating scanner object
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		
		System.out.println("Enter Account Number :");
		AccountNumber = sc1.nextInt();
		
		System.out.println("Enter Full Name :");
		FullName = sc2.nextLine();
		
		System.out.println("Enter Account type:");
		AccountType = sc3.nextLine();
		
		System.out.println("Enter Amount :");
		Balance = sc4.nextDouble();
		
		Connection conn = Helper.con();
		PreparedStatement pst = conn.prepareStatement("insert into banking values(?,?,?,?)");
		
		pst.setInt(1, AccountNumber);
		pst.setString(2, FullName);
		pst.setString(3, AccountType);
		pst.setDouble(4, Balance);
		pst.executeUpdate();
		
		System.out.println("Congratulations! Account created successfully...");
	}
		
		
	public void accountDetails() throws SQLException {	
		Connection conn = Helper.con();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from Banking");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4));
			System.out.println("------------------------------");
		}
	}
	// create a method to delete account
	public void closeAccount() throws SQLException { 
		Connection conn = Helper.con();
		Statement st = conn.createStatement();
		System.out.println("Enter Account number to close : ");
		AccountNumber = sc.nextInt();
		st.executeUpdate("Delete from Banking where AccountNumber ="+AccountNumber);
		System.out.println("Account closed...");
	}
	//create a method to deposit
    public void depositAmount() throws SQLException {  
    	Connection conn = Helper.con();
    	Statement st = conn.createStatement();
    	
    	System.out.println("Enter your account number");
    	 int AccountNumber = sc.nextInt();
   
        System.out.println("Enter amount for deposit");
        double amount = sc.nextDouble();
        
        	// execute the sql query to select column
     			ResultSet rs = st.executeQuery("select * from banking where AccountNumber ="+AccountNumber);
     			while(rs.next()) {
     				
     				Balance = rs.getDouble(4);
     				System.out.println("Previous balance : "+Balance);
     				
     				Balance = Balance+amount;
     				st.executeUpdate("update banking set balance="+Balance+" where AccountNumber="+AccountNumber);
     				System.out.println("Money deposited succesfully, Available balance : "+Balance);
     			}
     			
     			// close the objects
     			rs.close();
     			conn.close();
    }
		
    // create a method to withdrawal money from the account
    public void withdrawnAmount() throws SQLException {  
    	Connection conn = Helper.con();
    	Statement st = conn.createStatement();
    	
    	System.out.println("Enter your account number");
   	 	int AccountNumber = sc.nextInt();
    	
        System.out.println("Enter amount for withdraw ");
        Scanner sc = new Scanner(System.in);
        
        double amount = sc.nextDouble();
        
        ResultSet rs = st.executeQuery("select * from banking where AccountNumber ="+AccountNumber);
			while(rs.next()) {
				Balance = rs.getDouble(4);
			
				if(Balance>= amount) {
					System.out.println("previous balance " +Balance);
					Balance = Balance-amount;
					System.out.println("Withdrawl Completed, Available balance is " +Balance);
				}else {
					System.out.println("Insufficient Balance..."); //If your withdraw amount is more than your available balance
		}
		// close the objects
		rs.close();
		conn.close();
			}
    }
    // To view the balance
    public void viewBalance() throws SQLException {
    	Connection conn = Helper.con();
    	Statement st = conn.createStatement();
    	
    	System.out.println("Enter your account number");
   	 	int AccountNumber = sc.nextInt();
   	 	
   	 
   	 ResultSet rs = st.executeQuery("select * from banking where AccountNumber ="+AccountNumber);
		while(rs.next()) {
			
			AccountNumber = rs.getInt(1);
			Balance = rs.getDouble(4);
		System.out.println("Your Available balance is " +Balance);
	
    }
	// close the objects
	rs.close();
	conn.close();
    }
}