package org.launchcode.exercises;


import java.util.HashMap;
import java.util.Map;

import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

    public static void main(String[] args) {

        // Test out your Divide() function!
        try {
            System.out.println(Divide(8, 4));
            System.out.println(Divide(8, 0));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        HashMap<String, String> studentFiles = new HashMap<>();
        studentFiles.put("Carl", "Program.java");
        studentFiles.put("Brad", "");
        studentFiles.put("Elizabeth", "MyCode.java");
        studentFiles.put("Stefanie", "CoolProgram.java");


        // Test out your CheckFileExtension() function!
            for (String key: studentFiles.keySet()){
                try {
                    int score = CheckFileExtension(studentFiles.get(key));
                    System.out.println("" + score);
                } catch (FileExtensionMismatchException e){
                    e.printStackTrace();
                }
            }
    }

    public static double Divide(int x, int y) {
        // Write code here!
        try {
            return x/y;
        } catch (ArithmeticException e){
            throw new ArithmeticException("Divide by zero");
        }
    }

    public static int CheckFileExtension(String fileName) throws FileExtensionMismatchException {
        // Write code here!
        String extension = "";
        int points = 0;

        int i = fileName.lastIndexOf('.');
        if (i > 0){
            extension = fileName.substring(i+1);
        }

        if (extension.equals("")|| extension.equals(null)){
            points += -1;
            throw new FileExtensionMismatchException("File extension not found");
        } else if (extension.equals("java")) {
            points += 1;
        }

        return points;
    }

}
