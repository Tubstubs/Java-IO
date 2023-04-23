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
public class FileIOEditDemo {

    protected Scanner inp;
    protected String editTerm;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        FileIOEditDemo edit = new FileIOEditDemo();
        System.out.print("Edit ID: ");
        edit.editTerm = in.nextLine();
        System.out.println("");
        edit.editInfo();

    }

    protected void editInfo() {
        String filepath = "sourceFile.txt";
        String editedFile = "tempFile.txt";

        String curLine = "";
        Scanner input = new Scanner(System.in);

        try {
            File origFile = new File(filepath);
            FileReader fr = new FileReader(origFile);
            BufferedReader br = new BufferedReader(fr);

            File newFile = new File(editedFile);
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            while ((curLine = br.readLine()) != null) {
                String[] values = curLine.split(",");
                if (values[0].equals(editTerm)) {
                    System.out.print("New ID: ");
                    values[0] = input.nextLine();
                    System.out.print("New Name: ");
                    values[1] = input.nextLine();
                    System.out.print("New Age: ");
                    values[2] = input.nextLine();

                    pw.println(values[0] + "," + values[1] + "," + values[2]);
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
