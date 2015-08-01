package com.theater;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class TheaterSet {

	void moviePrint(){

		// use the local methods and override

	}
	boolean checkMovieRating(String movieName){
		// use the local methods and override
		return false;
	}

	double getPrice(){
		// use the local methods and override
		return 0;
	}

	String checkAge(){
		System.out.println("Enter your Age");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			try {
				String age = br.readLine();
				Integer ageInt = Integer.parseInt(age);
				
				if(ageInt >= 13)
					return "PG-13";

				else if(ageInt >= 17)
					return "NC-17";
				
				else if(ageInt < 13)
					return "PG";
				else
					return "Invalid";
				
			} catch (Exception e) {
				System.out.println("Please Enter Age correctly");
				continue;
			}

		}
	}
	void calculateTotal(Double totalPrice){

		System.out.println("Please enter the amount to insert");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try {
				String amountInserted = br.readLine();
				Double balance = Double.parseDouble(amountInserted) - totalPrice; 
				if(balance == 0){	// Exact amount paid
					System.out.println("Please collect your change: "+ balance);
					System.out.println("Thank you for choosing TheaterDemo, Enjoy your movie");
					return;
				}
				else if(balance > 0){	// Extra paid
					System.out.println("Please collect your change: "+ balance);
					System.out.println("Thank you for choosing TheaterDemo, Enjoy your movie");
					System.out.println("");
					return;
				}
				else				// Paid Less
				{
					System.out.println("Plese pay the balance of "+ Math.abs(balance));
					calculateTotal(Math.abs(balance));
				}
			} catch (Exception e) {
				System.out.println("Please enter correct values");
				continue;
			}
		}	
	}
}
