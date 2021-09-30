package com.example.demo.account;



import java.util.Date;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	private String ownerName;
	
	private String address;
	private float amount;
	private AccountType accountType;
	private Status status;
	private String creationDate;
	
	/*
	 *  {
	 *  	"ownername":"asdfasd",
	 *  
	 *  }
	 */
	// Constructor
	public Account(String ownerName, String address, float amount, AccountType accountType, Status status) {
		super();
		this.ownerName = ownerName;
		this.address = address;
		this.amount = amount;
		this.accountType = accountType;
		this.status = status;
		
		Date date = new Date();
		this.creationDate = date.toString();
	}
	
	
	public Account() {

		Date date = new Date();
		this.creationDate = date.toString();
	}


	/*
	 * Getters and Setters
	 */
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
//		System.out.println("You can not change your balance without depositing");
		this.amount = amount;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	// Deposit method
	public void deposit(float amount) {
		this.amount += amount;
		System.out.println("Amount deposited - Rs. " + amount);
	}
	
	// Withdraw method
	public void withdraw(float amount) {
		
		if(amount > this.amount) {
			System.out.println("Transaction cannot be completed due to insufficient funds");
			return;
		}
		this.amount -= amount;
		System.out.println("Amount Debit - Rs. " + amount);
		System.out.println("Current balance - " + this.amount);
	}
	
	// account creating method
	public void createAccount() {
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		this.ownerName = scanner.next();
		scanner.nextLine();
		
		
		System.out.println("Enter Address details . . . ");
		System.out.print("City : ");
		String city = scanner.next();
		scanner.nextLine();
		
		System.out.print("State : ");
		String state = scanner.next();
		scanner.nextLine();
		
		
		System.out.print("Pin Code : ");
		int pin = scanner.nextInt();
		scanner.nextLine();
		
		address = city + ", " + state + ", " + pin;
//		address = new Address(city, state, pin);
		

		
		
		System.out.println("Enter type,s for Savings | c for Current");
		char s = (char) scanner.next().charAt(0);
		if(s == 's')
			this.accountType = AccountType.SAVINGS;
		else if(s == 'c')
			this.accountType = AccountType.CURRENT;
		else {
			System.out.println("Invalid Input");
		}
		
		
		this.amount = 0;
		this.status = Status.ACTIVE;
		Date date = new Date();
		this.creationDate = date.toString();
		
	}
	
	
	public void showAccountDetails() {
		
		System.out.println("\n\n*******************************************************\n\n");
		
		System.out.println("Account type - " + getAccountType());
		
		System.out.println("Account Owner's name - " + ownerName);
		System.out.println("Address - ");
//		System.out.print("City : " + address.getCity());
//		System.out.print(", State - " + address.getState());
//		System.out.print(", Pin Code - " + address.getPin());
		
		System.out.println("Current Balance - " + amount);
		
		System.out.println("Account created on - " + creationDate);
		
		System.out.println("Account Status - " + getStatus());
		
		System.out.println("\n\n*******************************************************\n\n");
		
	}
}
