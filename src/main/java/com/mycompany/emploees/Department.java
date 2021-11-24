package com.mycompany.emploees;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Department {

    long departmentId;
    Date timeCreate;
    String departmentName;

    public Department() {
        departmentId = System.currentTimeMillis();
        timeCreate = new Date();
    }

    public Department(String s) {

        String[] splitArr = s.split(";");
        
        if (splitArr.length >= 3) {
            for (int i = 0; i < splitArr.length; i++) {
                this.departmentName = splitArr[0];
                this.departmentId = Long.valueOf(splitArr[1]);
               
                try {
                    this.timeCreate = new Date(Long.valueOf(splitArr[2]));
                } catch (NumberFormatException e) {
                    this.timeCreate = new Date();
                    Logger.getGlobal().log(Level.SEVERE, "Invalid Date Found");
                }
                System.out.println("IDX : " + i + " DATA : " + splitArr[i]);
            }
        }
    }

    @Override
    public String toString() {
        return decodeAddDepartment();
    }

    public String decodeAddDepartment() {

        return departmentName + ";" + departmentId + ";" + timeCreate.getTime();
    }

}
