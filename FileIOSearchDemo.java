/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author vicky
 */
public class FileIOSearchDemo {

    protected Scanner inp;
    protected String searchTerm;
    
    public static void main(String[] args) throws FileNotFoundException{

        FileIOSearchDemo search = new FileIOSearchDemo();
        Scanner in = new Scanner(System.in);
        System.out.print("Search ID: ");
        search.searchTerm = in.nextLine();
        System.out.println("");

        search.searchInfo();

    }

    protected void searchInfo() throws FileNotFoundException{
        String filepath = "searchIO.txt";
        inp = new Scanner(new File(filepath));
        inp.useDelimiter("[,\n]");

        String ID = "";
        String name = "";
        String age = "";
        boolean check = false;

        while (inp.hasNext() && !check) {
            ID = inp.next();
            name = inp.next();
            age = inp.next();

            if (ID.equals(searchTerm)) {
                check = true;
            }

        }

        if (check) {
            System.out.println("Student ID: " + ID + "\nStudent Name: " + name + "\nStudent Age: " + age);
        } else {
            System.out.println("Student Info not found!");
        }

    }

}
