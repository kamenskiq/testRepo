/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int in = Integer.parseInt(s.nextLine());
        int numArr[] = new int[in];
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;
        int i = 0;
        while (i < in) {
            numArr[i] = Integer.parseInt(s.nextLine());
            i++;
        }

        for (int j = 0; j < in; j++) {
            if (numArr[j] < 200) {
                p1++;
            }
            if (numArr[j] >= 200 && numArr[j] <= 399) {
                p2++;
            }
            if (numArr[j] > 399 && numArr[j] <= 599) {
                p3++;
            }
            if (numArr[j] > 599 && numArr[j] <= 799) {
                p4++;
            }
            if (numArr[j] > 799) {
                p5++;
            }
        }
//        System.out.printf("P1 = %f P2 = %f P3 = %f P4 = %f P5 = %f\n", p1, p2, p3, p4, p5);

        System.out.printf("%.2f%%\n", (p1 = (p1 / in) * 100));
        System.out.printf("%.2f%%\n", (p2 = (p2 / in) * 100));
        System.out.printf("%.2f%%\n", (p3 = (p3 / in) * 100));
        System.out.printf("%.2f%%\n", (p4 = (p4 / in) * 100));
        System.out.printf("%.2f%%\n", (p5 = (p5 / in) * 100));
    }
}
