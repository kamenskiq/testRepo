/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int age = Integer.parseInt(s.nextLine());
        double price = Double.parseDouble(s.nextLine());
        int toyPrice = Integer.parseInt(s.nextLine());
        int evenProfit = 0;
        int oddProfit = 0;
        double monney = 0;
        int odd = 0;
        int even = 0;
        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                even++;
                evenProfit += (even * 10);
            } else {
                odd++;
                oddProfit = odd * toyPrice;
            }

        }
        monney = (evenProfit - even) + oddProfit;
        if (monney >= price) {
            System.out.printf("Yes! %.2f", (monney - price));
        } else {
            System.out.printf("No! %.2f", (price - monney));
        }
    }
}
