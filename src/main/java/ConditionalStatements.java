
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
        int num;

        String name;
        double price;
        double allPrice = 0;

        budget = Double.parseDouble(s.nextLine());
        num = Integer.parseInt(s.nextLine());
        while (num != 0) {

            name = s.nextLine();
            price = Double.parseDouble(s.nextLine());
            switch (name) {
                case "Thrones": {
                    price = price - ((price * 50) / 100);
                }
                break;

                case "Lucifer": {
                    price = price - ((price * 40) / 100);
                }
                break;
                case "Protector": {
                    price = price - ((price * 30) / 100);
                }
                break;
                case "TotalDrama": {
                    price = price - ((price * 20) / 100);
                }
                break;
                case "Area": {
                    price = price - ((price * 10) / 100);
                }
                break;
            }

            num--;
            allPrice += price;
//            System.out.println("PRICE IS " + allPrice);
        }
        if (budget >= allPrice) {
            System.out.printf("You bought all the series and left with %.2f lv.", budget - allPrice);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", allPrice - budget);
        }
    }

}
