/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class ConditionalStatements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        int salary = Integer.parseInt(s.nextLine());
        
        boolean lostFlag = false;
        int i = 0;
        while (i < num) {
            String web = s.nextLine();
            switch (web) {
                case "Facebook": {
                    salary -= 150;
                }
                break;
                case "Instagram": {
                    salary -= 100;
                }
                break;
                case "Reddit": {
                    salary -= 50;
                }
                break;

            }
            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                i = num;
                lostFlag = true;
            }
            i++;
        }
        if(lostFlag){
            
        }else{
            System.out.println(salary);
            
        }
    }
}
