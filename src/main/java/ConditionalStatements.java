/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int numStat = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
double totalPrice;
        double decor = budget * 0.1;
        if (numStat > 150) {
           totalPrice = numStat * (price - (price * 0.1));
        }
        else {
            totalPrice = numStat * price;
        }
        if ((totalPrice + decor) > budget) {
            System.out.println("Not enough money!");
            System.out.format("Wingard needs %.2f leva more.", ((totalPrice + decor) - budget));
        }
        if ((totalPrice + decor) <= budget) {
            System.out.println("Action!");
            System.out.format("Wingard starts filming with %.2f leva left.", (budget - (totalPrice + decor)));
        }
    }

}
