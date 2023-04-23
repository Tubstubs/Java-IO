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
public class FileIOLesson {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException  {

        File file = new File("test.txt");
        PrintWriter pw = new PrintWriter(file);
//        
        pw.println("ang pogi ni christian");
        pw.println(100);
        pw.println('E');
        pw.close();
        
        
        
        Scanner in = new Scanner (file);
        System.out.println("Description: "+in.nextLine());
        System.out.println("Percentage: "+in.nextInt());
        System.out.println("Rate: "+in.next().charAt(0));
        
        
        
//        FileReader fr = new FileReader(file);
//        
//        int info;
//        while ((info=fr.read())!=-1){
//            System.out.print((char)info);
//        }
//        
//        fr.close();
        
//        
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//        
//        String line;
//        while ((line=br.readLine())!=null){
//            System.out.println(line);
//        }
        
        
        
        
        
        FileOutputStream fileO = new FileOutputStream(file);
        ObjectOutputStream objO = new ObjectOutputStream(fileO);

        objO.writeObject("Meow");
        objO.writeInt(24);
        objO.writeDouble(12.0);
        objO.close();
        
        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream objI = new ObjectInputStream(fi);

        try {
            while (true) {
                System.out.println(objI.readObject());
                System.out.println(objI.readInt());
                System.out.println(objI.readDouble());
                
            }
        } catch (EOFException ex) {

        }
        
        
    }

}
