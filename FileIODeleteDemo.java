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
public class FileIODeleteDemo {

    protected Scanner inp;
    protected String deleteTerm;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        FileIODeleteDemo delete = new FileIODeleteDemo();
        System.out.print("Delete ID: ");
        delete.deleteTerm = in.nextLine();
        System.out.println("");
        delete.deleteInfo();

    }

    protected void deleteInfo() {
        String filepath = "sourceFile.txt";
        String deletedFile = "deletedFile.txt";

        String curLine = "";
        
        try {
            File origFile = new File(filepath);
            FileReader fr = new FileReader(origFile);
            BufferedReader br = new BufferedReader(fr);

            File newFile = new File(deletedFile);
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            while ((curLine = br.readLine()) != null) {
                String[] values = curLine.split(",");
                if (values[0].equals(deleteTerm)) {
                    values[0] = "";
                    values[1] = "";
                    values[2] = "";

                    pw.print(values[0] + values[1] + values[2]);
                    System.out.println("");
                    System.out.println("Info Updated!");
                } else {
                    pw.println(values[0] + "," + values[1] + "," + values[2]);
                }
            } 

            pw.flush();
            pw.close();
            bw.close();
            fw.close();
            br.close();
            fr.close();
            origFile.delete();
            File renew = new File(filepath);
            newFile.renameTo(renew);
            
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

    }
}
