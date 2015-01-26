import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




class Checker {
	String testout="testout.txt";
	Checker()
	{				
	     System.out.println("Checker"+System.getProperty("user.dir"));                                        
	}
	protected String compile(String l)
	{
                ProcessBuilder p;
		boolean compiled = true;
                if(l.equals("java"))
                    p= new ProcessBuilder("javac","Main.java");               
                else if(l.equals("c"))
                    p=new ProcessBuilder("gcc","-o","Main","Main.c");
                else
                    p=new ProcessBuilder("g++","-o","Main","Main.cpp");
                
                p.redirectErrorStream(true);
		
		try {			
			Process pp = p.start();
			InputStream is = pp.getInputStream();
                        String temp;
                    try (BufferedReader b = new BufferedReader(new InputStreamReader(is))) {
                        while((temp=b.readLine())!=null)
                        {
                            compiled=false;
                            System.out.println(temp);
                        }
                        pp.waitFor();
                    }
			
			if(!compiled)
				return "Compilation/Runtime Error >:3";
			
			return "Code compiled successfully :)";
			
			
		}
		catch(IOException | InterruptedException e)
				{
                                    System.out.println(e);
				}
		
		return "Compilation failed!";		
	}
	
	protected String execute(String l,String n)
	{		
                ProcessBuilder p;
                if(l.equals("java"))
                    p = new ProcessBuilder("java","Main");
                else if(l.equals("c"))
                    p = new ProcessBuilder("./Main");
                else
                    p = new ProcessBuilder("./Main");
                
                p.redirectInput(new File(n));           
		p.redirectErrorStream(true);
                p.redirectOutput(new File("out.txt"));
                
		String r="";
try {
			
			Process pp = p.start();
			InputStream is = pp.getInputStream();
                    try (BufferedReader b = new BufferedReader(new InputStreamReader(is))) {
                        String temp ;
                        pp.waitFor();
                        
                        while((temp=b.readLine())!=null)
                            r+=temp;
                    }
		}
		catch(IOException | InterruptedException ioe)
				{
					ioe.printStackTrace();
				}
		return r;
	}
        
        protected boolean match()
        {
            
            try {
                
                File f1=new File(testout);
                System.out.println("Test output exists? "+f1.exists());
                File f2=new File("out.txt");
                MessageDigest md = MessageDigest.getInstance("MD5");
                
                if(f1.exists() && f2.exists())
                {
                    byte[] b1= Files.readAllBytes(f1.toPath());
                    b1=md.digest(b1);  
                    md.reset();
                    byte[] b2=Files.readAllBytes(f2.toPath());
                    b2=md.digest(b2);
                    if(b1.length!=b2.length)
                        return false;
                    for(int i=0;i<b1.length;i++)
                    {
                        if(b1[i]!=b2[i])
                            return false;
                    }
                    
                }                
                
            } catch (NoSuchAlgorithmException | IOException ex) {
                System.out.println(ex);
            }
            return true;
            
        }

}
