/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numGroup = Integer.parseInt(s.nextLine());
        int numPeople = 0;
        double allPeople = 0;
        double m1 = 0;
        double m2 = 0;
        double m3 = 0;
        double m4 = 0;
        double m5 = 0;
        double i = 0;

        while (i < numGroup) {
            numPeople = Integer.parseInt(s.nextLine());
            if (numPeople <= 5) {
                m1 += numPeople;
            } else if (numPeople >= 6 && numPeople <= 12) {
                m2 += numPeople;
            } else if (numPeople >= 13 && numPeople <= 25) {
                m3 += numPeople;
            } else if (numPeople >= 26 && numPeople <= 40) {
                m4 += numPeople;
            } else if (numPeople >= 41) {
                m5 += numPeople;
            }
            i++;
        }
        allPeople = m1 + m2 + m3 + m4 + m5;
        System.out.printf("%.2f%%\n", ((m1 / allPeople) * 100));
        System.out.printf("%.2f%%\n", (m2 / allPeople) * 100);
        System.out.printf("%.2f%%\n", (m3 / allPeople) * 100);
        System.out.printf("%.2f%%\n", (m4 / allPeople) * 100);
        System.out.printf("%.2f%%\n", (m5 / allPeople) * 100);

    }
}
