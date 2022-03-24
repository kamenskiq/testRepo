
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double budget;
        String dest;
        String season = null;
        int numDays;

        double price = 0;

        budget = Double.parseDouble(s.nextLine());
        dest = s.nextLine();
        season = s.nextLine();
        numDays = s.nextInt();

        switch (dest) {
            case "Dubai": {
                switch (season) {
                    case "Winter": {
                        price = (numDays * 45000) - (((numDays * 45000) * 30) / 100);
                    }
                    break;
                    case "Summer": {
                       price = (numDays * 40000) - (((numDays * 40000) * 30) / 100);
                    }
                    break;
                }
                if (budget >= price) {
                    System.out.printf("The budget for the movie is enough! We have %.2f leva left!", (budget - price));

                } else {
                    System.out.printf("The director needs %.2f leva more!", (price - budget));
                }
            }break;
            case "Sofia":{
                switch (season) {
                    case "Winter": {
                        price = (numDays * 17000) + (((numDays * 17000) * 25) / 100);
                    }
                    break;
                    case "Summer": {
                       price = (numDays * 12000) + (((numDays * 12000) * 25) / 100);
                    }
                    break;
                }
                if (budget >= price) {
                    System.out.printf("The budget for the movie is enough! We have %.2f leva left!", (budget - price));

                } else {
                    System.out.printf("The director needs %.2f leva more!", (price - budget));
                }
            }break;
            case "London" :{
                switch (season) {
                    case "Winter": {
                        price = (numDays * 24000);
                    }
                    break;
                    case "Summer": {
                       price = (numDays * 20250);
                    }
                    break;
                }
                if (budget >= price) {
                    System.out.printf("The budget for the movie is enough! We have %.2f leva left!", (budget - price));

                } else {
                    System.out.printf("The director needs %.2f leva more!", (price - budget));
                }
            }break;
        }

    }

}
