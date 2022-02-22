/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double price = Double.parseDouble(scanner.nextLine());
        int puz = Integer.parseInt(scanner.nextLine());
        int kukla = Integer.parseInt(scanner.nextLine());
        int bear = Integer.parseInt(scanner.nextLine());
        int minon = Integer.parseInt(scanner.nextLine());
        int truck = Integer.parseInt(scanner.nextLine());
        double profit = (puz * 2.60) + (kukla * 3) + (bear * 4.10) + (minon * 8.20) + (truck * 2);
        double naem;
        int numToys = puz + kukla + bear + minon + truck;

        double discount;

        if (numToys >= 50) {
            discount = (profit * 0.25);
            profit = profit - discount;
            naem = (profit * 0.1);
            profit = profit - naem;

        } else {
            naem = profit * 0.1;
            profit = profit - naem;
        }
        if (profit <= price) {
            System.out.format("Not enough money! %.2f lv needed. ", (price - profit));
        }
        if (profit >= price) {
            System.out.format("Yes! %.2f lv left. ", (profit - price));

        }
    }

}
