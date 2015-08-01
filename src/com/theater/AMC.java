package com.theater;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class AMC extends TheaterSet{

	private HashMap<String, String> amcMovieMap= new HashMap<String, String>();
	private HashMap<String, String> amcMovieListMap = new HashMap<String, String>();

	public AMC(){

		amcMovieMap.put("1", "Jurassic World - PG-13");
		amcMovieMap.put("2", "San Andreas - PG-13");
		amcMovieMap.put("3", "Mad Max - Rated R");
		amcMovieMap.put("4", "Avengers: Age of Ultron - PG");

		amcMovieListMap.put("Jurassic World - PG-13", "PG-13");
		amcMovieListMap.put("San Andreas - PG-13", "PG-13");
		amcMovieListMap.put("Mad Max - Rated R", "PG-13");
		amcMovieListMap.put("Avengers: Age of Ultron - PG", "PG");
	}

	public void moviePrint() {

		for (String key : amcMovieMap.keySet()) {

			System.out.println(key+". " +amcMovieMap.get(key));
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Double totalPrice = 0.00;
		System.out.println("Choose the movie you want to watch");
		while(true)
		{
			try {
				String movieChoice = br.readLine();
				if(amcMovieMap.containsKey(movieChoice))
				{
					if(checkMovieRating(amcMovieMap.get(movieChoice)))
						totalPrice = getPrice();
					else{
						System.out.println("You cannot buy this ticket. Get your Parent");
						return;
					}
				}
				else{
					System.out.println("Please enter the correct Movies option as above");
					continue;
				}

				System.out.println("Your Total is: " + totalPrice);
				calculateTotal(totalPrice);
				return;
			} catch (Exception e) {
				System.out.println("Invalid: Please enter the correct Movies option as above");
				continue;

			}
		}
	}

	boolean checkMovieRating(String movieName) {
		
		String movieRating = checkAge();
		if(amcMovieListMap.get(movieName).equals("PG"))
			return true;
		if(!movieRating.equals("Invalid")){
			if(movieRating.equals(amcMovieListMap.get(movieName)))
				return true;
			else
				return false;
		}
		else
			return false;
	}

	double getPrice() {

		double currentTotal = 0.0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){	
			try {
				System.out.println("Enter the number of tickets you want to buy:");
				Integer numberOfTickets = Integer.parseInt(br.readLine());

				System.out.println("1. Kid - $2.50 2. Adult - $6.50 3. Senior - $5.00");
				System.out.println("Choose the ticket you want to buy");
				String ticketKind = br.readLine();

				if(ticketKind.equals("1"))
					currentTotal  += numberOfTickets * 2.50;
				else if(ticketKind.equals("2"))
					currentTotal  += numberOfTickets * 6.50;
				else if(ticketKind.equals("3"))
					currentTotal  += numberOfTickets * 5.00;
				else{
					System.out.println("Enter the correct Option( 1 2 3)");
					numberOfTickets = 0;
					continue;
				}
				while(true){
					System.out.println("Do you want more tickets? (y/n)");
					String str = br.readLine(); 
					if(str.equals("n"))
						return currentTotal;
					else if(str.equals("y"))
						break;
					else{
						System.out.println("Enter the correct Option (y/n)");
						continue;
					}
				}
			} catch (Exception e) {
				System.out.println("Try Again, Correctly This Time");
				continue;
			}
		}
	}
}
