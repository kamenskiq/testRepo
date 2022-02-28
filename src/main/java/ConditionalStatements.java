/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String product = s.nextLine();

        switch (product) {
            case "banana":
            case "apple":
            case "kiwi":
            case "cherry":
            case "lemon":
            case "grapes": {
                System.out.println("fruit");
            }
            break;
            case "tomato":
            case "cucumber":
            case "pepper":
            case "carrot": {
                System.out.println("vegetable");
            }
            break;
            default: {
                System.out.println("unknown");
            }
        }
    }
}
