/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        int count = 0;
        for (int i = 0; i < in.length(); i++) {
            char n = in.charAt(i);

            switch (n) {
                case 'a': {
                    count += 1;
                }
                break;
                case 'e': {
                    count += 2;
                }
                break;
                case 'i': {
                    count += 3;
                }
                break;

                case 'o': {
                    count += 4;
                }
                break;
                case 'u': {
                    count += 5;
                }
                break;
            }
        }
        System.out.println(count);
    }
}
