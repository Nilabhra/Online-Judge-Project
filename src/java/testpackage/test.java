/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajarshee
 */
public class test {
    
    public static void main(String ar[])
    {
        File f=new File("Main.class");
        System.out.println(f.exists());
        
        System.out.println("Dir:"+System.getProperty("user.dir"));
        ProcessBuilder pb = new ProcessBuilder("java","Main");
        
        pb.redirectInput(new File("in.txt"));
        pb.redirectOutput(new File("out.txt"));
        pb.redirectErrorStream(true);
        
        try {
            Process p=pb.start();            
            
            BufferedReader b=new BufferedReader(new InputStreamReader(p.getInputStream()));
            String t;
            p.waitFor();
            while((t=b.readLine())!=null)            
                System.out.println(t);
            
            
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
