package com.theater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*Handle one problem only PG movies can be viewed only by people less than 13
 * Fix This*/

public class TheaterDemo {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			System.out.println("Pic a theater by number: 1. AMC and 2. Cinemark 3. Latino Theater");
			try {
				String theaterChoice = br.readLine();

				switch(theaterChoice)
				{
				case "1": AMC amc = new AMC();
				amc.moviePrint();
				break;

				case "2": Cinemark cine = new Cinemark();
				cine.moviePrint();
				break;

				case "3": Latino latin = new Latino();
				latin.moviePrint();
				break;

				default: 
					System.out.println("Please enter the correct option as above");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
