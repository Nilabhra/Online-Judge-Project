package testpackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Main
{
 public static void main(String agrs[]) throws NoSuchAlgorithmException, IOException {
       File f1=new File("sample1.txt");
       File f2=new File("sample2.txt");
       MessageDigest md = MessageDigest.getInstance("MD5");
       
       if(f1.exists() && f2.exists())
       {
           byte[] b1= Files.readAllBytes(f1.toPath());
           b1=md.digest(b1);
           
           md.reset();
           byte[] b2=Files.readAllBytes(f2.toPath());
           b2=md.digest(b2);
           
           
       }
    }
}
