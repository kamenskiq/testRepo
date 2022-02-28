/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int hours = Integer.parseInt(s.nextLine());
        String day = s.nextLine();
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
            case "Saturday": {
                if (hours < 10 || hours > 18) {
                    System.out.println("closed");
                } else {
                    System.out.println("open");
                }
            }
            case "Sunday": {
                System.out.println("closed");
            }
        }
    }
}
