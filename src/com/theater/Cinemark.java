package com.theater;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Cinemark extends TheaterSet{

	private HashMap<String, String> cinemarkMovieMap= new HashMap<String, String>();
	private HashMap<String, String> cinemarkMovieListMap = new HashMap<String, String>();

	public Cinemark(){

		cinemarkMovieMap.put("1", "Avengers: Age of Ultron - PG");
		cinemarkMovieMap.put("2", "Magic Mike XXL - Rated R");
		cinemarkMovieMap.put("3", "Pitch Perfect - PG-13");

		cinemarkMovieListMap.put("Avengers: Age of Ultron - PG", "PG");
		cinemarkMovieListMap.put("Magic Mike XXL - Rated R", "PG-13");
		cinemarkMovieListMap.put("Pitch Perfect - PG-13", "PG-13");
	}

	public void moviePrint() {

		for (String key : cinemarkMovieMap.keySet()) {

			System.out.println(key+". " +cinemarkMovieMap.get(key));
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Double totalPrice = 0.00;
		System.out.println("Choose the movie you want to watch");
		while(true)
		{
			try {
				String movieChoice = br.readLine();
				if(cinemarkMovieMap.containsKey(movieChoice))
				{
					if(checkMovieRating(cinemarkMovieMap.get(movieChoice)))
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
		if(cinemarkMovieListMap.get(movieName).equals("PG"))
			return true;
		if(!movieRating.equals("Invalid")){
			if(movieRating.equals(cinemarkMovieListMap.get(movieName)))
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

				System.out.println("1. Kid - $2.50 2. Adult - $5.50 3. Senior - $4.00");
				System.out.println("Choose the ticket you want to buy");
				String ticketKind = br.readLine();

				if(ticketKind.equals("1"))
					currentTotal  += numberOfTickets * 2.50;
				else if(ticketKind.equals("2"))
					currentTotal  += numberOfTickets * 5.50;
				else if(ticketKind.equals("3"))
					currentTotal  += numberOfTickets * 4.00;
				else{
					System.out.println("Enter the correct Option( 1 2 3)");
					continue;
				}

				System.out.println("Do you want more tickets? (y/n)");
				String str = br.readLine(); 
				if(str.equals("n"))
					return currentTotal;
				else if(str.equals("y"))
					continue;
				else{
					System.out.println("Enter the correct Option (y/n)");
					continue;
				}
			} catch (Exception e) {
				System.out.println("Try Again, Correctly This Time");
				continue;
			}
		}
	}

}
