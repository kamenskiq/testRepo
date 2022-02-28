/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String fruit = s.nextLine();
        String weekDay = s.nextLine();
        boolean errorFlag = false;
        double quantity = Double.parseDouble(s.nextLine());
        double price = 0.0;
        switch (weekDay) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday": {
                switch (fruit) {
                    case "banana": {
                        price = 2.50;
                    }
                    break;
                    case "apple": {
                        price = 1.20;
                    }
                    break;
                    case "orange": {
                        price = 0.85;
                    }
                    break;
                    case "grapefruit": {
                        price = 1.45;
                    }
                    break;
                    case "kiwi": {
                        price = 2.70;
                    }
                    break;
                    case "pinapple": {
                        price = 5.50;
                    }
                    break;
                    case "grapes": {
                        price = 3.85;
                    }
                    break;
                    default: {
                        errorFlag = true;
                        System.out.println("error");
                    }
                }
                break;

            }
            case "Saturday":
            case "Sunday": {
                switch (fruit) {
                    case "banana": {
                        price = 2.70;
                    }
                    break;
                    case "apple": {
                        price = 1.25;
                    }
                    break;
                    case "orange": {
                        price = 0.90;
                    }
                    break;
                    case "grapefruit": {
                        price = 1.60;
                    }
                    break;
                    case "kiwi": {
                        price = 3.00;
                    }
                    break;
                    case "pinapple": {
                        price = 5.60;
                    }
                    break;
                    case "grapes": {
                        price = 4.20;
                    }
                    break;
                    default: {
                        errorFlag = true;
                        System.out.println("error");
                    }
                }
                break;
            }
            default: {
                errorFlag = true;

                System.out.println("error");
            }
        }
        double total = (quantity * price);
        if (!errorFlag) {
            System.out.println(total);
        }
    }
}
