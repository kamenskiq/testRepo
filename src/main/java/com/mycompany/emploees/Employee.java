package com.mycompany.emploees;

import java.util.ArrayList;

public class Employee extends Department {

    static void sort(ArrayList<Employee> userList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    long id;
    String name;
    long departmentId;
    int salary;

    public Employee() {
        id = System.currentTimeMillis();
    }

    public Employee(String s) throws Exception {
        String[] splitArr = s.split(";");
        if (splitArr.length >= 4) {
            for (int i = 0; i < splitArr.length; i++) {
                String string = splitArr[i];
                System.out.println("ID " + i + "  DataUser: " + string);
            }
            this.name = splitArr[0];
            this.departmentId = Long.valueOf(splitArr[1]);
            this.salary = Integer.valueOf(splitArr[2]);
            this.id = Long.valueOf(splitArr[3]);
        } else {
            throw new Exception("Invalid input : " + s);
        }
    }

    @Override
    public String toString() {
        return decodeUser();
    }

    public String decodeUser() {
        String decData = "";
        decData = name + ";" + departmentId + ";" + salary + ";" + id;
        return decData;
    }

}
