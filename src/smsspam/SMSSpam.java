/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smsspam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author adda
 */
public class SMSSpam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("result.txt");
        ArrayList<String> al = readFile("smsSpam.txt");
        System.out.println("ham\tspam");
        pw.println("ham\tspam");
        for (String s : al) {
            if (s.startsWith("ham")) {
                System.out.println("1\t0\t" + s.substring(3).trim());
                pw.println("1\t0\t" + s.substring(3).trim());
            } else {
                System.out.println("0\t1\t" + s.substring(4).trim());
                pw.println("0\t1\t" + s.substring(4).trim());
            }

        }
        pw.close();
    }

    public static ArrayList<String> readFile(String file) {
        ArrayList<String> al = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    al.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return al;
    }

}
